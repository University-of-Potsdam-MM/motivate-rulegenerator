package de.unipotsdam.rulegenerator.statistics;

import java.util.Collection;

import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDFS;

import de.unipotsdam.rulegenerator.ontology.CancelAction;
import de.unipotsdam.rulegenerator.ontology.StartAction;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public class StatisticsFactory {
	private OWLOntology ontology;
	private MyFactory factory;

	public StatisticsFactory(OWLOntology ontology) {
		super();

		this.ontology = ontology;
		// create ORM object factory
		factory = new MyFactory(ontology);
	}

	public StatisticsList generateStatistics() throws Exception {
		Collection<? extends MyLearningUnit> learningUnits = factory
				.getAllLearningUnitInstances();

		for (MyLearningUnit currentLearningUnit : learningUnits) {
			// collect actions by type

			Collection<? extends StartAction> startActions = currentLearningUnit
					.getStartActions();

			// START

			// collect reasons for action

			// determine most relevant context information for the action

			// for each context information identify:
			// value range
			// value mean
			// occurrence percentage
			// partnering context information

			// PAUSE

			// FINISH

			// CANCEL
			
			Collection<? extends CancelAction> cancelActions = currentLearningUnit
					.getCancelActions();

			for (CancelAction cancelAction : cancelActions) {
				PelletReasoner reasoner = PelletReasonerFactory.getInstance()
						.createNonBufferingReasoner(ontology);
				// Get the KB from the reasoner
				KnowledgeBase kb = reasoner.getKB();
				// Create a Pellet graph using the KB from OWLAPI
				PelletInfGraph graph = new org.mindswap.pellet.jena.PelletReasoner()
						.bind(kb);
				// Wrap the graph in a model
				InfModel model = ModelFactory.createInfModel(graph);
				// Use the model to answer SPARQL queries

				String queryString = "PREFIX kno: <http://motivate-project.de/ontology/knowledge.owl#> "
						+ "PREFIX rdfs: <" + RDFS.getURI() + "> "
						+ "PREFIX owl: <" + OWL.getURI() + "> "
						+ "SELECT ?r WHERE {"
							+ "?r a kno:RecordedContextInformation ."
						//		+ "kno:isRecordedContextInformationOf ?u "
						//	+ "?u a kno:User ;"
						//		+ "kno:hasAction " + cancelAction.getOwlIndividual().getIRI()
						+ "}";
				Query query = QueryFactory.create(queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				com.hp.hpl.jena.query.ResultSet results = qe.execSelect();

				ResultSetFormatter.out(System.out, results, query);
				qe.close();
			}

		}

		return null;
	}
}
