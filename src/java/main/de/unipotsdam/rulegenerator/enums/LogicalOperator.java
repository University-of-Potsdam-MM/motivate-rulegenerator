package de.unipotsdam.rulegenerator.enums;

import javax.xml.bind.annotation.XmlRootElement;

import de.unipotsdam.rulegenerator.rules.FactSetElement;

// TODO: Auto-generated Javadoc
/**
 * The Enum LogicalOperator.
 */
@XmlRootElement
public enum LogicalOperator implements FactSetElement {
	/** The and. */
	AND,
	/** The or. */
	OR,
	/** The no value. */
	NO_VALUE
}
