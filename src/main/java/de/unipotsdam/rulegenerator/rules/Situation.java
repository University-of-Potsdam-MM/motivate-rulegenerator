package de.unipotsdam.rulegenerator.rules;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.protege.owl.codegeneration.WrappedIndividual;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.SituationTemplate;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class Situation.
 */
@XmlRootElement(name = "situation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "factSets", "relationFacts", "contextFacts"})
public class Situation {
	
	private final FactSet factSets = new FactSet();

	protected FactSet relationFacts = new FactSet();
	protected FactSet contextFacts = new FactSet();

	public Situation() throws Exception {
		this.factSets.addFactSet(this.relationFacts, LogicalOperator.AND);
		this.factSets.addFactSet(this.contextFacts);
	}

	public Situation(SituationTemplate template,
			MyLearningUnit currentLearningUnit) throws Exception {
		this(template, currentLearningUnit, null);
	}

	public Situation(SituationTemplate template,
			MyLearningUnit currentLearningUnit,
			MyLearningUnit targetLearningUnit) throws Exception {
		this.applyTemplate(template, currentLearningUnit, targetLearningUnit);
	}

	public void addRelationFact(FactSetElement relationFact) throws Exception {
		this.relationFacts.addFactSetElement(relationFact);
	}

	public void addContextFact(FactSetElement contextFact) throws Exception {
		this.contextFacts.addFactSetElement(contextFact);
	}

	public void addPrerequisites(
			Collection<? extends MyLearningUnit> prerequisites)
			throws Exception {
		// create fact set for prerequisites
		FactSet prerequisitesFactSet = new FactSet();
		// add facts to the fact set
		int i = 0;
		for (WrappedIndividual prerequisite : prerequisites) {
			MyLearningUnit prerequisiteLearningUnit = (MyLearningUnit) prerequisite;
			// check if prerequisite has alternative presentations
			if (prerequisiteLearningUnit.hasAlternatives()) {
				// create fact set for alternative prerequisite representations
				FactSet alternativePrerequisitesFactSets = new FactSet();
				// add the prerequisite learning unit to the fact set
				alternativePrerequisitesFactSets.addFact(new Fact(
						"CI_FINISHED_LEARNING_UNIT",
						FactOperator.IS, prerequisiteLearningUnit.getID()),
						LogicalOperator.OR);
				// iterate over the alternative representations
				int j = 0;
				for (WrappedIndividual wrappedIndividual : prerequisiteLearningUnit
						.getAlternatives()) {
					MyLearningUnit alternativePrerequisiteLearningUnit = (MyLearningUnit) wrappedIndividual;
					// add the prerequisite learning unit to the fact set
					alternativePrerequisitesFactSets.addFact(new Fact(
							"CI_FINISHED_LEARNING_UNIT",
							FactOperator.IS,
							alternativePrerequisiteLearningUnit.getID()));
					if (j < prerequisiteLearningUnit.getAlternativesCount() - 1)
						alternativePrerequisitesFactSets
								.addLogicalOperator(LogicalOperator.OR);
					j++;
				}
				prerequisitesFactSet
						.addFactSet(alternativePrerequisitesFactSets);
			} else {
				// add the prerequisite learning unit to the fact set
				prerequisitesFactSet.addFact(new Fact(
						"CI_FINISHED_LEARNING_UNIT",
						FactOperator.IS, prerequisiteLearningUnit.getID()));
			}
			if (i < prerequisites.size() - 1)
				prerequisitesFactSet.addLogicalOperator(LogicalOperator.AND);
			i++;
		}
		this.relationFacts.addFactSet(prerequisitesFactSet);
	}

	public void applyTemplate(SituationTemplate template,
			MyLearningUnit learningUnit) throws Exception {
		this.applyTemplate(template, learningUnit, null);
	}

	public void applyTemplate(SituationTemplate template,
			MyLearningUnit currentLearningUnit,
			MyLearningUnit targetLearningUnit) throws Exception {
		switch (template) {
		case CURRENT_LEARNING_UNIT_FACTS:
			if (currentLearningUnit.getContextInformationCount() > 0)
				this.contextFacts
						.addFactSetElement(currentLearningUnit.getFacts());
			break;
		case CURRENT_LEARNING_UNIT_ID:
			if (this.relationFacts.size() > 0)
				this.relationFacts.addLogicalOperator(LogicalOperator.AND);
			this.relationFacts.addFact(new Fact("CI_CURRENT_LEARNING_UNIT",
					FactOperator.IS, currentLearningUnit.getID()));
			break;
		case PREREQUISITES:
			if (currentLearningUnit.hasPrerequisites()) {
				if (this.relationFacts.size() > 0)
					this.relationFacts.addLogicalOperator(LogicalOperator.AND);
				this.addPrerequisites(currentLearningUnit.getPrerequisites());
			}
			break;
		case CURRENT_LEARNING_UNIT_FACTS_AND_PREREQUISITES:
			this.applyTemplate(SituationTemplate.CURRENT_LEARNING_UNIT_FACTS,
					currentLearningUnit);
			// add possible prerequisites
			this.applyTemplate(SituationTemplate.PREREQUISITES,
					currentLearningUnit);
			break;
		case CURRENT_LEARNING_UNIT_ID_AND_PREREQUISITES:
			this.applyTemplate(SituationTemplate.CURRENT_LEARNING_UNIT_ID,
					currentLearningUnit);
			// add possible prerequisites
			this.applyTemplate(SituationTemplate.PREREQUISITES,
					currentLearningUnit);
			break;
		case CURRENT_LEARNING_UNIT_ID_AND_TARGET_PREREQUISITES:
			this.applyTemplate(SituationTemplate.CURRENT_LEARNING_UNIT_ID,
					currentLearningUnit);
			// add possible prerequisites
			this.applyTemplate(SituationTemplate.PREREQUISITES,
					targetLearningUnit);
			break;
		default:
			break;
		}
	}
}
