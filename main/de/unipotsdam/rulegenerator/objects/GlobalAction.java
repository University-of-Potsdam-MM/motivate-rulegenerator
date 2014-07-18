package de.unipotsdam.rulegenerator.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.GlobalActionOperator;

// TODO: Auto-generated Javadoc
/**
 * The Class GlobalAction.
 */
public class GlobalAction extends Action {

	/** The operator. */
	private GlobalActionOperator operator;

	/** The property. */
	private String property;

	/** The value. */
	private String value;

	/**
	 * Instantiates a new global action.
	 */
	public GlobalAction() {
	}

	/**
	 * Instantiates a new global action.
	 * 
	 * @param operator
	 *            the operator
	 * @param property
	 *            the property
	 * @param value
	 *            the value
	 */
	public GlobalAction(GlobalActionOperator operator, String property,
			String value) {
		super();
		this.operator = operator;
		this.property = property;
		this.value = value;
	}

	@JsonIgnore
	public String description() {
		String description = new String();
		description = this.operator.name().replace("_", " ") + " "
				+ this.getProperty();
		if (this.value != null) {
			description += " " + this.getValue();
		}
		return description;
	}

	/**
	 * Gets the operator.
	 * 
	 * @return the operator
	 */
	public GlobalActionOperator getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 * 
	 * @param operator
	 *            the new operator
	 */
	public void setOperator(GlobalActionOperator operator) {
		this.operator = operator;
	}

	/**
	 * Gets the property.
	 * 
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * Sets the property.
	 * 
	 * @param property
	 *            the new property
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
