package de.unipotsdam.rulegenerator.rules;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.TriggeringMode;

// TODO: Auto-generated Javadoc
/**
 * The Class Trigger.
 */
public class Trigger {
	
	/** The mode. */
	private TriggeringMode mode;
	
	/** The time. */
	private Double time = 2.0;
	
	/**
	 * Instantiates a new trigger.
	 */
	public Trigger() { }
	
	/**
	 * Instantiates a new trigger.
	 *
	 * @param triggeringMode the triggering mode
	 */
	public Trigger(TriggeringMode triggeringMode) {
		super();
		this.setTriggeringMode(triggeringMode);
	}
	
	/**
	 * Instantiates a new trigger.
	 *
	 * @param triggeringMode the triggering mode
	 * @param interval the interval
	 */
	public Trigger(TriggeringMode triggeringMode, Double interval) {
		super();
		this.setTriggeringMode(triggeringMode);
		this.setInterval(interval);
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@JsonIgnore
	public String description() {
		return this.getMode().name().replace("_", " ") + " ";
	}
	
	/**
	 * Gets the mode.
	 *
	 * @return the mode
	 */
	public TriggeringMode getMode() {
		return mode;
	}
	
	/**
	 * Sets the triggering mode.
	 *
	 * @param mode the new triggering mode
	 */
	public void setTriggeringMode(TriggeringMode mode) {
		this.mode = mode;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public Double getTime() {
		return time;
	}

	/**
	 * Sets the interval.
	 *
	 * @param time the new interval
	 */
	public void setInterval(Double time) {
		this.time = time;
	}	
}
