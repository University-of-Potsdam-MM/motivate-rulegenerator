package de.unipotsdam.rulegenerator.ontology.custom;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.protege.owl.codegeneration.impl.CodeGenerationHelper;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.Vocabulary;

public class MetaDataMap {
	private Map<OWLDataProperty, Collection<Object>> metaData = new HashMap<OWLDataProperty, Collection<Object>>();

	public MetaDataMap(OWLNamedIndividual namedIndividual,
			OWLOntology ontology, CodeGenerationHelper codeGenerationHelper) {
		// get all subproperties of meta data
		Set<OWLSubDataPropertyOfAxiom> subproperties = ontology
				.getDataSubPropertyAxiomsForSuperProperty(Vocabulary.DATA_PROPERTY_HASMETADATA);
		// for each subproperty get all values
		for (OWLSubDataPropertyOfAxiom owlSubDataPropertyOfAxiom : subproperties) {
			OWLDataProperty subproperty = owlSubDataPropertyOfAxiom
					.getSubProperty().asOWLDataProperty();
			// add values to meta data hash map
			this.metaData.put(subproperty, codeGenerationHelper
					.getPropertyValues(namedIndividual, subproperty,
							Object.class));
		}
		// return hash map
	}

	public Map<OWLDataProperty, Collection<Object>> getMetaData() {
		return this.metaData;
	}

	public void setMetaData(Map<OWLDataProperty, Collection<Object>> metaData) {
		this.metaData = metaData;
	}

	public boolean equals(MetaDataMap metaDataMap,
			LogicalOperator logicalOperator) {
		System.out.println("Logical Operator is " + logicalOperator);
		Iterator it = this.metaData.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			OWLDataProperty dataProperty = (OWLDataProperty) pairs.getKey();
			Collection<Object> values = (Collection<Object>) pairs.getValue();
			for (Object value : values) {
				System.out.println("Data property is " + dataProperty);
				if (metaDataMap.getMetaData().get(dataProperty).contains(value)) {
					System.out.println("Learning Unit contains value " + value
							+ ", was "
							+ metaDataMap.getMetaData().get(dataProperty));
					if (logicalOperator == LogicalOperator.OR)
						return true;
				} else {
					System.out.println("Learning Unit dosen't contain value "
							+ value + ", was "
							+ metaDataMap.getMetaData().get(dataProperty));
					if (logicalOperator != LogicalOperator.OR)
						return false;
				}
			}
			it.remove(); // avoids a ConcurrentModificationException
		}

		return false;
	}
}
