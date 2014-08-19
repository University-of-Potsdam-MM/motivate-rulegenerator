package de.unipotsdam.rulegenerator.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.ActionOperator;



/**
 * The Class Action.
 */
@XmlRootElement(name="action")
@XmlAccessorType(XmlAccessType.FIELD)
class Action {
	
	/** The operator. */
	@XmlElement
	private ActionOperator operator;

	/** The learning unit id. */
	@XmlElement
	private String learningUnitId;

	/**
	 * Instantiates a new local action.
	 */
	public Action() {
		this(ActionOperator.SELECT, null);
	}

	/**
	 * Instantiates a new local action.
	 * 
	 * @param operator
	 *            the operator
	 * @param learningUnitId
	 *            the learning unit id
	 */
	public Action(ActionOperator operator, String learningUnitId) {
		super();
		this.operator = operator;
		this.learningUnitId = learningUnitId;
	}

	@JsonIgnore
	public String description() {
		String description = new String();
		description = this.operator.name().replace("_", " ") + " " + this.learningUnitId;
		return description;
	}
	
	/**
	 * Gets the operator.
	 * 
	 * @return the operator
	 */
	public ActionOperator getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 * 
	 * @param operator
	 *            the new operator
	 */
	public void setOperator(ActionOperator operator) {
		this.operator = operator;
	}

	/**
	 * Gets the nugget id.
	 * 
	 * @return the nugget id
	 */
	public String getNuggetId() {
		return learningUnitId;
	}

	/**
	 * Sets the nugget id.
	 * 
	 * @param nuggetId
	 *            the new nugget id
	 */
	public void setNuggetId(String nuggetId) {
		this.learningUnitId = nuggetId;
	}
}
