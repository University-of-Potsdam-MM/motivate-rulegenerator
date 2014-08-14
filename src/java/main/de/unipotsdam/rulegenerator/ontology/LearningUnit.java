package de.unipotsdam.rulegenerator.ontology;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: LearningUnit <br>
 * @version generated on Wed Aug 13 14:30:39 CEST 2014 by tobias
 */

public interface LearningUnit extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasAlternative
     */
     
    /**
     * Gets all property values for the hasAlternative property.<p>
     * 
     * @returns a collection of values for the hasAlternative property.
     */
    Collection<? extends WrappedIndividual> getHasAlternative();

    /**
     * Checks if the class has a hasAlternative property value.<p>
     * 
     * @return true if there is a hasAlternative property value.
     */
    boolean hasHasAlternative();

    /**
     * Adds a hasAlternative property value.<p>
     * 
     * @param newHasAlternative the hasAlternative property value to be added
     */
    void addHasAlternative(WrappedIndividual newHasAlternative);

    /**
     * Removes a hasAlternative property value.<p>
     * 
     * @param oldHasAlternative the hasAlternative property value to be removed.
     */
    void removeHasAlternative(WrappedIndividual oldHasAlternative);


    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasContextInformation
     */
     
    /**
     * Gets all property values for the hasContextInformation property.<p>
     * 
     * @returns a collection of values for the hasContextInformation property.
     */
    Collection<? extends WrappedIndividual> getHasContextInformation();

    /**
     * Checks if the class has a hasContextInformation property value.<p>
     * 
     * @return true if there is a hasContextInformation property value.
     */
    boolean hasHasContextInformation();

    /**
     * Adds a hasContextInformation property value.<p>
     * 
     * @param newHasContextInformation the hasContextInformation property value to be added
     */
    void addHasContextInformation(WrappedIndividual newHasContextInformation);

    /**
     * Removes a hasContextInformation property value.<p>
     * 
     * @param oldHasContextInformation the hasContextInformation property value to be removed.
     */
    void removeHasContextInformation(WrappedIndividual oldHasContextInformation);


    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasLearningUnitMeasurableContextInformation
     */
     
    /**
     * Gets all property values for the hasLearningUnitMeasurableContextInformation property.<p>
     * 
     * @returns a collection of values for the hasLearningUnitMeasurableContextInformation property.
     */
    Collection<? extends MeasurableContextInformation> getHasLearningUnitMeasurableContextInformation();

    /**
     * Checks if the class has a hasLearningUnitMeasurableContextInformation property value.<p>
     * 
     * @return true if there is a hasLearningUnitMeasurableContextInformation property value.
     */
    boolean hasHasLearningUnitMeasurableContextInformation();

    /**
     * Adds a hasLearningUnitMeasurableContextInformation property value.<p>
     * 
     * @param newHasLearningUnitMeasurableContextInformation the hasLearningUnitMeasurableContextInformation property value to be added
     */
    void addHasLearningUnitMeasurableContextInformation(MeasurableContextInformation newHasLearningUnitMeasurableContextInformation);

    /**
     * Removes a hasLearningUnitMeasurableContextInformation property value.<p>
     * 
     * @param oldHasLearningUnitMeasurableContextInformation the hasLearningUnitMeasurableContextInformation property value to be removed.
     */
    void removeHasLearningUnitMeasurableContextInformation(MeasurableContextInformation oldHasLearningUnitMeasurableContextInformation);


    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasPrerequisite
     */
     
    /**
     * Gets all property values for the hasPrerequisite property.<p>
     * 
     * @returns a collection of values for the hasPrerequisite property.
     */
    Collection<? extends WrappedIndividual> getHasPrerequisite();

    /**
     * Checks if the class has a hasPrerequisite property value.<p>
     * 
     * @return true if there is a hasPrerequisite property value.
     */
    boolean hasHasPrerequisite();

    /**
     * Adds a hasPrerequisite property value.<p>
     * 
     * @param newHasPrerequisite the hasPrerequisite property value to be added
     */
    void addHasPrerequisite(WrappedIndividual newHasPrerequisite);

    /**
     * Removes a hasPrerequisite property value.<p>
     * 
     * @param oldHasPrerequisite the hasPrerequisite property value to be removed.
     */
    void removeHasPrerequisite(WrappedIndividual oldHasPrerequisite);


    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasAuthor
     */
     
    /**
     * Gets all property values for the hasAuthor property.<p>
     * 
     * @returns a collection of values for the hasAuthor property.
     */
    Collection<? extends String> getHasAuthor();

    /**
     * Checks if the class has a hasAuthor property value.<p>
     * 
     * @return true if there is a hasAuthor property value.
     */
    boolean hasHasAuthor();

    /**
     * Adds a hasAuthor property value.<p>
     * 
     * @param newHasAuthor the hasAuthor property value to be added
     */
    void addHasAuthor(String newHasAuthor);

    /**
     * Removes a hasAuthor property value.<p>
     * 
     * @param oldHasAuthor the hasAuthor property value to be removed.
     */
    void removeHasAuthor(String oldHasAuthor);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasContentType
     */
     
    /**
     * Gets all property values for the hasContentType property.<p>
     * 
     * @returns a collection of values for the hasContentType property.
     */
    Collection<? extends String> getHasContentType();

    /**
     * Checks if the class has a hasContentType property value.<p>
     * 
     * @return true if there is a hasContentType property value.
     */
    boolean hasHasContentType();

    /**
     * Adds a hasContentType property value.<p>
     * 
     * @param newHasContentType the hasContentType property value to be added
     */
    void addHasContentType(String newHasContentType);

    /**
     * Removes a hasContentType property value.<p>
     * 
     * @param oldHasContentType the hasContentType property value to be removed.
     */
    void removeHasContentType(String oldHasContentType);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasDifficulty
     */
     
    /**
     * Gets all property values for the hasDifficulty property.<p>
     * 
     * @returns a collection of values for the hasDifficulty property.
     */
    Collection<? extends Object> getHasDifficulty();

    /**
     * Checks if the class has a hasDifficulty property value.<p>
     * 
     * @return true if there is a hasDifficulty property value.
     */
    boolean hasHasDifficulty();

    /**
     * Adds a hasDifficulty property value.<p>
     * 
     * @param newHasDifficulty the hasDifficulty property value to be added
     */
    void addHasDifficulty(Object newHasDifficulty);

    /**
     * Removes a hasDifficulty property value.<p>
     * 
     * @param oldHasDifficulty the hasDifficulty property value to be removed.
     */
    void removeHasDifficulty(Object oldHasDifficulty);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasInteractivity
     */
     
    /**
     * Gets all property values for the hasInteractivity property.<p>
     * 
     * @returns a collection of values for the hasInteractivity property.
     */
    Collection<? extends Boolean> getHasInteractivity();

    /**
     * Checks if the class has a hasInteractivity property value.<p>
     * 
     * @return true if there is a hasInteractivity property value.
     */
    boolean hasHasInteractivity();

    /**
     * Adds a hasInteractivity property value.<p>
     * 
     * @param newHasInteractivity the hasInteractivity property value to be added
     */
    void addHasInteractivity(Boolean newHasInteractivity);

    /**
     * Removes a hasInteractivity property value.<p>
     * 
     * @param oldHasInteractivity the hasInteractivity property value to be removed.
     */
    void removeHasInteractivity(Boolean oldHasInteractivity);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasKeyword
     */
     
    /**
     * Gets all property values for the hasKeyword property.<p>
     * 
     * @returns a collection of values for the hasKeyword property.
     */
    Collection<? extends String> getHasKeyword();

    /**
     * Checks if the class has a hasKeyword property value.<p>
     * 
     * @return true if there is a hasKeyword property value.
     */
    boolean hasHasKeyword();

    /**
     * Adds a hasKeyword property value.<p>
     * 
     * @param newHasKeyword the hasKeyword property value to be added
     */
    void addHasKeyword(String newHasKeyword);

    /**
     * Removes a hasKeyword property value.<p>
     * 
     * @param oldHasKeyword the hasKeyword property value to be removed.
     */
    void removeHasKeyword(String oldHasKeyword);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasLID
     */
     
    /**
     * Gets all property values for the hasLID property.<p>
     * 
     * @returns a collection of values for the hasLID property.
     */
    Collection<? extends String> getHasLID();

    /**
     * Checks if the class has a hasLID property value.<p>
     * 
     * @return true if there is a hasLID property value.
     */
    boolean hasHasLID();

    /**
     * Adds a hasLID property value.<p>
     * 
     * @param newHasLID the hasLID property value to be added
     */
    void addHasLID(String newHasLID);

    /**
     * Removes a hasLID property value.<p>
     * 
     * @param oldHasLID the hasLID property value to be removed.
     */
    void removeHasLID(String oldHasLID);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasLanguage
     */
     
    /**
     * Gets all property values for the hasLanguage property.<p>
     * 
     * @returns a collection of values for the hasLanguage property.
     */
    Collection<? extends Object> getHasLanguage();

    /**
     * Checks if the class has a hasLanguage property value.<p>
     * 
     * @return true if there is a hasLanguage property value.
     */
    boolean hasHasLanguage();

    /**
     * Adds a hasLanguage property value.<p>
     * 
     * @param newHasLanguage the hasLanguage property value to be added
     */
    void addHasLanguage(Object newHasLanguage);

    /**
     * Removes a hasLanguage property value.<p>
     * 
     * @param oldHasLanguage the hasLanguage property value to be removed.
     */
    void removeHasLanguage(Object oldHasLanguage);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasLearningUnitLogicalOperator
     */
     
    /**
     * Gets all property values for the hasLearningUnitLogicalOperator property.<p>
     * 
     * @returns a collection of values for the hasLearningUnitLogicalOperator property.
     */
    Collection<? extends Object> getHasLearningUnitLogicalOperator();

    /**
     * Checks if the class has a hasLearningUnitLogicalOperator property value.<p>
     * 
     * @return true if there is a hasLearningUnitLogicalOperator property value.
     */
    boolean hasHasLearningUnitLogicalOperator();

    /**
     * Adds a hasLearningUnitLogicalOperator property value.<p>
     * 
     * @param newHasLearningUnitLogicalOperator the hasLearningUnitLogicalOperator property value to be added
     */
    void addHasLearningUnitLogicalOperator(Object newHasLearningUnitLogicalOperator);

    /**
     * Removes a hasLearningUnitLogicalOperator property value.<p>
     * 
     * @param oldHasLearningUnitLogicalOperator the hasLearningUnitLogicalOperator property value to be removed.
     */
    void removeHasLearningUnitLogicalOperator(Object oldHasLearningUnitLogicalOperator);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasSubject
     */
     
    /**
     * Gets all property values for the hasSubject property.<p>
     * 
     * @returns a collection of values for the hasSubject property.
     */
    Collection<? extends String> getHasSubject();

    /**
     * Checks if the class has a hasSubject property value.<p>
     * 
     * @return true if there is a hasSubject property value.
     */
    boolean hasHasSubject();

    /**
     * Adds a hasSubject property value.<p>
     * 
     * @param newHasSubject the hasSubject property value to be added
     */
    void addHasSubject(String newHasSubject);

    /**
     * Removes a hasSubject property value.<p>
     * 
     * @param oldHasSubject the hasSubject property value to be removed.
     */
    void removeHasSubject(String oldHasSubject);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasTrigger
     */
     
    /**
     * Gets all property values for the hasTrigger property.<p>
     * 
     * @returns a collection of values for the hasTrigger property.
     */
    Collection<? extends Integer> getHasTrigger();

    /**
     * Checks if the class has a hasTrigger property value.<p>
     * 
     * @return true if there is a hasTrigger property value.
     */
    boolean hasHasTrigger();

    /**
     * Adds a hasTrigger property value.<p>
     * 
     * @param newHasTrigger the hasTrigger property value to be added
     */
    void addHasTrigger(Integer newHasTrigger);

    /**
     * Removes a hasTrigger property value.<p>
     * 
     * @param oldHasTrigger the hasTrigger property value to be removed.
     */
    void removeHasTrigger(Integer oldHasTrigger);



    /* ***************************************************
     * Property http://www.motivate-project.de/ontologies/knowledge#hasVersionDate
     */
     
    /**
     * Gets all property values for the hasVersionDate property.<p>
     * 
     * @returns a collection of values for the hasVersionDate property.
     */
    Collection<? extends Object> getHasVersionDate();

    /**
     * Checks if the class has a hasVersionDate property value.<p>
     * 
     * @return true if there is a hasVersionDate property value.
     */
    boolean hasHasVersionDate();

    /**
     * Adds a hasVersionDate property value.<p>
     * 
     * @param newHasVersionDate the hasVersionDate property value to be added
     */
    void addHasVersionDate(Object newHasVersionDate);

    /**
     * Removes a hasVersionDate property value.<p>
     * 
     * @param oldHasVersionDate the hasVersionDate property value to be removed.
     */
    void removeHasVersionDate(Object oldHasVersionDate);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
