package de.unipotsdam.rulegenerator.ontology.custom;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.ontology.Feature;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultFeature;

public class MyFeature extends DefaultFeature implements Feature {

	public MyFeature(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}
}
