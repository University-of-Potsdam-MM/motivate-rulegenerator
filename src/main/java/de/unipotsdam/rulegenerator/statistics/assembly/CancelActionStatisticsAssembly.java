package de.unipotsdam.rulegenerator.statistics.assembly;

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
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;

public class CancelActionStatisticsAssembly extends ActionStatisticsAssembly {
	public CancelActionStatisticsAssembly(OWLOntology ontology) {
		super(ontology);
	}

	public StatisticsList generateStatistics() {
		for (MyLearningUnit currentLearningUnit : learningUnits) {
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
						+ "PREFIX rdfs: <"
						+ RDFS.getURI()
						+ "> "
						+ "PREFIX owl: <"
						+ OWL.getURI()
						+ "> "
						+ "SELECT ?r WHERE {"
						+ "?r a kno:RecordedContextInformation ;"
						+ "kno:isRecordedContextInformationOf ?u . "
						+ "?u a kno:User . }";
						//+ "kno:hasAction "
						//+ cancelAction.getOwlIndividual().getIRI() + " . }";
				Query query = QueryFactory.create(queryString);
				QueryExecution qe = QueryExecutionFactory.create(query, model);
				com.hp.hpl.jena.query.ResultSet results = qe.execSelect();

				ResultSetFormatter.out(System.out, results, query);
				qe.close();
			}
		}

		return reasons;
	}
}