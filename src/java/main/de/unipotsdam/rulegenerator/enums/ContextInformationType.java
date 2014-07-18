package de.unipotsdam.rulegenerator.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Enum ContextInformationType.
 */
@XmlType
@XmlEnum(String.class)
public enum ContextInformationType {
	
	/** The low level raw. */
	@XmlEnumValue("LOW_LEVEL_RAW") LOW_LEVEL_RAW, 
	
	/** The low level normalized. */
	@XmlEnumValue("LOW_LEVEL_NORMALIZED") LOW_LEVEL_NORMALIZED, 
	
	/** The high level. */
	@XmlEnumValue("HIGH_LEVEL") HIGH_LEVEL
}