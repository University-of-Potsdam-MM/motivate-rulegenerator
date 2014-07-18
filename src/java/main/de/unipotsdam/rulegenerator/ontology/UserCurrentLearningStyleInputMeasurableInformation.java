package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: UserCurrentLearningStyleInputMeasurableInformation <br>
 * @version generated on Wed Jul 16 14:45:16 CEST 2014 by tobias
 */

public interface UserCurrentLearningStyleInputMeasurableInformation extends MeasurableContextInformation {

    /* ***************************************************
     * Property http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#hasContextInformationParameter
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
     * Property http://www.motivate-project.de/ontologies/motivate.owl#hasMeasurableContextInformationValue
     */
     
    /**
     * Gets all property values for the hasMeasurableContextInformationValue property.<p>
     * 
     * @returns a collection of values for the hasMeasurableContextInformationValue property.
     */
    Collection<? extends Object> getHasMeasurableContextInformationValue();

    /**
     * Checks if the class has a hasMeasurableContextInformationValue property value.<p>
     * 
     * @return true if there is a hasMeasurableContextInformationValue property value.
     */
    boolean hasHasMeasurableContextInformationValue();

    /**
     * Adds a hasMeasurableContextInformationValue property value.<p>
     * 
     * @param newHasMeasurableContextInformationValue the hasMeasurableContextInformationValue property value to be added
     */
    void addHasMeasurableContextInformationValue(Object newHasMeasurableContextInformationValue);

    /**
     * Removes a hasMeasurableContextInformationValue property value.<p>
     * 
     * @param oldHasMeasurableContextInformationValue the hasMeasurableContextInformationValue property value to be removed.
     */
    void removeHasMeasurableContextInformationValue(Object oldHasMeasurableContextInformationValue);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
