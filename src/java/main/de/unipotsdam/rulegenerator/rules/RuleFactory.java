package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.protege.owl.codegeneration.WrappedIndividual;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LocalActionOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
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

	public AdaptationRuleList generateRules() {
		// delete existing rules?
		AdaptationRuleList ruleList = new AdaptationRuleList();

		for (LearningUnit learningUnit : learningUnits) {
			MyLearningUnit currentLearningUnit = (MyLearningUnit) learningUnit;

			/** SHOW() **/

			// create selection rule for learning unit
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

						// show alternative learning unit
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
						
						// create a suggestion rule for when the user seems to be confused
						
						/** SHOW() **/
						
						// create a show rule for when the user is requesting help
					}
				}

			}
		}

		return ruleList;
	}
}