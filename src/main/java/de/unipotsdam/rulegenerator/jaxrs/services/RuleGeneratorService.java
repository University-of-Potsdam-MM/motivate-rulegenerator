package de.unipotsdam.rulegenerator.jaxrs.services;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.MissingArgumentException;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.UnparsableOntologyException;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
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
	public static AdaptationRuleList generateAdaptationRules(String aBox, String ontologyId) throws Exception {
		manager = OWLManager.createOWLOntologyManager();
		// load received ontology
		try {
			ontology = manager.loadOntologyFromOntologyDocument(new ByteArrayInputStream(aBox.getBytes(StandardCharsets.UTF_8)));
		} catch (NullPointerException e) {
			throw new MissingArgumentException("You need to provide an ontology to generate rules from.");
		} catch (UnparsableOntologyException e) {
			throw new Exception("The provided ontology seems to be malformed. Please check that the ontology was URL encoded.");
		}
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
