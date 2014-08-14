package de.unipotsdam.rulegenerator.rules;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.enums.ActionOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.TriggeringMode;
import de.unipotsdam.rulegenerator.ontology.ConstraintHead;
import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyConstraintHead;
import de.unipotsdam.rulegenerator.ontology.custom.MyConstraintTail;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

public class RuleFactory {
	private OWLOntology ontology;
	private Collection<? extends LearningUnit> learningUnits;
	private Collection<? extends ConstraintHead> constraints;

	public RuleFactory(OWLOntology ontology) {
		super();

		this.ontology = ontology;
		// create ORM object factory
		MyFactory factory = new MyFactory(ontology);
		// get all learning unit individuals from ontology
		this.learningUnits = factory.getAllLearningUnitInstances();
		this.constraints = factory.getAllConstraintHeadInstances();
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
		
		long timestamp = System.currentTimeMillis() / 1000;

		// constraints
		for (ConstraintHead constraint : this.constraints) {
			MyConstraintHead currentConstraint = (MyConstraintHead) constraint;

			System.out.println(currentConstraint.getSpecificConstraintType());

			// global constraints

			if (currentConstraint.getSpecificConstraintType().equals(
					"RestrictUsageConstraintHead")) {
				AdaptationRule restrictUsageRule = new AdaptationRule(
						"RestrictUsageRule["+timestamp+"]", ActionOperator.RESTRICT,
						null);
				restrictUsageRule.setNegation(true);
				restrictUsageRule.setTrigger(new Trigger(
						TriggeringMode.ON_ENTRY));
				Situation restrictUsageRuleSituation = new Situation();
				FactSet factSet = new FactSet();
				int i = 0;
				for (MyConstraintTail constraintTail : currentConstraint
						.getConstraintTails()) {
					Fact restrictUsageRuleFact = Fact
							.FactFromConstraintTail(constraintTail);
					factSet.addFact(restrictUsageRuleFact);
					if (i < currentConstraint.getConstraintTailCount() - 1) factSet.addLogicalOperator(LogicalOperator.valueOf(currentConstraint.getHasConstraintHeadLogicalOperator().toArray()[0].toString()));
						i++;
				}
				restrictUsageRuleSituation.addConstraint(factSet);
				restrictUsageRule.setSituation(restrictUsageRuleSituation);
				ruleList.addAdaptationRule(restrictUsageRule);

			}

			// per rule constraints

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