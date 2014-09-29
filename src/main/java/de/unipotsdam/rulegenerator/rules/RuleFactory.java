package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.Collection;

import org.semanticweb.owlapi.model.OWLOntology;

import de.unipotsdam.rulegenerator.ontology.custom.MyFactory;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitClass;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitClassConstraint;
import de.unipotsdam.rulegenerator.rules.assembly.DefaultRuleAssembly;
import de.unipotsdam.rulegenerator.rules.assembly.RestrictFeatureRuleAssembly;
import de.unipotsdam.rulegenerator.rules.assembly.RuleAssembly;

public class RuleFactory {
	private OWLOntology ontology;
	private ArrayList<RuleAssembly> ruleAssemblies = new ArrayList<RuleAssembly>();
	private Collection<? extends MyLearningUnitClassConstraint> learningUnitClassConstraints;
	private LearningUnitClassFactSet hasLearningUnitClassConstraintFactSet = new LearningUnitClassFactSet();
	private LearningUnitClassFactSet hasNotLearningUnitClassConstraintFactSet = new LearningUnitClassFactSet();
	
	public RuleFactory(OWLOntology ontology) {
		super();

		this.ontology = ontology;
		// create ORM object factory
		MyFactory factory = new MyFactory(ontology);
		// get all learning unit individuals from ontology
		this.learningUnitClassConstraints = factory
				.getAllLearningUnitConstraintInstances();
		this.ruleAssemblies.add(new RestrictFeatureRuleAssembly(ontology));
		this.ruleAssemblies.add(new DefaultRuleAssembly(ontology));
	}

	public AdaptationRuleList generateRules() throws Exception {
		// delete existing rules?
		AdaptationRuleList adaptationRules = new AdaptationRuleList();
		
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
		
		for (RuleAssembly ruleAssembly : this.ruleAssemblies) {
			adaptationRules.addAdaptationRules(ruleAssembly.generateRules(hasLearningUnitClassConstraintFactSet, hasNotLearningUnitClassConstraintFactSet).getList());
		}

		return adaptationRules;
	}
}