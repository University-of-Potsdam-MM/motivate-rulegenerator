package de.unipotsdam.rulegenerator.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import de.unipotsdam.rulegenerator.enums.FactOperator;

@XmlRootElement(name = "factParameter")
@XmlAccessorType(XmlAccessType.FIELD)
public class FactParameter {

	/** The context information. */
	private String contextInformation;

	/** The operator. */
	private FactOperator operator;

	/** The value. */
	private String value;

	public FactParameter() { }
	
	public FactParameter(String contextInformation, FactOperator operator,
			String value) {
		super();
		this.contextInformation = contextInformation;
		this.operator = operator;
		this.value = value;
	}

	public String getContextInformation() {
		return contextInformation;
	}

	public void setContextInformation(String contextInformation) {
		this.contextInformation = contextInformation;
	}

	public FactOperator getOperator() {
		return operator;
	}

	public void setOperator(FactOperator operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
