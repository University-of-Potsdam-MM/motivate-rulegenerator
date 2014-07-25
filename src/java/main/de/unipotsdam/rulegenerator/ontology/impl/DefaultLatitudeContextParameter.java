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
 * Source Class: DefaultLatitudeContextParameter <br>
 * @version generated on Fri Jul 25 16:06:55 CEST 2014 by tobias
 */
public class DefaultLatitudeContextParameter extends WrappedIndividualImpl implements LatitudeContextParameter {

    public DefaultLatitudeContextParameter(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/knowledge#hasContextInformationParameterValue
     */
     
    public Collection<? extends Object> getHasContextInformationParameterValue() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONTEXTINFORMATIONPARAMETERVALUE, Object.class);
    }

    public boolean hasHasContextInformationParameterValue() {
		return !getHasContextInformationParameterValue().isEmpty();
    }

    public void addHasContextInformationParameterValue(Object newHasContextInformationParameterValue) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONTEXTINFORMATIONPARAMETERVALUE, newHasContextInformationParameterValue);
    }

    public void removeHasContextInformationParameterValue(Object oldHasContextInformationParameterValue) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASCONTEXTINFORMATIONPARAMETERVALUE, oldHasContextInformationParameterValue);
    }


}
