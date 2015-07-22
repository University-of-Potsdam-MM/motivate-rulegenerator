package de.unipotsdam.rulegenerator.statistics.assembly;

import java.util.Collection;

import com.hp.hpl.jena.query.*;
import de.unipotsdam.rulegenerator.statistics.Reason;
import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.semanticweb.owlapi.model.OWLOntology;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import de.unipotsdam.rulegenerator.ontology.CancelAction;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;

public class CancelActionStatisticsAssembly extends ActionStatisticsAssembly {
	public CancelActionStatisticsAssembly(OWLOntology ontology) {
		super(ontology);
	}

	public StatisticsList generateStatistics() {

		for (MyLearningUnit currentLearningUnit : learningUnits) {
			String lid = currentLearningUnit.getID().toString();
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

				action = cancelAction.getOwlIndividual().getIRI().toQuotedString();
				String firstQuery = null;
				String secondQuery = null;

				try {
					firstQuery = getFirstQuery();

					//"select * where {"+action+" ?x ?z. ?a ?b "+action+". }"
					Query fquery = QueryFactory.create(firstQuery);
					QueryExecution fqe = QueryExecutionFactory.create(fquery, model);
					ResultSet results = fqe.execSelect();
					//ResultSetFormatter.out(System.out, results, fquery);

					while(results.hasNext()) {
						QuerySolution row = results.next();
						user = row.get("user");
						actTime = row.get("actTime");
						recTime = row.get("recTime");

						secondQuery = getSecondQuery();
						Query squery = QueryFactory.create(secondQuery);
						QueryExecution sqe = QueryExecutionFactory.create(squery, model);
						ResultSet finalResults = sqe.execSelect();
						ResultSetFormatter.out(System.out, finalResults, squery);

						while (finalResults.hasNext()) {
							QuerySolution srow = finalResults.next();
							lu = srow.get("lu");
							recContext = srow.get("recContext");
							metaDataProp = srow.get("metaDataProp");
							metaDataValue = srow.get("metaDataValue");

							Reason reason = new Reason();
							reason.setAction(action);
							reason.setActionTime(actTime);
							reason.setUser(user);
							reason.setRecordedTime(recTime);
							reason.setLearningUnit(lu);
							reason.setRecordedContextInformation(recContext);
							reason.setMetaDataProperty(metaDataProp);
							reason.setMetaDataValue(metaDataValue);

							reasons.addReason(reason);
						}
						sqe.close();
					}
					fqe.close();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		return reasons;
	}
}
