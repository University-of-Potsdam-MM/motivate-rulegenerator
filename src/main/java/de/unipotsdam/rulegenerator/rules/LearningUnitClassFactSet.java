package de.unipotsdam.rulegenerator.rules;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitClass;

public class LearningUnitClassFactSet {
	private Map<MyLearningUnitClass, FactSet> learningUnitClassFactSets = new HashMap<MyLearningUnitClass, FactSet>();

	public Map<MyLearningUnitClass, FactSet> getLearningUnitClassFactSets() {
		return learningUnitClassFactSets;
	}

	public void setLearningUnitClassFactSets(
			Map<MyLearningUnitClass, FactSet> learningUnitClassFactSets) {
		this.learningUnitClassFactSets = learningUnitClassFactSets;
	}

	public String description() {
		return this.learningUnitClassFactSets.toString();
	}
	
	public void put(MyLearningUnitClass learningUnitClass, FactSet factSet) {
		for (Entry<MyLearningUnitClass, FactSet> entry : learningUnitClassFactSets
				.entrySet()) {
			// TODO: append fact set if class already exists
			if (entry.getKey().description()
					.equals(learningUnitClass.description())) {
				learningUnitClassFactSets.put(entry.getKey(), factSet);
				return;
			}
		}
		learningUnitClassFactSets.put(learningUnitClass, factSet);
	}
}
