package de.unipotsdam.rulegenerator.rules;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class AdaptationRule.
 */
@XmlRootElement
public class AdaptationRule {

	private String id;
	
	/** The triggering mode. */
	private Trigger trigger;
	
	/** The situation. */
	private Situation situation;
	
	/** The action. */
	private Action action;
	
	/**
	 * Instantiates a new adaptation rule.
	 */
	public AdaptationRule() { }
	
	/**
	 * Instantiates a new adaptation rule.
	 *
	 * @param id the id
	 */
	public AdaptationRule(String id) {
		this.setId(id);
	}
	
	@JsonIgnore
	public String description() {
		String description = new String();
		return description += this.trigger.description() + this.situation.description() + this.action.description();
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
	 * @param trigger the triggering mode
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
	 * @param situation the situation
	 */
	public void setSituation(Situation situation) {
		this.situation = situation;
	}
	
	public void addFact(Fact fact) {
		this.situation.addFact(fact);
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
	 * @param action the action
	 */
	public void setAction(Action action) {
		this.action = action;
	}
	
	public Boolean checkIntegrity() {
		return false;
	}
}
