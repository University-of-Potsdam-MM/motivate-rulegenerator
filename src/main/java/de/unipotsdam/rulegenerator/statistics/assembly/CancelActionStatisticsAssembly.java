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
				action = cancelAction.getOwlIndividual().getIRI().toQuotedString();
				collectReasonsForGivenAction();
			}
		}
		return reasons;
	}
}
