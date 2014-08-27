package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: ConstraintRequirement <br>
 * @version generated on Wed Aug 27 13:57:18 CEST 2014 by tobias
 */

public interface ConstraintRequirement extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasEndTime
     */
     
    /**
     * Gets all property values for the hasEndTime property.<p>
     * 
     * @returns a collection of values for the hasEndTime property.
     */
    Collection<? extends Object> getHasEndTime();

    /**
     * Checks if the class has a hasEndTime property value.<p>
     * 
     * @return true if there is a hasEndTime property value.
     */
    boolean hasHasEndTime();

    /**
     * Adds a hasEndTime property value.<p>
     * 
     * @param newHasEndTime the hasEndTime property value to be added
     */
    void addHasEndTime(Object newHasEndTime);

    /**
     * Removes a hasEndTime property value.<p>
     * 
     * @param oldHasEndTime the hasEndTime property value to be removed.
     */
    void removeHasEndTime(Object oldHasEndTime);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasStartingTime
     */
     
    /**
     * Gets all property values for the hasStartingTime property.<p>
     * 
     * @returns a collection of values for the hasStartingTime property.
     */
    Collection<? extends Object> getHasStartingTime();

    /**
     * Checks if the class has a hasStartingTime property value.<p>
     * 
     * @return true if there is a hasStartingTime property value.
     */
    boolean hasHasStartingTime();

    /**
     * Adds a hasStartingTime property value.<p>
     * 
     * @param newHasStartingTime the hasStartingTime property value to be added
     */
    void addHasStartingTime(Object newHasStartingTime);

    /**
     * Removes a hasStartingTime property value.<p>
     * 
     * @param oldHasStartingTime the hasStartingTime property value to be removed.
     */
    void removeHasStartingTime(Object oldHasStartingTime);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
