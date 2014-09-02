package de.unipotsdam.rulegenerator.jaxrs.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;

import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.RuleFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class RuleGeneratorService.
 */
public class RuleGeneratorService {
	protected static PelletReasoner reasoner;
	protected static OWLDataFactory dataFactory;
	protected static OWLOntologyManager manager;
	protected static OWLOntology ontology;

	/**
	 * Generate adaptation rules.
	 * 
	 * @return the adaptation rule list
	 * @throws Exception
	 */
	public static AdaptationRuleList generateAdaptationRules() throws Exception {
		manager = OWLManager.createOWLOntologyManager();
		// load received ontology
		ontology = manager.loadOntologyFromOntologyDocument(new File(
				"example.owl"));
		// get data factory
				dataFactory = manager.getOWLDataFactory();
		OWLImportsDeclaration importDeclaraton = dataFactory
				.getOWLImportsDeclaration(IRI.create(new File(
						"knowledge.owl")));
		manager.applyChange(new AddImport(ontology, importDeclaraton));
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
		// create rule factory
		RuleFactory ruleFactory = new RuleFactory(ontology);
		// generate rules
		AdaptationRuleList adaptationRuleList = ruleFactory.generateRules();

		return adaptationRuleList;
	}
}
