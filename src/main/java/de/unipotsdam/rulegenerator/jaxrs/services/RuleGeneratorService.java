package de.unipotsdam.rulegenerator.jaxrs.services;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.MissingArgumentException;
import org.protege.editor.owl.ui.ontology.imports.wizard.page.LoadedOntologyPage;
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
public class RuleGeneratorService extends Service {
	/**
	 * Generate adaptation rules.
	 * 
	 * @return the adaptation rule list
	 * @throws Exception
	 */
	public static AdaptationRuleList generateAdaptationRules(String aBox,
			String ontologyId) throws Exception {
		// load received ontology
		loadOntology(aBox);
		// infer
		inferOntology();
		// create rule factory
		RuleFactory ruleFactory = new RuleFactory(ontology);
		// generate rules
		AdaptationRuleList adaptationRuleList = ruleFactory.generateRules();

		return adaptationRuleList;
	}
}
