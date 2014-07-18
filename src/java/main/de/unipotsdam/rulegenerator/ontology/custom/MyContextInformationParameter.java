package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Set;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.ContextInformationParameter;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultContextInformationParameter;

public class MyContextInformationParameter extends
		DefaultContextInformationParameter implements
		ContextInformationParameter {
	static final String label = "ContextInformationParameter";
	
	public MyContextInformationParameter(CodeGenerationInference inference,
			IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	public void description() {
		this.description(0);
	}

	public void description(Integer indent) {
		System.out.println(this.getIndentSpace(indent) + "<ContextInformationParameter>");
		System.out.println(this.getIndentSpace(indent+1) + "<IRI>" + this.getIRIShort() + "</IRI>");
		System.out.println(this.getIndentSpace(indent+1) + "<Class>" + this.getSpecificParameterType() + "</Class>");
		System.out.println(this.getIndentSpace(indent+1) + "<Value>" + this.getValue() + "</Value>");
		System.out.println(this.getIndentSpace(indent) + "</ContextInformationParameter>");
	}
	
	public String getIRIShort() {
		return this.getOwlIndividual().getIRI().getFragment();
	}
	
	public Set<OWLClassExpression> getTypes() {
		return this.getOwlIndividual().getTypes(this.getOwlOntology());
	}

	public String getSpecificParameterType() {
		for (OWLClassExpression type : this.getTypes()) {
			OWLClassImpl impl = (OWLClassImpl) type;
			String iriFragment = impl.getIRI().getFragment();
			if (iriFragment.contains("ContextParameter"))
				return iriFragment;
		}

		return "Unknown";
	}
	
	public Object getValue() {
		Object[] values = this.getHasContextInformationParameterValue().toArray();
		if (values.length > 0) return values[0]; else return "Unknown";
	}

}
