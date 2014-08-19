package de.unipotsdam.rulegenerator.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import de.unipotsdam.rulegenerator.enums.DataType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ContextInformationParameter {
	private String id;
	private String name;
	private DataType dataType;
	private String[] range;
	private String[] possibleValues;
	private String defaultValue;
	private Boolean required;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public DataType getDataType() {
		return dataType;
	}
	
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public String[] getRange() {
		return range;
	}

	public void setRange(String[] range) {
		this.range = range;
	}

	public String[] getPossibleValues() {
		return possibleValues;
	}

	public void setPossibleValues(String[] possibleValues) {
		this.possibleValues = possibleValues;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}
}
