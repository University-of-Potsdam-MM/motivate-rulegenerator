package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.impl.FactoryHelper;
import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.ontology.FeatureConstraint;
import de.unipotsdam.rulegenerator.ontology.GeneratedFactory;
import de.unipotsdam.rulegenerator.ontology.LearningUnitConstraint;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultFeatureConstraint;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnitConstraint;

public class MyFactory extends GeneratedFactory {
	private FactoryHelper delegate;
	
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
