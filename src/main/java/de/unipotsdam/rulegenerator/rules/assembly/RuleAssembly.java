package de.unipotsdam.rulegenerator.rules.assembly;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.LearningUnitClassFactSet;

public abstract class RuleAssembly {
	public OWLOntology ontology;
	public AdaptationRuleList adaptationRules = new AdaptationRuleList();
	
	public AdaptationRuleList generateRules(LearningUnitClassFactSet hasLearningUnitClassConstraintFactSet, LearningUnitClassFactSet hasNotLearningUnitClassConstraintFactSet) throws Exception {
		return adaptationRules;
	}
}
