package de.unipotsdam.rulegenerator.enums;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import de.unipotsdam.rulegenerator.rules.FactSetElement;

// TODO: Auto-generated Javadoc
/**
 * The Enum LogicalOperator.
 */
@XmlRootElement(name = "logicalOperator")
@XmlAccessorType(XmlAccessType.FIELD)
public enum LogicalOperator implements FactSetElement {
	/** The and. */
	AND,
	/** The or. */
	OR,
	/** The no value. */
	NO_VALUE,
	MIXED;

	private LogicalOperator opposite;
	
	static {
		AND.opposite = OR;
		OR.opposite = AND;
		NO_VALUE.opposite = NO_VALUE;
		MIXED.opposite = MIXED;
	}

	public LogicalOperator getOpposite() {
		return opposite;
	}
}