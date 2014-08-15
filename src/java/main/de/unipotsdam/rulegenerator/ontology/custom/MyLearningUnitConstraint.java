package de.unipotsdam.rulegenerator.ontology.custom;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.ontology.LearningUnitConstraint;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnitConstraint;

public class MyLearningUnitConstraint extends DefaultLearningUnitConstraint implements LearningUnitConstraint {

	public MyLearningUnitConstraint(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

}
