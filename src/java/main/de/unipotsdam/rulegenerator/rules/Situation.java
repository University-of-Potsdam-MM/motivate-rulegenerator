package de.unipotsdam.rulegenerator.rules;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;

// TODO: Auto-generated Javadoc
/**
 * The Class Situation.
 */
@XmlRootElement
public class Situation {

	/** The facts. */
	private Fact[] facts;

	/** The logical operator. */
	private LogicalOperator logicalOperator;
	
	/**
	 * Instantiates a new situation.
	 */
	public Situation() { }
	
	/**
	 * Instantiates a new situation.
	 *
	 * @param facts the facts
	 * @param logicalOperator the logical operator
	 */
	public Situation(Fact[] facts, LogicalOperator logicalOperator) {
		super();
		this.facts = facts;
		this.logicalOperator = logicalOperator;
	}
	
	/**
	 * Returns a human readable description of the situation part of an adaptation rule.
	 *
	 * @return the string
	 */
	@JsonIgnore
	public String description() {
		String description = new String();
		for (Fact fact: this.getFacts()) {
			description += fact.description() + " ";
		}
		return description;
	}

	/**
	 * Gets the facts.
	 *
	 * @return the facts
	 */
	public Fact[] getFacts() {
		return facts;
	}

	/**
	 * Sets the facts.
	 *
	 * @param facts the facts
	 */
	public void setFacts(Fact[] facts) {
		this.facts = facts;
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
	 * @param logicalOperator the new logical operator
	 */
	public void setLogicalOperator(LogicalOperator logicalOperator) {
		this.logicalOperator = logicalOperator;
	}
}
