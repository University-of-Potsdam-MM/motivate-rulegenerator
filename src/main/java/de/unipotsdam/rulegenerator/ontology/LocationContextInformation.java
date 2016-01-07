package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: LocationContextInformation <br>
 * @version generated on Wed Oct 07 15:25:17 CEST 2015 by tobias
 */

public interface LocationContextInformation extends PhysicalContextInformation {

    /* ***************************************************
     * Property http://motivate-project.de/ontology/knowledge.owl#hasContextInformationParameter
     */
     
    /**
     * Gets all property values for the hasContextInformationParameter property.<p>
     * 
     * @returns a collection of values for the hasContextInformationParameter property.
     */
    Collection<? extends ContextInformationParameter> getHasContextInformationParameter();

    /**
     * Checks if the class has a hasContextInformationParameter property value.<p>
     * 
     * @return true if there is a hasContextInformationParameter property value.
     */
    boolean hasHasContextInformationParameter();

    /**
     * Adds a hasContextInformationParameter property value.<p>
     * 
     * @param newHasContextInformationParameter the hasContextInformationParameter property value to be added
     */
    void addHasContextInformationParameter(ContextInformationParameter newHasContextInformationParameter);

    /**
     * Removes a hasContextInformationParameter property value.<p>
     * 
     * @param oldHasContextInformationParameter the hasContextInformationParameter property value to be removed.
     */
    void removeHasContextInformationParameter(ContextInformationParameter oldHasContextInformationParameter);


    /* ***************************************************
     * Property http://motivate-project.de/ontology/knowledge.owl#hasCID
     */
     
    /**
     * Gets all property values for the hasCID property.<p>
     * 
     * @returns a collection of values for the hasCID property.
     */
    Collection<? extends String> getHasCID();

    /**
     * Checks if the class has a hasCID property value.<p>
     * 
     * @return true if there is a hasCID property value.
     */
    boolean hasHasCID();

    /**
     * Adds a hasCID property value.<p>
     * 
     * @param newHasCID the hasCID property value to be added
     */
    void addHasCID(String newHasCID);

    /**
     * Removes a hasCID property value.<p>
     * 
     * @param oldHasCID the hasCID property value to be removed.
     */
    void removeHasCID(String oldHasCID);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
