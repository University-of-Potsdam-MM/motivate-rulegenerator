package de.unipotsdam.rulegenerator.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.LocalActionOperator;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalAction.
 */
public class LocalAction extends Action {

	/** The operator. */
	private LocalActionOperator operator;

	/** The nugget id. */
	private String nuggetId;

	/**
	 * Instantiates a new local action.
	 */
	public LocalAction() {
	}

	/**
	 * Instantiates a new local action.
	 * 
	 * @param operator
	 *            the operator
	 * @param nuggetId
	 *            the nugget id
	 */
	public LocalAction(LocalActionOperator operator, String nuggetId) {
		super();
		this.operator = operator;
		this.nuggetId = nuggetId;
	}

	@JsonIgnore
	public String description() {
		String description = new String();
		description = this.operator.name().replace("_", " ") + " " + this.nuggetId;
		return description;
	}
	
	/**
	 * Gets the operator.
	 * 
	 * @return the operator
	 */
	public LocalActionOperator getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 * 
	 * @param operator
	 *            the new operator
	 */
	public void setOperator(LocalActionOperator operator) {
		this.operator = operator;
	}

	/**
	 * Gets the nugget id.
	 * 
	 * @return the nugget id
	 */
	public String getNuggetId() {
		return nuggetId;
	}

	/**
	 * Sets the nugget id.
	 * 
	 * @param nuggetId
	 *            the new nugget id
	 */
	public void setNuggetId(String nuggetId) {
		this.nuggetId = nuggetId;
	}
}
