package de.unipotsdam.rulegenerator.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import de.unipotsdam.rulegenerator.enums.FactOperator;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextInformation.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "name", "description", "dataType",
		"range", "acceptedFactOperators" })
public class ContextInformation {
	
	/** The id. */
	private String id;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The data type. */
	private String dataType;
	
	/** The range. */
	private String[] range;
	
	/** The accepted fact operators. */
	private List<FactOperator> acceptedFactOperators;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the data type.
	 *
	 * @return the data type
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * Sets the data type.
	 *
	 * @param dataType the new data type
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * Gets the accepted fact operators.
	 *
	 * @return the accepted fact operators
	 */
	public List<FactOperator> getAcceptedFactOperators() {
		return acceptedFactOperators;
	}

	/**
	 * Sets the accepted fact operators.
	 *
	 * @param acceptedFactOperators the new accepted fact operators
	 */
	public void setAcceptedFactOperators(List<FactOperator> acceptedFactOperators) {
		this.acceptedFactOperators = acceptedFactOperators;
	}
}