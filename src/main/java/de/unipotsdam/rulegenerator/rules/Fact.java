package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import de.unipotsdam.rulegenerator.enums.DescriptionType;
import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.ontology.custom.MyContextInformationParameter;
import de.unipotsdam.rulegenerator.ontology.custom.MyMeasurableContextInformation;

// TODO: Auto-generated Javadoc
/**
 * The Class Fact.
 */
@XmlRootElement(name = "fact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fact implements FactSetElement {

	/** The context information. */
	private String contextInformation;

	@XmlElementWrapper(name = "factParameters")
	@XmlElement(name = "factParameter")
	private List<FactParameter> factParameters = new ArrayList<FactParameter>();

	/** The operator. */
	private FactOperator operator;

	/** The value. */
	private String value;

	public static Fact FactFromFactSet(FactSet factSet)
			throws java.lang.Exception {
		if (!factSet.hasChildren()
				|| factSet.getChildrenCount() > 1
				|| (factSet.hasChildren() && factSet.getLastObject().getClass() != Fact.class)) {
			throw new java.lang.Exception(
					"A fact can only be created from a fact set with exactly one fact as a child.");
		} else {
			return (Fact) factSet.getLastObject();
		}
	}
	
	public static Fact FactFromContextInformation(
			MyMeasurableContextInformation contextInformation) {
		Fact fact = new Fact();
		fact.setContextInformation(contextInformation
				.getSpecificContextInformationType());
		fact.setValue(contextInformation.getValue().toString());
		fact.setOperator(FactOperator.valueOf(contextInformation
				.getValueOperator()));
		if (contextInformation.hasContextInformationParameters()) {
			for (MyContextInformationParameter contextInformationParameter : contextInformation
					.getContextInformationParameters()) {
				FactParameter factParameter = new FactParameter(
						contextInformationParameter.getSpecificType(),
						FactOperator.IS, contextInformationParameter.getValue()
								.toString());
				fact.addFactParameter(factParameter);
			}
		}
		return fact;
	}

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

	// Fact Parameters

	public List<FactParameter> getFactParameters() {
		return factParameters;
	}

	public void setFactParameters(List<FactParameter> factParameters) {
		this.factParameters = factParameters;
	}

	public void addFactParameter(FactParameter factParameter) {
		this.factParameters.add(factParameter);
	}

	// Fact Operator

	/**
	 * Gets the operator.
	 * 
	 * @return the operator
	 */
	public FactOperator getOperator() {
		return operator;
	}

	public String getOperator(DescriptionType descriptionType) {
		String operator = new String();
		if (descriptionType == DescriptionType.NOOLS_DSL) {
			if (this.operator == FactOperator.IS) {
				operator = "=";
			} else if (this.operator == FactOperator.IS_NOT) {
				operator = "!=";
			} else if (this.operator == FactOperator.LESS_THEN) {
				operator = "<";
			}
		} else if (descriptionType == DescriptionType.NOOLS_JSON) {

		} else {
			operator = this.getOperator().name().replace("_", " ");
		}
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

	@Override
	public void optimize() {
		// nothing to do here, yet
	}
}
