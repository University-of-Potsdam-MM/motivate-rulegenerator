package de.unipotsdam.rulegenerator.statistics.assembly;

import java.util.Collection;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public abstract class ActionStatisticsAssembly extends StatisticsAssembly {
	protected Collection<? extends MyLearningUnit> learningUnits;
	
	public ActionStatisticsAssembly(OWLOntology ontology) {
		this.ontology = ontology;
		MyFactory factory = new MyFactory(ontology);
		this.learningUnits = factory.getAllLearningUnitInstances();
	}
	
	public Collection<? extends LearningUnit> getLearningUnits() {
		return learningUnits;
	}

	public void setLearningUnits(
			Collection<? extends MyLearningUnit> learningUnits) {
		this.learningUnits = learningUnits;
	}
}
