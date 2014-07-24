package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: RestrictVideoPlaybackConstraintHead <br>
 * @version generated on Mon Jul 21 15:11:15 CEST 2014 by tobias
 */

public interface RestrictVideoPlaybackConstraintHead extends ConstraintHead {

    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/motivate.owl#hasConstraintHeadLogicalOperator
     */
     
    /**
     * Gets all property values for the hasConstraintHeadLogicalOperator property.<p>
     * 
     * @returns a collection of values for the hasConstraintHeadLogicalOperator property.
     */
    Collection<? extends Object> getHasConstraintHeadLogicalOperator();

    /**
     * Checks if the class has a hasConstraintHeadLogicalOperator property value.<p>
     * 
     * @return true if there is a hasConstraintHeadLogicalOperator property value.
     */
    boolean hasHasConstraintHeadLogicalOperator();

    /**
     * Adds a hasConstraintHeadLogicalOperator property value.<p>
     * 
     * @param newHasConstraintHeadLogicalOperator the hasConstraintHeadLogicalOperator property value to be added
     */
    void addHasConstraintHeadLogicalOperator(Object newHasConstraintHeadLogicalOperator);

    /**
     * Removes a hasConstraintHeadLogicalOperator property value.<p>
     * 
     * @param oldHasConstraintHeadLogicalOperator the hasConstraintHeadLogicalOperator property value to be removed.
     */
    void removeHasConstraintHeadLogicalOperator(Object oldHasConstraintHeadLogicalOperator);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
