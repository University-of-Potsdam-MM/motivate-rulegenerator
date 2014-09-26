package de.unipotsdam.rulegenerator.rules;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.enums.ActionOperator;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyConstraintRequirement;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitClass;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitClassConstraint;
import de.unipotsdam.rulegenerator.ontology.custom.MyRestrictFeatureConstraint;

public class RuleFactory {
	private OWLOntology ontology;
	private Collection<? extends MyLearningUnit> learningUnits;
	private Collection<? extends MyRestrictFeatureConstraint> restrictFeatureConstraints;
	private Collection<? extends MyLearningUnitClassConstraint> learningUnitClassConstraints;
	private LearningUnitClassFactSet hasLearningUnitClassConstraintFactSet = new LearningUnitClassFactSet();
	private LearningUnitClassFactSet hasNotLearningUnitClassConstraintFactSet = new LearningUnitClassFactSet();

	public RuleFactory(OWLOntology ontology) {
		super();

		this.ontology = ontology;
		// create ORM object factory
		MyFactory factory = new MyFactory(ontology);
		// get all learning unit individuals from ontology
		this.learningUnits = factory.getAllLearningUnitInstances();
		this.restrictFeatureConstraints = factory
				.getAllFeatureConstraintInstances();
		this.learningUnitClassConstraints = factory
				.getAllLearningUnitConstraintInstances();
	}

	public Collection<? extends LearningUnit> getLearningUnits() {
		return learningUnits;
	}

	public void setLearningUnits(
			Collection<? extends MyLearningUnit> learningUnits) {
		this.learningUnits = learningUnits;
	}

	public AdaptationRuleList generateRules() throws Exception {
		// delete existing rules?
		AdaptationRuleList ruleList = new AdaptationRuleList();

		long timestamp = System.currentTimeMillis() / 1000;

		// constraints

		// feature constraints

		for (MyRestrictFeatureConstraint restrictFeatureConstraint : this.restrictFeatureConstraints) {
			AdaptationRule featureConstraintRule = new AdaptationRule(
					"RestrictFeatureConstraintRule[" + timestamp + "]",
					ActionOperator.RESTRICT_FEATURE, restrictFeatureConstraint
							.getFeature().getIRIShort());
			featureConstraintRule.setNegation(true);
			featureConstraintRule.setTrigger(new Trigger(
					TriggeringMode.ON_ENTRY));
			Situation featureConstraintRuleSituation = new Situation();
			int i = 0;
			for (MyConstraintRequirement constraintRequirement : restrictFeatureConstraint
					.getConstraintRequirements()) {
				featureConstraintRuleSituation
						.addConstraint(FactSet
								.FactSetFromConstraintRequirement(constraintRequirement));
				if (i < restrictFeatureConstraint
						.getConstraintRequirementsCount() - 1)
					featureConstraintRuleSituation
							.addConstraint(restrictFeatureConstraint
									.getLogicalOperator());
				i++;
			}
			featureConstraintRule.setSituation(featureConstraintRuleSituation);
			ruleList.addAdaptationRule(featureConstraintRule);

			timestamp++;
		}

		// constraints based on meta data

		for (MyLearningUnitClassConstraint learningUnitClassConstraint : this.learningUnitClassConstraints) {
			if (learningUnitClassConstraint.hasLearningUnitClass()) {
				MyLearningUnitClass hasLearningUnitClass = learningUnitClassConstraint
						.getHasLearningUnitClass();
				hasLearningUnitClassConstraintFactSet.put(hasLearningUnitClass,
						learningUnitClassConstraint.getFactSet());
			} else if (learningUnitClassConstraint.hasNotLearningUnitClass()) {
				MyLearningUnitClass hasNotLearningUnitClass = learningUnitClassConstraint
						.getHasNotLearningUnitClass();
				hasNotLearningUnitClassConstraintFactSet.put(
						hasNotLearningUnitClass,
						learningUnitClassConstraint.getFactSet());
			}
		}
		
		for (MyLearningUnit currentLearningUnit : learningUnits) {

			/** SELECT() **/

			// create a select rule for the current learning unit if its context
			// information are present
			if (currentLearningUnit.getContextInformationCount() > 0)
				ruleList.addAdaptationRule(new SelectAdaptationRule(
						currentLearningUnit,
						hasLearningUnitClassConstraintFactSet,
						hasNotLearningUnitClassConstraintFactSet));

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