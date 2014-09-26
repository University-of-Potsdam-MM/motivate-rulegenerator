package de.unipotsdam.rulegenerator.rules;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitClass;

public class LearningUnitClassFactSet {
	private Map<MyLearningUnitClass, FactSet> children = new HashMap<MyLearningUnitClass, FactSet>();

	public Map<MyLearningUnitClass, FactSet> getChildren() {
		return children;
	}

	public void setChildren(
			Map<MyLearningUnitClass, FactSet> learningUnitClassFactSets) {
		this.children = learningUnitClassFactSets;
	}

	public int getCildrenHashCode() {
		return this.getChildren().hashCode();
	}

	public void put(MyLearningUnitClass learningUnitClass, FactSet factSet) {
		for (Entry<MyLearningUnitClass, FactSet> entry : children.entrySet()) {
			// TODO: append fact set if class already exists
			MyLearningUnitClass factSetLearningUnitClass = entry.getKey();

			if (factSetLearningUnitClass.getMetaData().equals(
					learningUnitClass.getMetaData())) {
				children.put(factSetLearningUnitClass, factSet);
				return;
			}
		}
		children.put(learningUnitClass, factSet);
	}
}
