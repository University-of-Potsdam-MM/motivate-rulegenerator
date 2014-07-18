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
 * Source Class: DefaultPrintingInkContextParameter <br>
 * @version generated on Wed Jul 16 14:45:16 CEST 2014 by tobias
 */
public class DefaultPrintingInkContextParameter extends WrappedIndividualImpl implements PrintingInkContextParameter {

    public DefaultPrintingInkContextParameter(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Data Property http://www.motivate-project.de/ontologies/motivate.owl#hasContextInformationParameterValue
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
