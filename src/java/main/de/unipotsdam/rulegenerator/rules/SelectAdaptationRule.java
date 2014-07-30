package de.unipotsdam.rulegenerator.rules;

import de.unipotsdam.rulegenerator.enums.ActionOperator;
import de.unipotsdam.rulegenerator.enums.SituationTemplate;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public class SelectAdaptationRule extends AdaptationRule {
	public SelectAdaptationRule(MyLearningUnit currentLearningUnit) throws Exception {
		// TODO: find id pattern
		this.setId("SelectLearningUnit["+currentLearningUnit.getID()+"]");
		// create trigger for the rule
		this.setTrigger(new Trigger(TriggeringMode.ON_ENTRY));
		// create the situation for the rule
		Situation showLearningUnitRuleSituation = new Situation();
		showLearningUnitRuleSituation
				.applyTemplate(
						SituationTemplate.CURRENT_LEARNING_UNIT_FACTS_AND_PREREQUISITES,
						currentLearningUnit);
		// add the situation to the rule
		this.setSituation(showLearningUnitRuleSituation);
		// create the action for the rule
		this.setAction(new Action(ActionOperator.SELECT,
				currentLearningUnit.getID()));
	}
}
