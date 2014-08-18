package de.unipotsdam.rulegenerator.rules;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.enums.ActionOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyConstraintRequirement;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyFeatureConstraint;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitConstraint;

public class RuleFactory {
	private OWLOntology ontology;
	private Collection<? extends MyLearningUnit> learningUnits;
	private Collection<? extends MyFeatureConstraint> featureConstraints;
	private Collection<? extends MyLearningUnitConstraint> learningUnitConstraints;
	private Map<String, List<FactSet>> metaDataFactSets = new HashMap<String, List<FactSet>>();
	
	public RuleFactory(OWLOntology ontology) {
		super();

		this.ontology = ontology;
		// create ORM object factory
		MyFactory factory = new MyFactory(ontology);
		// get all learning unit individuals from ontology
		this.learningUnits = factory.getAllLearningUnitInstances();
		this.featureConstraints = factory.getAllFeatureConstraintInstances();
		this.learningUnitConstraints = factory
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

		for (MyFeatureConstraint featureConstraint : this.featureConstraints) {
			AdaptationRule featureConstraintRule = new AdaptationRule(
					"FeatureConstraintRule[" + timestamp + "]",
					ActionOperator.RESTRICT_FEATURE, featureConstraint.getFeature().getIRIShort());
			featureConstraintRule.setNegation(true);
			featureConstraintRule.setTrigger(new Trigger(TriggeringMode.ON_ENTRY));
			Situation featureConstraintRuleSituation = new Situation();
			int i = 0;
			for (MyConstraintRequirement constraintRequirement : featureConstraint
					.getConstraintRequirements()) {
				featureConstraintRuleSituation.addConstraint(FactSet
						.FactSetFromConstraintRequirement(constraintRequirement));
				if (i < featureConstraint.getConstraintRequirementsCount() - 1)
					featureConstraintRuleSituation.addConstraint(featureConstraint.getLogicalOperator());
				i++;
			}
			featureConstraintRule.setSituation(featureConstraintRuleSituation);
			ruleList.addAdaptationRule(featureConstraintRule);

			timestamp++;
		}
		
		// constraints based on meta data
		
		for (MyLearningUnitConstraint learningUnitConstraint : this.learningUnitConstraints) {
			
			
			timestamp++;
		}
		
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