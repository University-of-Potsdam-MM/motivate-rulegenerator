package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: PrintingInkContextParameter <br>
 * @version generated on Wed Aug 13 14:30:39 CEST 2014 by tobias
 */

public interface PrintingInkContextParameter extends ContextInformationParameter {

    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasContextInformationParameterValue
     */
     
    /**
     * Gets all property values for the hasContextInformationParameterValue property.<p>
     * 
     * @returns a collection of values for the hasContextInformationParameterValue property.
     */
    Collection<? extends Object> getHasContextInformationParameterValue();

    /**
     * Checks if the class has a hasContextInformationParameterValue property value.<p>
     * 
     * @return true if there is a hasContextInformationParameterValue property value.
     */
    boolean hasHasContextInformationParameterValue();

    /**
     * Adds a hasContextInformationParameterValue property value.<p>
     * 
     * @param newHasContextInformationParameterValue the hasContextInformationParameterValue property value to be added
     */
    void addHasContextInformationParameterValue(Object newHasContextInformationParameterValue);

    /**
     * Removes a hasContextInformationParameterValue property value.<p>
     * 
     * @param oldHasContextInformationParameterValue the hasContextInformationParameterValue property value to be removed.
     */
    void removeHasContextInformationParameterValue(Object oldHasContextInformationParameterValue);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
