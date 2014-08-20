package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;

import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
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

	public static String DescriptionFromMetaDataCollection(
			Collection<? extends MyMetaData> metaDataCollection) {
		List<? extends MyMetaData> metaDataList = new ArrayList<MyMetaData>(
				metaDataCollection);
		Collections.sort(metaDataList, new Comparator<MyMetaData>() {

			@Override
			public int compare(MyMetaData o1, MyMetaData o2) {
				return o1.description().compareToIgnoreCase(o2.description());
			}

		});
		
		String description = new String();
		int i = 0;
		for (MyMetaData metaData : metaDataList) {
			description += metaData.description();
			if (i < metaDataList.toArray().length - 1)
				description += "[" + LogicalOperator.AND.toString() + "]";
			i++;
		}
		return description;
	}
}
