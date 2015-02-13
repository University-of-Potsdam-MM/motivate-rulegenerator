package de.unipotsdam.rulegenerator.jaxrs.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.MissingArgumentException;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.UnparsableOntologyException;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyAlreadyExistsException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.ontology.OntologyException;

// TODO: Auto-generated Javadoc
/**
 * The Class Service.
 */
public class Service {
	
	/** The reasoner. */
	protected static PelletReasoner reasoner;
	
	/** The data factory. */
	protected static OWLDataFactory dataFactory;
	
	/** The manager. */
	protected static OWLOntologyManager manager;
	
	/** The ontology. */
	protected static OWLOntology ontology;

	static {
		manager = OWLManager.createOWLOntologyManager();
		dataFactory = manager.getOWLDataFactory();
	}

	/**
	 * Load ontology.
	 *
	 * @param aBox the a box
	 * @throws Exception the exception
	 */
	public static void loadOntology(String aBox) throws Exception {
		try {
			ontology = manager
					.loadOntologyFromOntologyDocument(new ByteArrayInputStream(
							aBox.getBytes(StandardCharsets.UTF_8)));
		} catch (NullPointerException e) {
			throw new MissingArgumentException(
					"You need to provide an ontology to generate rules from.");
		} catch (UnparsableOntologyException e) {
			throw new Exception(
					"The provided ontology seems to be malformed. Please check that the ontology was URL encoded.");
		} catch (OWLOntologyAlreadyExistsException e) {
			
		}
	}

	/**
	 * Load ontology.
	 *
	 * @param file the file
	 * @throws Exception the exception
	 */
	public static void loadOntology(File file) throws Exception {
		try {
			ontology = manager.loadOntologyFromOntologyDocument(file);
		} catch (NullPointerException e) {
			throw new MissingArgumentException(
					"You need to provide an ontology to generate rules from.");
		} catch (UnparsableOntologyException e) {
			throw new Exception(
					"The provided ontology seems to be malformed. Please check that the ontology was URL encoded.");
		} catch (OWLOntologyAlreadyExistsException e) {
			
		}
	}

	public static void loadPelletReasoner() {
		reasoner = PelletReasonerFactory.getInstance()
				.createNonBufferingReasoner(ontology);
	}
	
	/**
	 * Infer ontology.
	 */
	public static void inferOntology() {
		// get Pellet reasoner
		loadPelletReasoner();
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
	}
}
