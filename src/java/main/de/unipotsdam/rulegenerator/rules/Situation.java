package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.protege.owl.codegeneration.WrappedIndividual;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.SituationTemplate;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class Situation.
 */
@XmlRootElement
public class Situation {

	/** The facts. */
	protected List<Fact> facts = new ArrayList<Fact>();

	/** The logical operator. */
	private LogicalOperator logicalOperator;

	/**
	 * Instantiates a new situation.
	 */
	public Situation() {
		this(LogicalOperator.AND, new ArrayList<Fact>());
	}

	public Situation(LogicalOperator logicalOperator) {
		this(logicalOperator, new ArrayList<Fact>());
	}

	/**
	 * Instantiates a new situation.
	 * 
	 * @param facts
	 *            the facts
	 * @param logicalOperator
	 *            the logical operator
	 */
	public Situation(LogicalOperator logicalOperator, List<Fact> facts) {
		super();
		this.logicalOperator = logicalOperator;
		this.facts = facts;
	}

	public Situation(SituationTemplate template,
			MyLearningUnit currentLearningUnit) {
		this(template, currentLearningUnit, null);
	}

	public Situation(SituationTemplate template,
			MyLearningUnit currentLearningUnit,
			MyLearningUnit targetLearningUnit) {
		this.applyTemplate(template, currentLearningUnit, targetLearningUnit);
	}

	/**
	 * Returns a human readable description of the situation part of an
	 * adaptation rule.
	 * 
	 * @return the string
	 */
	@JsonIgnore
	public String description() {
		String description = new String();
		for (Fact fact : this.getFacts()) {
			description += fact.description() + " ";
		}
		return description;
	}

	/**
	 * Gets the logical operator.
	 * 
	 * @return the logical operator
	 */
	public LogicalOperator getLogicalOperator() {
		return logicalOperator;
	}

	/**
	 * Sets the logical operator.
	 * 
	 * @param logicalOperator
	 *            the new logical operator
	 */
	public void setLogicalOperator(LogicalOperator logicalOperator) {
		this.logicalOperator = logicalOperator;
	}

	public List<Fact> getFacts() {
		return facts;
	}

	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}

	public void addFact(Fact fact) {
		this.facts.add(fact);
	}

	public void addFacts(List<Fact> facts) {
		for (Fact fact : facts) {
			this.addFact(fact);
		}
	}

	public void addPrerequisites(
			Collection<? extends WrappedIndividual> prerequisites) {
		for (WrappedIndividual prerequisite : prerequisites) {
			MyLearningUnit prerequisiteLearningUnit = (MyLearningUnit) prerequisite;
			this.addFact(new Fact("FinishedLearningUnitMeasurableInformation",
					FactOperator.IS, prerequisiteLearningUnit.getID()));
		}
	}

	public void applyTemplate(SituationTemplate template,
			MyLearningUnit currentLearningUnit) {
		this.applyTemplate(template, currentLearningUnit, null);
	}

	public void applyTemplate(SituationTemplate template,
			MyLearningUnit currentLearningUnit,
			MyLearningUnit targetLearningUnit) {
		switch (template) {
		case CURRENT_LEARNING_UNIT_FACTS_AND_PREREQUISITES:
			this.addFacts(currentLearningUnit.getFacts());
			// add possible prerequisites
			if (currentLearningUnit.hasPrerequisites())
				this.addPrerequisites(currentLearningUnit.getPrerequisites());
			break;
		case CURRENT_LEARNING_UNIT_ID_AND_PREREQUISITES:
			this.addFact(new Fact("CurrentLearningUnitMeasurableInformation",
					FactOperator.IS, currentLearningUnit.getID()));
			// add possible prerequisites
			if (currentLearningUnit.hasPrerequisites())
				this.addPrerequisites(currentLearningUnit.getPrerequisites());
			break;
		case CURRENT_LEARNING_UNIT_ID_AND_TARGET_PREREQUISITES:
			this.addFact(new Fact("CurrentLearningUnitMeasurableInformation",
					FactOperator.IS, currentLearningUnit.getID()));
			// add possible prerequisites
			if (targetLearningUnit.hasPrerequisites())
				this.addPrerequisites(targetLearningUnit.getPrerequisites());
			break;

		default:
			break;
		}
	}
}
