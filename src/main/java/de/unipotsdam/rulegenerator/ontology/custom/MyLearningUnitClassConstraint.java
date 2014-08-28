package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.LearningUnitClassConstraint;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnitClassConstraint;
import de.unipotsdam.rulegenerator.rules.FactSet;

public class MyLearningUnitClassConstraint extends DefaultLearningUnitClassConstraint
		implements LearningUnitClassConstraint {

	public MyLearningUnitClassConstraint(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Has Learning Unit Class

	public Boolean hasLearningUnitClass() {
		return this.getHasLearningUnitClasses().toArray().length > 0;
	}

	public MyLearningUnitClass getHasLearningUnitClass() {
		if (this.hasLearningUnitClass())
			return (MyLearningUnitClass) getHasLearningUnitClasses().toArray()[0];
		else
			return null;
	}

	public Collection<? extends MyLearningUnitClass> getHasLearningUnitClasses() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASLEARNINGUNITCLASS,
				MyLearningUnitClass.class);
	}
	
	// Has Not Learning Unit Class

	public Boolean hasNotLearningUnitClass() {
		return this.getHasNotLearningUnitClasses().toArray().length > 0;
	}

	public MyLearningUnitClass getHasNotLearningUnitClass() {
		if (this.hasNotLearningUnitClass())
			return (MyLearningUnitClass) getHasNotLearningUnitClasses().toArray()[0];
		else
			return null;
	}

	public Collection<? extends MyLearningUnitClass> getHasNotLearningUnitClasses() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASNOTLEARNINGUNITCLASS,
				MyLearningUnitClass.class);
	}

	// Requirements

	public Boolean hasConstraintRequirements() {
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
		if (this.getLogicalOperators().toArray().length > 0)
			return LogicalOperator.valueOf(getLogicalOperators().toArray()[0]
					.toString());
		else
			return LogicalOperator.NO_VALUE;
	}

	public Collection<? extends Object> getLogicalOperators() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.DATA_PROPERTY_HASLOGICALOPERATOR, Object.class);
	}

	// Facts

	public FactSet getFactSet() throws Exception {
		FactSet factSet = new FactSet();
		int i = 0;
		for (MyConstraintRequirement constraintRequirement : this
				.getConstraintRequirements()) {
			factSet.addFactSet(FactSet
					.FactSetFromConstraintRequirement(constraintRequirement));
			if (i < this.getConstraintRequirementsCount() - 1)
				factSet.addLogicalOperator(this.getLogicalOperator());
			i++;
		}
		return factSet;
	}
}
