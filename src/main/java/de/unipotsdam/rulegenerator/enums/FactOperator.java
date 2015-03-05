package de.unipotsdam.rulegenerator.enums;

import com.hp.hpl.jena.reasoner.rulesys.builtins.LE;

// TODO: Auto-generated Javadoc
/**
 * The Enum FactOperator.
 */
public enum FactOperator {
	/** The is. */
	IS,
	/** The is not. */
	IS_NOT,
	/** The greater then. */
	GREATER_THEN,
	/** The less then. */
	LESS_THEN,
	/** The devide. */
	DEVIDE,
	/** The multiply. */
	MULTIPLY,
	/** The subtract. */
	SUBTRACT,
	/** The sum. */
	SUM,
	/** The no value. */
	NO_VALUE,
	/** The contains. */
	CONTAINS,
	/** The complete. */
	COMPLETE;
	
	private FactOperator opposite;
	
	static {
		IS.opposite = IS_NOT;
		IS_NOT.opposite = IS;
		GREATER_THEN.opposite = LESS_THEN;
		LESS_THEN.opposite = GREATER_THEN;
		DEVIDE.opposite = DEVIDE;
		MULTIPLY.opposite = MULTIPLY;
		SUBTRACT.opposite = SUBTRACT;
		SUM.opposite = SUM;
		NO_VALUE.opposite = NO_VALUE;
		CONTAINS.opposite = CONTAINS;
		COMPLETE.opposite = COMPLETE;
	}
	
	public FactOperator getOpposite() {
		return opposite;
	}
}