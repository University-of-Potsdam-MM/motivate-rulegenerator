package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.MetaData;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultMetaData;

public class MyMetaData extends DefaultMetaData implements MetaData {

	public MyMetaData(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Description

	public String description() {
		return this.getSpecificType().replace("MetaData", "") + ":"
				+ this.getValue();
	}

	// Comparison

	public Boolean equals(MyMetaData theMetaData) {
		return this.description().equals(theMetaData.description());
	}

	// Type

	public String getSpecificType() {
		for (OWLClassExpression type : this.getTypes()) {
			OWLClassImpl impl = (OWLClassImpl) type;
			String iriFragment = impl.getIRI().getFragment();
			if (iriFragment.contains("MetaData"))
				return iriFragment;
		}

		return "NO_VALUE";
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
