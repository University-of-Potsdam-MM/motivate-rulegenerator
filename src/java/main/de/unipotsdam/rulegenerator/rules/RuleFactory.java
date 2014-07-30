package de.unipotsdam.rulegenerator.rules;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

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

			/** SELECT() **/

			// create a select rule for the current learning unit if its context
			// information are present
			if (currentLearningUnit.getContextInformationCount() > 0)
				ruleList.addAdaptationRule(new SelectAdaptationRule(
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
					}
				}

				/** PREREQUISITES **/

				// check for prerequisites
				if (currentLearningUnit.hasPrerequisites()) {
					for (WrappedIndividual prerequisite : currentLearningUnit
							.getPrerequisites()) {
						MyLearningUnit prerequisiteLearningUnit = (MyLearningUnit) prerequisite;

						/** PRELOAD() **/

						// preload prerequisite learning unit
						ruleList.addAdaptationRule(new PreloadAdaptationRule(
								currentLearningUnit, prerequisiteLearningUnit));

					}
				}

				/** HELP **/

				// check for help
				if (currentLearningUnit.hasHelp()) {
					for (WrappedIndividual help : currentLearningUnit.getHelp()) {
						MyLearningUnit helpLearningUnit = (MyLearningUnit) help;

						/** PRELOAD HELP **/

						// create preload rule for help learning unit
						ruleList.addAdaptationRule(new PreloadAdaptationRule(
								currentLearningUnit, helpLearningUnit));
					}
				}

			}
		}

		return ruleList;
	}
}