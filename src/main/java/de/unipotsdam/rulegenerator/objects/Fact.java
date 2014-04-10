package de.unipotsdam.rulegenerator.objects;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.enums.FactOperator;

// TODO: Auto-generated Javadoc
/**
 * The Class Fact.
 */
@XmlRootElement
public class Fact {

	/** The context information. */
	private String contextInformation;

	/** The operator. */
	private FactOperator operator;

	/** The value. */
	private String value;

	/** The logical operator. */
	private LogicalOperator logicalOperator;

	/** The left paranthesis. */
	private Boolean leftParanthesis = false;

	/** The right paranthesis. */
	private Boolean rightParanthesis = false;

	/**
	 * Instantiates a new fact.
	 */
	public Fact() {
	}

	/**
	 * Instantiates a new fact.
	 * 
	 * @param contextInformation
	 *            the context information
	 * @param operator
	 *            the operator
	 * @param value
	 *            the value
	 */
	public Fact(String contextInformation, FactOperator operator, String value) {
		super();
		this.setContextInformation(contextInformation);
		this.setOperator(operator);
		this.setValue(value);
	}

	/**
	 * Instantiates a new fact.
	 * 
	 * @param contextInformation
	 *            the context information
	 * @param operator
	 *            the operator
	 * @param value
	 *            the value
	 * @param logicalOperator
	 *            the logical operator
	 */
	public Fact(String contextInformation, FactOperator operator, String value,
			LogicalOperator logicalOperator) {
		super();
		this.setContextInformation(contextInformation);
		this.setOperator(operator);
		this.setValue(value);
		this.setLogicalOperator(logicalOperator);
	}

	/**
	 * Description.
	 * 
	 * @return the string
	 */
	@JsonIgnore
	public String description() {
		String description = new String();
		if (this.leftParanthesis)
			description += "(";
		description += this.getContextInformation() + " "
				+ this.getOperator().name().replace("_", " ") + " "
				+ this.getValue();
		if (this.rightParanthesis)
			description += ")";
		if (this.logicalOperator != null) {
			description += " " + this.logicalOperator.name().replace("_", " ");
		}
		return description;
	}

	/**
	 * Gets the context information.
	 * 
	 * @return the context information
	 */
	public String getContextInformation() {
		return contextInformation;
	}

	/**
	 * Sets the context information.
	 * 
	 * @param contextInformation
	 *            the new context information
	 */
	public void setContextInformation(String contextInformation) {
		this.contextInformation = contextInformation;
	}

	/**
	 * Gets the operator.
	 * 
	 * @return the operator
	 */
	public FactOperator getOperator() {
		return operator;
	}

	/**
	 * Sets the operator.
	 * 
	 * @param operator
	 *            the new operator
	 */
	public void setOperator(FactOperator operator) {
		this.operator = operator;
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

	/**
	 * Gets the left paranthesis.
	 * 
	 * @return the left paranthesis
	 */
	public Boolean getLeftParanthesis() {
		return leftParanthesis;
	}

	/**
	 * Sets the left paranthesis.
	 * 
	 * @param leftParanthesis
	 *            the new left paranthesis
	 */
	public void setLeftParanthesis(Boolean leftParanthesis) {
		this.leftParanthesis = leftParanthesis;
	}

	/**
	 * Gets the right paranthesis.
	 * 
	 * @return the right paranthesis
	 */
	public Boolean getRightParanthesis() {
		return rightParanthesis;
	}

	/**
	 * Sets the right paranthesis.
	 * 
	 * @param rightParanthesis
	 *            the new right paranthesis
	 */
	public void setRightParanthesis(Boolean rightParanthesis) {
		this.rightParanthesis = rightParanthesis;
	}
}
