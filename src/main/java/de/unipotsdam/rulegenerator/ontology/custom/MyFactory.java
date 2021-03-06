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
    public Collection<? extends MyRestrictFeatureConstraint> getAllFeatureConstraintInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESTRICTFEATURECONSTRAINT, MyRestrictFeatureConstraint.class);
    }
    
    /**
     * Gets all instances of LearningUnitConstraint from the ontology.
     */
    public Collection<? extends MyLearningUnitClassConstraint> getAllLearningUnitConstraintInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_LEARNINGUNITCLASSCONSTRAINT, MyLearningUnitClassConstraint.class);
    }
    
    /**
     * Gets all instances of MeasurableContextInformation from the ontology.
     */
    public Collection<? extends MyContextInformation> getAllMeasurableContextInformationInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CONTEXTINFORMATION, MyContextInformation.class);
    }
}
