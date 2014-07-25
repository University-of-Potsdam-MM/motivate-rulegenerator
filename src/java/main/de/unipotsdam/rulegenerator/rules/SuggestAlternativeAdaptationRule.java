package de.unipotsdam.rulegenerator.rules;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LocalActionOperator;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public class SuggestAlternativeAdaptationRule extends SuggestAdaptationRule {
	public SuggestAlternativeAdaptationRule(MyLearningUnit currentLearningUnit,
			MyLearningUnit alternativeLearningUnit) throws Exception {
		// TODO: find id pattern
		this.setId("SuggestAlternative["+currentLearningUnit.getID()+":"+alternativeLearningUnit.getID()+"]");
		// create trigger for the rule
		this.setTrigger(new Trigger(TriggeringMode.ON_ENTRY));
		// create the situation for the rule
		Situation alternativeLearningUnitSituation = new Situation();
		// create facts to suggest
		alternativeLearningUnitSituation.userFacts.addFact(new Fact(
				"CurrentLearningUnitMeasurableInformation", FactOperator.IS,
				currentLearningUnit.getID()));

		//TODO: finish!
		
		this.setSituation(alternativeLearningUnitSituation);
		// create the action for the rule
		this.setAction(new LocalAction(LocalActionOperator.SUGGEST, alternativeLearningUnit.getID()));
	}
}
