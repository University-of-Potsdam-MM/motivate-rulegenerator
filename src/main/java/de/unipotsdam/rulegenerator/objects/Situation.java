package de.unipotsdam.rulegenerator.objects;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Situation.
 */
@XmlRootElement
public class Situation {

	/** The facts. */
	private Fact[] facts;

	public Situation() { }
	
	public Situation(Fact[] facts) {
		super();
		this.facts = facts;
	}
	
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
}
