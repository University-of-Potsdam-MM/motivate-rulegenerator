package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.protege.owl.codegeneration.WrappedIndividual;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LocalActionOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.SituationTemplate;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyMeasurableContextInformation;

public class RuleFactory {
	private Collection<? extends LearningUnit> learningUnits;

	public RuleFactory(Collection<? extends LearningUnit> learningUnits) {
		super();
		this.learningUnits = learningUnits;
	}

	public Collection<? extends LearningUnit> getLearningUnits() {
		return learningUnits;
	}

	public void setLearningUnits(
			Collection<? extends LearningUnit> learningUnits) {
		this.learningUnits = learningUnits;
	}

	public AdaptationRuleList generateRules() throws Exception {
		// delete existing rules?
		AdaptationRuleList ruleList = new AdaptationRuleList();

		for (LearningUnit learningUnit : learningUnits) {
			MyLearningUnit currentLearningUnit = (MyLearningUnit) learningUnit;

			/** SHOW() **/

			// create show rule for the current learning unit
			ruleList.addAdaptationRule(new ShowAdaptationRule(
					currentLearningUnit));

			/** RELATIONS **/

			// check for relations
			if (currentLearningUnit.hasRelations()) {

				/** ALTERNATIVES **/

				// check for alternatives
				if (currentLearningUnit.hasAlternatives()) {
					for (WrappedIndividual alternative : currentLearningUnit
							.getAlternatives()) {
						MyLearningUnit alternativeLearningUnit = (MyLearningUnit) alternative;

						/** PRELOAD() **/

						// preload alternative learning unit
						ruleList.addAdaptationRule(new PreloadAdaptationRule(
								currentLearningUnit, alternativeLearningUnit));

						/** SUGGEST() **/

						// suggest alternative learning unit
						ruleList.addAdaptationRule(new SuggestAlternativeAdaptationRule(
								currentLearningUnit, alternativeLearningUnit));

						/** SHOW() **/

						// create a show rule for when the user is requesting
						// an alternative representation of the learning unit
						AdaptationRule showRequestedAlternativeRule = new AdaptationRule(
								"ShowRequestedAlternativeRule["
										+ currentLearningUnit.getID() + ":"
										+ alternativeLearningUnit.getID() + "]");
						showRequestedAlternativeRule.setTrigger(new Trigger(
								TriggeringMode.ON_ENTRY));
						// create the situation for the rule
						Situation showRequestedAlternativeRuleSituation = new Situation(
								LogicalOperator.valueOf(alternativeLearningUnit
										.getLogicalOperator()));
						showRequestedAlternativeRuleSituation
								.applyTemplate(
										SituationTemplate.CURRENT_LEARNING_UNIT_ID_AND_TARGET_PREREQUISITES,
										currentLearningUnit,
										alternativeLearningUnit);
						// add user did request alternative representation
						// constraint
						if (showRequestedAlternativeRuleSituation.constraints
								.size() > 0)
							showRequestedAlternativeRuleSituation.constraints
									.addLogicalOperator(LogicalOperator.AND);
						showRequestedAlternativeRuleSituation.constraints
								.addFact(new Fact(
										"UserRequestsAlternativeMeasurableInformation",
										FactOperator.IS, "true"));
						//
						showRequestedAlternativeRuleSituation.applyTemplate(
								SituationTemplate.CURRENT_LEARNING_UNIT_FACTS,
								alternativeLearningUnit);
						// add the situation to the rule
						showRequestedAlternativeRule
								.setSituation(showRequestedAlternativeRuleSituation);
						// create the action for the rule
						showRequestedAlternativeRule.setAction(new LocalAction(
								LocalActionOperator.SHOW,
								alternativeLearningUnit.getID()));
						ruleList.addAdaptationRule(showRequestedAlternativeRule);
					}
				}

				/** PREREQUISITES **/

				// check for prerequisites
				if (currentLearningUnit.hasPrerequisites()) {
					for (WrappedIndividual prerequisite : currentLearningUnit
							.getPrerequisites()) {
						MyLearningUnit prerequisiteLearningUnit = (MyLearningUnit) prerequisite;

						/** PRELOAD() **/

						// create selection rule for learning unit
						ruleList.addAdaptationRule(new PreloadAdaptationRule(
								currentLearningUnit, prerequisiteLearningUnit));

						/** SHOW() **/

					}
				}

				/** HELP **/

				// check for help
				if (currentLearningUnit.hasHelp()) {
					for (WrappedIndividual help : currentLearningUnit.getHelp()) {
						MyLearningUnit helpLearningUnit = (MyLearningUnit) help;

						/** PRELOAD() **/

						// create selection rule for learning unit
						ruleList.addAdaptationRule(new PreloadAdaptationRule(
								currentLearningUnit, helpLearningUnit));

						/** SUGGEST() **/

						// create a suggestion rule for when the user seems to
						// be confused

						/** SHOW() **/

						// create a show rule for when the user is requesting
						// help

						AdaptationRule showRequestedHelpRule = new AdaptationRule(
								"ShowRequestedHelpRule"
										+ currentLearningUnit.getID());
						showRequestedHelpRule.setTrigger(new Trigger(
								TriggeringMode.ON_ENTRY));
						// create the situation for the rule
						Situation showRequestedHelpRuleSituation = new Situation();
						showRequestedHelpRuleSituation.applyTemplate(
								SituationTemplate.TARGET_PREREQUISITES,
								currentLearningUnit, helpLearningUnit);
						// add user did request help constraint
						if (showRequestedHelpRuleSituation.constraints.size() > 0)
							showRequestedHelpRuleSituation.constraints
									.addLogicalOperator(LogicalOperator.AND);
						showRequestedHelpRuleSituation.constraints.addFact(new Fact(
								"UserRequestsHelpMeasurableInformation",
								FactOperator.IS, "true"));
						//
						showRequestedHelpRuleSituation.applyTemplate(
								SituationTemplate.CURRENT_LEARNING_UNIT_FACTS,
								helpLearningUnit);
						// add the situation to the rule
						showRequestedHelpRule
								.setSituation(showRequestedHelpRuleSituation);
						// create the action for the rule
						showRequestedHelpRule.setAction(new LocalAction(
								LocalActionOperator.SHOW, helpLearningUnit
										.getID()));
						ruleList.addAdaptationRule(showRequestedHelpRule);
					}
				}

			}
		}

		return ruleList;
	}
}