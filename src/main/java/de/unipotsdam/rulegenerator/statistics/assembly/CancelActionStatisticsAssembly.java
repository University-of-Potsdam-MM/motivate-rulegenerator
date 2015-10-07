package de.unipotsdam.rulegenerator.statistics.assembly;

import java.util.Collection;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.ontology.CancelAction;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;

public class CancelActionStatisticsAssembly extends ActionStatisticsAssembly {
	public CancelActionStatisticsAssembly(OWLOntology ontology) {
		super(ontology);
	}

	public StatisticsList generateStatistics() {

		// create model to use for answering SPARQL queries
		createModel();

		for (MyLearningUnit currentLearningUnit : learningUnits) {
			//String lid = currentLearningUnit.getID().toString();
			Collection<? extends CancelAction> cancelActions = currentLearningUnit
					.getCancelActions();

			for (CancelAction cancelAction : cancelActions) {
				action = cancelAction.getOwlIndividual().getIRI().toQuotedString();

				// execute SPARQL-queries on model and accumulate results
				collectReasonsForGivenAction();
			}
		}
		return reasons;
	}
}