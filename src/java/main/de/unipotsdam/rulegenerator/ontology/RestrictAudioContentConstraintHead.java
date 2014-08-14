package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: RestrictAudioContentConstraintHead <br>
 * @version generated on Wed Aug 13 14:30:39 CEST 2014 by tobias
 */

public interface RestrictAudioContentConstraintHead extends ConstraintHead {

    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasConstraintTail
     */
     
    /**
     * Gets all property values for the hasConstraintTail property.<p>
     * 
     * @returns a collection of values for the hasConstraintTail property.
     */
    Collection<? extends WrappedIndividual> getHasConstraintTail();

    /**
     * Checks if the class has a hasConstraintTail property value.<p>
     * 
     * @return true if there is a hasConstraintTail property value.
     */
    boolean hasHasConstraintTail();

    /**
     * Adds a hasConstraintTail property value.<p>
     * 
     * @param newHasConstraintTail the hasConstraintTail property value to be added
     */
    void addHasConstraintTail(WrappedIndividual newHasConstraintTail);

    /**
     * Removes a hasConstraintTail property value.<p>
     * 
     * @param oldHasConstraintTail the hasConstraintTail property value to be removed.
     */
    void removeHasConstraintTail(WrappedIndividual oldHasConstraintTail);


    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasConstraintHeadLogicalOperator
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
