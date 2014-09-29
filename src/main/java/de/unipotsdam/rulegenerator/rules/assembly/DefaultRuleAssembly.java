package de.unipotsdam.rulegenerator.rules.assembly;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.ontology.LearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.LearningUnitClassFactSet;
import de.unipotsdam.rulegenerator.rules.PreloadAdaptationRule;
import de.unipotsdam.rulegenerator.rules.SelectAdaptationRule;

public class DefaultRuleAssembly extends RuleAssembly {
	private Collection<? extends MyLearningUnit> learningUnits;
	
	public DefaultRuleAssembly(OWLOntology ontology) {
		super();
		
		this.ontology = ontology;
		MyFactory factory = new MyFactory(ontology);
		this.learningUnits = factory.getAllLearningUnitInstances();
	}
	
	public Collection<? extends LearningUnit> getLearningUnits() {
		return learningUnits;
	}

	public void setLearningUnits(
			Collection<? extends MyLearningUnit> learningUnits) {
		this.learningUnits = learningUnits;
	}
	
	@Override
	public AdaptationRuleList generateRules(LearningUnitClassFactSet hasLearningUnitClassConstraintFactSet, LearningUnitClassFactSet hasNotLearningUnitClassConstraintFactSet) throws Exception {
		for (MyLearningUnit currentLearningUnit : learningUnits) {

			/** SELECT() **/

			// create a select rule for the current learning unit if its context
			// information are present
			if (currentLearningUnit.getContextInformationCount() > 0)
				adaptationRules.addAdaptationRule(new SelectAdaptationRule(
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
						adaptationRules.addAdaptationRule(new PreloadAdaptationRule(
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
						adaptationRules.addAdaptationRule(new PreloadAdaptationRule(
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
						adaptationRules.addAdaptationRule(new PreloadAdaptationRule(
								currentLearningUnit, helpLearningUnit));
					}
				}

			}
		}
		return adaptationRules;
	}

}
