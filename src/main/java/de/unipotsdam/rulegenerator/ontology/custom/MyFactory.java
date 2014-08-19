package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.ontology.GeneratedFactory;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;

public class MyFactory extends GeneratedFactory {
	public MyFactory(OWLOntology ontology) {
		super(ontology);
		// TODO Auto-generated constructor stub
	}

	/**
     * Gets all instances of LearningUnit from the ontology.
     */
    public Collection<? extends MyLearningUnit> getAllLearningUnitInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LEARNINGUNIT, MyLearningUnit.class);
    }
    
    /**
     * Gets all instances of FeatureConstraint from the ontology.
     */
    public Collection<? extends MyFeatureConstraint> getAllFeatureConstraintInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_FEATURECONSTRAINT, MyFeatureConstraint.class);
    }
    
    /**
     * Gets all instances of LearningUnitConstraint from the ontology.
     */
    public Collection<? extends MyLearningUnitConstraint> getAllLearningUnitConstraintInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LEARNINGUNITCONSTRAINT, MyLearningUnitConstraint.class);
    }
}
