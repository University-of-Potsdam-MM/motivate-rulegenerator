package de.unipotsdam.rulegenerator.statistics.assembly;

import de.unipotsdam.rulegenerator.ontology.StartAction;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.statistics.StatisticsList;
import org.semanticweb.owlapi.model.OWLOntology;

import java.util.Collection;

public class StartActionStatisticsAssembly extends ActionStatisticsAssembly {
	public StartActionStatisticsAssembly(OWLOntology ontology) {
		super(ontology);
	}

	public StatisticsList generateStatistics() {

		// create model to use for answering SPARQL queries
		createModel();

		for (MyLearningUnit currentLearningUnit : learningUnits) {
			//String lid = currentLearningUnit.getID().toString();
			Collection<? extends StartAction> startActions = currentLearningUnit
					.getStartActions();

			for (StartAction startAction : startActions) {
				action = startAction.getOwlIndividual().getIRI().toQuotedString();

				// execute SPARQL-queries on model and accumulate results
				collectReasonsForGivenAction();
			}
		}
		return reasons;
	}
}
