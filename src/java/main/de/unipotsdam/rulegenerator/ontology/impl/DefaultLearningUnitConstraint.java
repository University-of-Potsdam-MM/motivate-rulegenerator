package de.unipotsdam.rulegenerator.ontology.impl;

import de.unipotsdam.rulegenerator.ontology.*;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultLearningUnitConstraint <br>
 * @version generated on Fri Aug 15 16:43:34 CEST 2014 by tobias
 */
public class DefaultLearningUnitConstraint extends WrappedIndividualImpl implements LearningUnitConstraint {

    public DefaultLearningUnitConstraint(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.motivate-project.de/ontologies/knowledge#hasConstraintMetaData
     */
     
    public Collection<? extends WrappedIndividual> getHasConstraintMetaData() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASCONSTRAINTMETADATA,
                                               WrappedIndividualImpl.class);
    }

    public boolean hasHasConstraintMetaData() {
	   return !getHasConstraintMetaData().isEmpty();
    }

    public void addHasConstraintMetaData(WrappedIndividual newHasConstraintMetaData) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASCONSTRAINTMETADATA,
                                       newHasConstraintMetaData);
    }

    public void removeHasConstraintMetaData(WrappedIndividual oldHasConstraintMetaData) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASCONSTRAINTMETADATA,
                                          oldHasConstraintMetaData);
    }


}
