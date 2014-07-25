package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;

@XmlRootElement(name="factSet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Fact.class, LogicalOperator.class})
public class FactSet implements FactSetElement {
	@XmlAnyElement
	private List<FactSetElement> children = new ArrayList<FactSetElement>();

	public List<FactSetElement> getChildren() {
		return children;
	}

	public void setChildren(List<FactSetElement> children) {
		this.children = children;
	}

	public void addFactSet(FactSet factSet) throws Exception {
		if (this.children.size() > 0
				&& this.getLastObject().getClass() != LogicalOperator.class)
			throw new Exception(
					"A fact set must not be preceded by another fact or fact set without an intermediate logical operator.");
		this.children.add(factSet);
	}

	public Object getLastObject() {
		return this.children.get(this.children.size() - 1);
	}

	public void addFactSet(FactSet factSet, LogicalOperator logicalOperator)
			throws Exception {
		this.addFactSet(factSet);
		this.addLogicalOperator(logicalOperator);
	}

	public void addFact(Fact fact) throws Exception {
		if (this.children.size() > 0
				&& this.getLastObject().getClass() != LogicalOperator.class)
			throw new Exception(
					"A fact must not be preceded by another fact or fact set without an intermediate logical operator.");
		this.children.add(fact);
	}

	public void addFact(Fact fact, LogicalOperator logicalOperator)
			throws Exception {
		this.addFact(fact);
		this.addLogicalOperator(logicalOperator);
	}

	public void addLogicalOperator(LogicalOperator logicalOperator)
			throws Exception {
		if (this.children.size() > 0
				&& this.getLastObject().getClass() == LogicalOperator.class)
			throw new Exception(
					"A logical operator can not be followed by another logical operator.");
		if (this.children.size() == 0)
			throw new Exception(
					"A fact set must not start with a logical operator.");
		this.children.add(logicalOperator);
	}
	
	public int size() {
		return this.children.size();
	}
}
