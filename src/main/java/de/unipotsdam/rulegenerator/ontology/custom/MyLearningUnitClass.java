package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;

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
		return this.getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HASMETADATA, Object.class).toArray().length;
	}

	public MetaDataMap getMetaData() {
		return new MetaDataMap(getOwlIndividual(), getOwlOntology(), getDelegate());
	}
}