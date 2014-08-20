package de.unipotsdam.rulegenerator.rules;

import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.unipotsdam.rulegenerator.enums.ActionOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnit;
import de.unipotsdam.rulegenerator.ontology.custom.MyLearningUnitClass;

// TODO: Auto-generated Javadoc
/**
 * The Class AdaptationRule.
 */
@XmlRootElement
@XmlType(name = "", propOrder = { "id", "trigger", "situation", "action",
		"negation" })
public class AdaptationRule {

	private String id;

	/** The triggering mode. */
	private Trigger trigger;

	/** The situation. */
	private Situation situation;

	/** The action. */
	private Action action;

	private Boolean negation = false;

	/**
	 * Instantiates a new adaptation rule.
	 */
	public AdaptationRule() {
	}

	/**
	 * Instantiates a new adaptation rule.
	 * 
	 * @param id
	 *            the id
	 */
	public AdaptationRule(String id) {
		this.setId(id);
	}

	public AdaptationRule(String id, ActionOperator operator,
			String targetLearningUnitId) {
		this.setId(id);
		this.setAction(new Action(operator, targetLearningUnitId));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the triggering mode.
	 * 
	 * @return the triggering mode
	 */
	public Trigger getTrigger() {
		return trigger;
	}

	/**
	 * Sets the triggering mode.
	 * 
	 * @param trigger
	 *            the triggering mode
	 */
	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	/**
	 * Gets the situation.
	 * 
	 * @return the situation
	 */
	public Situation getSituation() {
		return situation;
	}

	/**
	 * Sets the situation.
	 * 
	 * @param situation
	 *            the situation
	 */
	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	/**
	 * Gets the action.
	 * 
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 * 
	 * @param action
	 *            the action
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	public Boolean getNegation() {
		return negation;
	}

	public void setNegation(Boolean negation) {
		this.negation = negation;
	}

	@Deprecated
	public Boolean checkIntegrity() {
		return false;
	}

	// apply potential constraints
	public void applyLearningUnitConstraints(MyLearningUnit currentLearningUnit, LearningUnitClassFactSet learningUnitFactSet) throws Exception {
		if (currentLearningUnit.hasLearningUnitClass()) {
			System.out.println(currentLearningUnit.getID() + " has a learning unit class.");
			for (Entry<MyLearningUnitClass, FactSet> entry : learningUnitFactSet.getLearningUnitClassFactSets().entrySet()) {
				MyLearningUnitClass constraintLearningUnitClass = entry.getKey();
				FactSet factSet = entry.getValue();
				
				if (constraintLearningUnitClass.equals(currentLearningUnit.getLearningUnitClass())) {
					this.getSituation().constraints.addLogicalOperator(LogicalOperator.AND);;
					this.getSituation().constraints.addFactSet(factSet);
				}
			}
		}
	}
	
	public void optimize() throws Exception {
		this.getSituation().optimize();
	}
}
