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
 * Source Class: DefaultRestrictContentConstraintHead <br>
 * @version generated on Fri Jul 25 16:06:55 CEST 2014 by tobias
 */
public class DefaultRestrictContentConstraintHead extends WrappedIndividualImpl implements RestrictContentConstraintHead {

    public DefaultRestrictContentConstraintHead(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasConstraintHeadLogicalOperator
     */
     
    public Collection<? extends Object> getHasConstraintHeadLogicalOperator() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONSTRAINTHEADLOGICALOPERATOR, Object.class);
    }

    public boolean hasHasConstraintHeadLogicalOperator() {
		return !getHasConstraintHeadLogicalOperator().isEmpty();
    }

    public void addHasConstraintHeadLogicalOperator(Object newHasConstraintHeadLogicalOperator) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONSTRAINTHEADLOGICALOPERATOR, newHasConstraintHeadLogicalOperator);
    }

    public void removeHasConstraintHeadLogicalOperator(Object oldHasConstraintHeadLogicalOperator) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONSTRAINTHEADLOGICALOPERATOR, oldHasConstraintHeadLogicalOperator);
    }


}
