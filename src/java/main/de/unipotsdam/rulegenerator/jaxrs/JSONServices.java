package de.unipotsdam.rulegenerator.jaxrs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;

import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.unipotsdam.rulegenerator.jaxrs.services.ContextInformationService;
import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.ContextInformation;
import de.unipotsdam.rulegenerator.rules.ContextInformationList;
import de.unipotsdam.rulegenerator.rules.RuleFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONServices.
 */
@Path("/json")
public class JSONServices extends Services {

	/**
	 * Context information json.
	 * 
	 * @return the context information list
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@GET
	@Path("/get-context-information")
	@Produces(MediaType.APPLICATION_JSON)
	public ContextInformationList getContextInformation()
			throws JsonParseException, JsonMappingException, IOException {
		return ContextInformationService.getContextInformation();
	}

	/**
	 * Context information json.
	 * 
	 * @param id
	 *            the id
	 * @return the context information
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@GET
	@Path("/get-context-information/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ContextInformation getContextInformation(@PathParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		return ContextInformationService.getContextInformation(id);
	}

	@GET
	@Path("/generate-adaptation-rules/{ontologyABox}/{ontologyId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String generateAdaptationRules(
			@PathParam("ontologyABox") String ABox,
			@PathParam("ontologyId") String ontologyId)
			throws TransformerFactoryConfigurationError, TransformerException,
			FileNotFoundException, UnsupportedEncodingException,
			OWLOntologyCreationException {
		// Write received ontology to file system
		String ontologyFileName = ontologyId + ".owl";
		PrintWriter writer = new PrintWriter("src/" + ontologyFileName, "UTF-8");
		writer.println(ABox);
		writer.close();
		// initialize ontology manager
		manager = OWLManager.createOWLOntologyManager();
		// load received ontology
		ontology = manager.loadOntologyFromOntologyDocument(new File(
				"motivate-ontology.owl"));
		// get data factory
		dataFactory = manager.getOWLDataFactory();
		// set default IRI
		String defaultIri = "http://www.motivate-project.de/ontologies/knowledge#";
		PrefixManager prefixManager = new DefaultPrefixManager(defaultIri);
		// get Pellet reasoner
		reasoner = PelletReasonerFactory.getInstance()
				.createNonBufferingReasoner(ontology);
		// listen for ontology changes (might be unnecessary)
		manager.addOntologyChangeListener(reasoner);
		// set up list of inferred axiom generators
		List<InferredAxiomGenerator<? extends OWLAxiom>> generators = new ArrayList<InferredAxiomGenerator<? extends OWLAxiom>>();
		generators.add(new InferredSubClassAxiomGenerator());
		generators.add(new InferredClassAssertionAxiomGenerator());
		generators.add(new InferredPropertyAssertionGenerator());
		// create inferred ontology generator
		InferredOntologyGenerator iog = new InferredOntologyGenerator(reasoner);
		// fill inferred ontology into the existing one
		iog.fillOntology(manager, ontology);
		// create ORM object factory
		MyFactory factory = new MyFactory(ontology);
		// get all learning unit individuals from ontology
		Collection<? extends LearningUnit> learningUnits = factory
				.getAllLearningUnitInstances();
		// create rule factory
		RuleFactory ruleFactory = new RuleFactory(learningUnits);
		// generate rules
		AdaptationRuleList adaptationRuleList = ruleFactory.generateRules();

		String xml;
		StringWriter stringWriter = new StringWriter();
		try {
			JAXBContext context = JAXBContext
					.newInstance(AdaptationRuleList.class);
			Marshaller carMarshaller = context.createMarshaller();
			carMarshaller.marshal(adaptationRuleList, stringWriter);
			xml = stringWriter.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

		String xslt = new Scanner(new File("resources/noolsJSON.xslt"))
				.useDelimiter("\\Z").next();

		StringWriter xmlResultResource = new StringWriter();

		Transformer xmlTransformer = TransformerFactory.newInstance()
				.newTransformer(new StreamSource(new StringReader(xslt)));

		xmlTransformer.transform(new StreamSource(new StringReader(xml)),
				new StreamResult(xmlResultResource));

		return xmlResultResource.getBuffer().toString();
	}
}
