package de.unipotsdam.rulegenerator.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.LocalActionOperator;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalAction.
 */
@XmlRootElement(name="action")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalAction extends Action {

	/** The operator. */
	@XmlElement
	private LocalActionOperator operator;

	/** The learning unit id. */
	@XmlElement
	private String learningUnitId;

	/**
	 * Instantiates a new local action.
	 */
	public LocalAction() {
		this(LocalActionOperator.SHOW, null);
	}

	/**
	 * Instantiates a new local action.
	 * 
	 * @param operator
	 *            the operator
	 * @param learningUnitId
	 *            the learning unit id
	 */
	public LocalAction(LocalActionOperator operator, String learningUnitId) {
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
