package de.unipotsdam.rulegenerator.rules;

import de.unipotsdam.rulegenerator.enums.ActionOperator;
import de.unipotsdam.rulegenerator.enums.SituationTemplate;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public class PreloadAdaptationRule extends AdaptationRule {
	public PreloadAdaptationRule(MyLearningUnit currentLearningUnit,
			MyLearningUnit preloadLearningUnit) throws Exception {
		// TODO: find id pattern
		this.setId("PreloadRule["+preloadLearningUnit.getID()+"]");
		// create trigger for the rule
		this.setTrigger(new Trigger(TriggeringMode.ON_ENTRY));
		// create the situation for the rule
		Situation preloadLearningUnitRuleSituation = new Situation();
		// set logical operator
		preloadLearningUnitRuleSituation
				.applyTemplate(
						SituationTemplate.CURRENT_LEARNING_UNIT_ID_AND_TARGET_PREREQUISITES,
						currentLearningUnit, preloadLearningUnit);
		// add the situation to the rule
		this.setSituation(preloadLearningUnitRuleSituation);
		// create the action for the rule
		this.setAction(new Action(ActionOperator.PRELOAD,
				preloadLearningUnit.getID()));
	}
}
