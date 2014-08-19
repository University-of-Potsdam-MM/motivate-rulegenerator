package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.ontology.MetaData;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultMetaData;

public class MyMetaData extends DefaultMetaData implements MetaData {

	public MyMetaData(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		// TODO
		return null;
	}

	// Value

	public String getValue() {
		if (this.getValues().toArray().length > 0)
			return (String) getValues().toArray()[0];
		else
			return null;
	}

	public Collection<? extends Object> getValues() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.DATA_PROPERTY_HASVALUE, Object.class);
	}
}
