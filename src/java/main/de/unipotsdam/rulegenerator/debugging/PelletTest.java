package de.unipotsdam.rulegenerator.debugging;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;

import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public class PelletTest {

	private PelletReasoner reasoner;
	private OWLOntologyManager manager;
	private OWLOntology ontology;

	public static void main(String[] args) throws Exception {
		new PelletTest();
	}

	private PelletTest() throws OWLOntologyCreationException,
			OWLOntologyStorageException, IOException {
		manager = OWLManager.createOWLOntologyManager();
		ontology = manager.loadOntologyFromOntologyDocument(new File(
				"knowledge.owl"));
		reasoner = PelletReasonerFactory.getInstance()
				.createNonBufferingReasoner(ontology);
		manager.addOntologyChangeListener(reasoner);

		// To generate an inferred ontology we use implementations of inferred
		// axiom generators
		// to generate the parts of the ontology we want (e.g. subclass axioms,
		// equivalent classes
		// axioms, class assertion axiom etc. - see the
		// org.semanticweb.owlapi.util package for more
		// implementations).
		// Set up our list of inferred axiom generators
		List<InferredAxiomGenerator<? extends OWLAxiom>> generators = new ArrayList<InferredAxiomGenerator<? extends OWLAxiom>>();

		generators.add(new InferredSubClassAxiomGenerator());
		generators.add(new InferredClassAssertionAxiomGenerator());
		generators.add(new InferredPropertyAssertionGenerator());

		// Put the inferred axioms into a fresh empty ontology - note that there
		// is nothing stopping us stuffing them back into the original asserted
		// ontology
		// if we wanted to do this.
		//OWLOntology inferredOntology = manager.createOntology();

		// Now get the inferred ontology generator to generate some inferred
		// axioms
		// for us (into our fresh ontology). We specify the reasoner that we
		// want
		// to use and the inferred axiom generators that we want to use.
		InferredOntologyGenerator iog = new InferredOntologyGenerator(reasoner);
		iog.fillOntology(manager, ontology);

		// Save the inferred ontology. (Replace the URI with one that is
		// appropriate for your setup)
		manager.saveOntology(ontology, new FileOutputStream(
				"knowledge-inferred.owl"));

		MyFactory factory = new MyFactory(ontology);
		Collection<? extends LearningUnit> learningUnits = factory
				.getAllLearningUnitInstances();

		// System.out.println(Arrays.toString(learningUnits.toArray()));
		System.out.println("<LearningUnits>");
		for (LearningUnit learningUnit : learningUnits) {
			MyLearningUnit myLearningUnit = (MyLearningUnit) learningUnit;
			myLearningUnit.description(1);
		}
		System.out.println("</LearningUnits>");
	}
}
