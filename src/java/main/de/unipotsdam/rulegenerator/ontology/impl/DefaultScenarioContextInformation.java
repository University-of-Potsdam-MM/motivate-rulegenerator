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
 * Source Class: DefaultScenarioContextInformation <br>
 * @version generated on Mon Jul 21 15:11:15 CEST 2014 by tobias
 */
public class DefaultScenarioContextInformation extends WrappedIndividualImpl implements ScenarioContextInformation {

    public DefaultScenarioContextInformation(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/moebert/ontologies/2014/4/untitled-ontology-35#hasContextInformationParameter
     */
     
    public Collection<? extends ContextInformationParameter> getHasContextInformationParameter() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
                                               DefaultContextInformationParameter.class);
    }

    public boolean hasHasContextInformationParameter() {
	   return !getHasContextInformationParameter().isEmpty();
    }

    public void addHasContextInformationParameter(ContextInformationParameter newHasContextInformationParameter) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
                                       newHasContextInformationParameter);
    }

    public void removeHasContextInformationParameter(ContextInformationParameter oldHasContextInformationParameter) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
                                          oldHasContextInformationParameter);
    }


}
