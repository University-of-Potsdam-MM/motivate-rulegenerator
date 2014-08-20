package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.LearningUnitClass;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;
import de.unipotsdam.rulegenerator.ontology.impl.DefaultLearningUnitClass;

public class MyLearningUnitClass extends DefaultLearningUnitClass implements
		LearningUnitClass {
	
	public MyLearningUnitClass(CodeGenerationInference inference, IRI iri) {
		super(inference, iri);
		// TODO Auto-generated constructor stub
	}

	// Description

	public String description() {
		return MyMetaData.DescriptionFromMetaDataCollection(this.getMetaData());
	}

	// Comparison

	public Boolean equals(Collection<? extends MyMetaData> metaData) {
		if (this.getLogicalOperator().equals(LogicalOperator.AND)) {
			return this.description().equals(MyMetaData.DescriptionFromMetaDataCollection(metaData));
		} else {
			for (MyMetaData theMetaData : metaData) {
				if (this.contains(theMetaData)) return true;
			}
			return false;
		}
	}

	// Contains

	public Boolean contains(MyMetaData theMetaData) {
		for (MyMetaData metaData : this.getMetaData()) {
			if (metaData.equals(theMetaData))
				return true;
		}
		return false;
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

	// Meta Data

	public Boolean hasMetaData() {
		return this.getMetaDataCount() > 0;
	}
	
	public Integer getMetaDataCount() {
		return this.getMetaData().toArray().length;
	}

	public Collection<? extends MyMetaData> getMetaData() {
		return getDelegate().getPropertyValues(getOwlIndividual(),
				Vocabulary.OBJECT_PROPERTY_HASMETADATA, MyMetaData.class);
	}
}
