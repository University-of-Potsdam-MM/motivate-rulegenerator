package de.unipotsdam.rulegenerator.rules;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The Class Action.
 */
@XmlTransient //Prevents the mapping of a JavaBean property/type to XML representation
@XmlSeeAlso({LocalAction.class, GlobalAction.class})
abstract class Action {
	@JsonIgnore
	public abstract String description();
}
