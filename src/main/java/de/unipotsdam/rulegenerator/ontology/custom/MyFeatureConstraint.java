package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.Feature;
import de.unipotsdam.rulegenerator.ontology.FeatureConstraint;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultFeatureConstraint;

public class MyFeatureConstraint extends DefaultFeatureConstraint implements
		FeatureConstraint {

	public MyFeatureConstraint(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Requirements

	public Boolean hasConstraintRequirement() {
		return this.getConstraintRequirementsCount() > 0;
	}

	public Integer getConstraintRequirementsCount() {
		return this.getConstraintRequirements().toArray().length;
	}

	public Collection<MyConstraintRequirement> getConstraintRequirements() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASCONSTRAINTREQUIREMENT,
				MyConstraintRequirement.class);
	}

	// Logical Operator

	public LogicalOperator getLogicalOperator() {
		return LogicalOperator.valueOf(this.getHasConstraintLogicalOperator()
				.toArray()[0].toString());
	}

	// Feature

	public MyFeature getFeature() {
		return (MyFeature) getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASFEATURE, MyFeature.class)
				.toArray()[0];
	}

}
