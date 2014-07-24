package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.Set;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.ContextInformation;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultMeasurableContextInformation;

public class MyMeasurableContextInformation extends
		DefaultMeasurableContextInformation implements ContextInformation {

	public MyMeasurableContextInformation(CodeGenerationInference inference,
			IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	public void description() {
		this.description(0);
	}
	
	public void description(Integer indent) {
		this.description(indent, true);
	}

	public void description(Integer indent, Boolean deep) {
		System.out.println(this.getIndentSpace(indent+1) + "<IRI>" + this.getIRIShort()
				+ "</IRI>");
		System.out.println(this.getIndentSpace(indent+1) + "<Class>"
				+ this.getSpecificContextInformationType() + "</Class>");
		if (this.getContextInformationParameterCount() > 0) {
			System.out.println(this.getIndentSpace(indent+1) + "<Parameters>");
			int i = 0;
			for (MyContextInformationParameter parameter : this
					.getContextInformationParameters()) {
				parameter.description(indent + 2);
				if (i != this.getContextInformationParameterCount() - 1)
					System.out.println();
				i++;
			}
			System.out.println(this.getIndentSpace(indent+1) + "</Parameters>");
		} else {
			System.out.println(this.getIndentSpace(indent+1) + "<Parameters/>");
		}
		System.out.println(this.getIndentSpace(indent+1) + "<Value>" + this.getValue()
				+ "</Value>");
	}

	public String getIRIShort() {
		return this.getOwlIndividual().getIRI().getFragment();
	}

	public Set<OWLClassExpression> getTypes() {
		return this.getOwlIndividual().getTypes(this.getOwlOntology());
	}

	public String getSpecificContextInformationType() {
		for (OWLClassExpression type : this.getTypes()) {
			OWLClassImpl impl = (OWLClassImpl) type;
			String iriFragment = impl.getIRI().getFragment();
			if (iriFragment.contains("MeasurableInformation"))
				return iriFragment;
		}

		return "Unknown";
	}

	public Integer getContextInformationParameterCount() {
		return this.getContextInformationParameters().toArray().length;
	}

	public Object getValue() {
		Object[] values = this.getHasMeasurableContextInformationValue()
				.toArray();
		if (values.length > 0)
			return values[0];
		else
			return "Unknown";
	}

	public Collection<MyContextInformationParameter> getContextInformationParameters() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASCONTEXTINFORMATIONPARAMETER,
				MyContextInformationParameter.class);
	}
}