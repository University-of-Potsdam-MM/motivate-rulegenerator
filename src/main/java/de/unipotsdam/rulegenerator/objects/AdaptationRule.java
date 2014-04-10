package de.unipotsdam.rulegenerator.objects;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class AdaptationRule.
 */
@XmlRootElement
public class AdaptationRule {

	/** The id. */
	private String id;
	
	/** The triggering mode. */
	private Trigger triggeringMode;
	
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
	
	/**
	 * Returns the rule in a human readable form.
	 *
	 * @return human readable rule description
	 */
	@JsonIgnore
	public String description() {
		String description = new String();
		description += this.triggeringMode.description() + this.situation.description() + this.action.description();
		return description;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the triggering mode.
	 *
	 * @return the triggering mode
	 */
	public Trigger getTriggeringMode() {
		return triggeringMode;
	}

	
	/**
	 * Sets the triggering mode.
	 *
	 * @param triggeringMode the triggering mode
	 */
	public void setTriggeringMode(Trigger triggeringMode) {
		this.triggeringMode = triggeringMode;
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
}
