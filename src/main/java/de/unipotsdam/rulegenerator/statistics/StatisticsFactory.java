package de.unipotsdam.rulegenerator.statistics;

import java.util.Collection;

import org.semanticweb.owlapi.model.OWLOntology;

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
		Collection<? extends MyLearningUnit> learningUnits = factory.getAllLearningUnitInstances();
		
		for (MyLearningUnit currentLearningUnit : learningUnits) {
			// collect actions by type
			
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
			
			
		}
		
		return null;
	}
}
