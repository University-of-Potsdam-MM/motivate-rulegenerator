package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.Set;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import de.unipotsdam.rulegenerator.ontology.ContextInformationParameter;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultContextInformationParameter;

public class MyContextInformationParameter extends
		DefaultContextInformationParameter implements
		ContextInformationParameter {

	public MyContextInformationParameter(CodeGenerationInference inference,
			IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// IRI

	public String getIRIShort() {
		return this.getOwlIndividual().getIRI().getFragment();
	}

	// Type

	public Set<OWLClassExpression> getTypes() {
		return this.getOwlIndividual().getTypes(this.getOwlOntology());
	}

	// ID

	public String getSpecificType() {
		return this.hasHasPID() ? this.getHasPID().toArray()[0].toString()
				: "NO_VALUE";
	}

	// Value

	public Object getValue() {
		if (this.getValues().toArray().length > 0)
			return getValues().toArray()[0];
		else
			return "NO_VALUE";
	}

	public Collection<? extends Object> getValues() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.DATA_PROPERTY_HASVALUE, Object.class);
	}
}
