package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@XmlType(name = "", propOrder = { "userFactsOperator", "constraints", "userFacts" })
public class Situation {
	@XmlTransient
	private final FactSet factSets = new FactSet();
	
	protected FactSet constraints = new FactSet();
	protected FactSet userFacts = new FactSet();

	private LogicalOperator userFactsOperator;

	/**
	 * Instantiates a new situation.
	 * 
	 * @throws Exception
	 */
	public Situation() throws Exception {
		this(LogicalOperator.AND);
	}

	public Situation(LogicalOperator logicalOperator) throws Exception {
		this.userFactsOperator = logicalOperator;
		this.factSets.addFactSet(this.constraints, LogicalOperator.AND);
		this.factSets.addFactSet(this.userFacts);
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

	public void addConstraint(FactSet constraint) throws Exception {
		this.constraints.addFactSet(constraint);
	}

	public void addConstraint(LogicalOperator constraint) throws Exception {
		this.constraints.addLogicalOperator(constraint);
	}

	public void addUserFact(FactSet userFact) throws Exception {
		this.userFacts.addFactSet(userFact);
	}

	public void addUserFact(LogicalOperator userFact) throws Exception {
		this.userFacts.addLogicalOperator(userFact);
	}

	public LogicalOperator getUserFactsOperator() {
		return userFactsOperator;
	}

	public void setUserFactsOperator(LogicalOperator userFactsOperator) {
		this.userFactsOperator = userFactsOperator;
	}

	public void addPrerequisites(
			Collection<? extends WrappedIndividual> prerequisites)
			throws Exception {
		// create fact set for prerequisites
		FactSet prerequisitesFactSet = new FactSet();
		// add facts to the fact set
		int i = 0;
		for (WrappedIndividual prerequisite : prerequisites) {
			MyLearningUnit prerequisiteLearningUnit = (MyLearningUnit) prerequisite;
			prerequisitesFactSet.addFact(new Fact(
					"FinishedLearningUnitMeasurableInformation",
					FactOperator.IS, prerequisiteLearningUnit.getID()));
			if (i < prerequisites.size() - 1)
				prerequisitesFactSet.addLogicalOperator(LogicalOperator.AND);
			i++;
		}
		this.constraints.addFactSet(prerequisitesFactSet);
	}

	public void applyTemplate(SituationTemplate template,
			MyLearningUnit currentLearningUnit) throws Exception {
		this.applyTemplate(template, currentLearningUnit, null);
	}

	public void applyTemplate(SituationTemplate template,
			MyLearningUnit currentLearningUnit,
			MyLearningUnit targetLearningUnit) throws Exception {
		switch (template) {
		case CURRENT_LEARNING_UNIT_FACTS:
			this.userFacts.addFactSet(currentLearningUnit.getFacts());
			break;
		case CURRENT_LEARNING_UNIT_ID:
			if (this.constraints.size() > 0)
				this.constraints.addLogicalOperator(LogicalOperator.AND);
			this.constraints.addFact(new Fact(
					"CurrentLearningUnitMeasurableInformation",
					FactOperator.IS, currentLearningUnit.getID()));
			break;
		case PREREQUISITES:
			if (currentLearningUnit.hasPrerequisites())
				this.addPrerequisites(currentLearningUnit.getPrerequisites());
			break;
		case TARGET_PREREQUISITES:
			if (targetLearningUnit.hasPrerequisites())
				this.addPrerequisites(targetLearningUnit.getPrerequisites());
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
			this.applyTemplate(SituationTemplate.TARGET_PREREQUISITES,
					currentLearningUnit, targetLearningUnit);
			break;
		default:
			break;
		}
	}
}
