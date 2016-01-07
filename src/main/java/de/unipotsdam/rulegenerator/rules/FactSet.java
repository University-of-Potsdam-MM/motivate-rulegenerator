package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.custom.MyConstraintRequirement;
import de.unipotsdam.rulegenerator.ontology.custom.MyContextInformation;

@XmlRootElement(name = "factSet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ Fact.class, LogicalOperator.class })
public class FactSet implements FactSetElement {
	@XmlAnyElement
	private List<FactSetElement> children = new ArrayList<FactSetElement>();

	static public FactSet FactSetFromConstraintRequirement(
			MyConstraintRequirement requirement) throws Exception {
		return FactSetFromConstraintRequirement(requirement, false);
	}

	static public FactSet FactSetFromConstraintRequirement(
			MyConstraintRequirement requirement, Boolean negateValueOperator) throws Exception {
		FactSet factSet = new FactSet();

		if (requirement.getSpecificTailType().equals(
				"ContextInformationConstraintRequirement")
				&& requirement.hasContextInformation()) {
			MyContextInformation measurableInformation = (MyContextInformation) requirement
					.getContextInformation().toArray()[0];
			factSet.addFact(Fact
					.FactFromContextInformation(measurableInformation, negateValueOperator));
		} else if (requirement.getSpecificTailType().equals(
				"RankingConstraintRequirement")) {

		} else if (requirement.getSpecificTailType().equals(
				"MetaDataConstraintRequirement")) {

		}

		return factSet;
	}

	static public FactSet FactSetFromFact(Fact fact) throws Exception {
		FactSet factSet = new FactSet();
		factSet.addFact(fact);
		return factSet;
	}

	public String description() {
		String description = new String();
		int i = 0;
		for (FactSetElement child : this.getChildren()) {
			if (child.getClass() == LogicalOperator.class) {
				description += child;
			} else {
				description += child.getClass().getSimpleName();
			}
			if (i < this.getChildrenCount() - 1) {
				description += " ";
			}
			i++;
		}
		return description;
	}

	public Boolean hasChildren() {
		return this.getChildrenCount() > 0;
	}

	public Integer getChildrenCount() {
		return this.children.toArray().length;
	}

	public List<FactSetElement> getChildren() {
		return children;
	}

	public void setChildren(List<FactSetElement> children) {
		this.children = children;
	}

	public void addFactSet(FactSet factSet) throws Exception {
		if (this.children.size() > 0
				&& this.getLastChild().getClass() != LogicalOperator.class) {
			throw new Exception(
					"A fact set must not be preceded by another fact or fact set without an intermediate logical operator. Last Object Class: "
							+ this.getLastChild().getClass());
		} else {
			if (factSet.getChildrenCount() > 1 && factSet.getLogicalOperator() == LogicalOperator.AND) {
				for (FactSetElement factSetElement : factSet.getChildren()) {
					this.children.add(factSetElement);
				}
			} else if (factSet.getChildrenCount() == 1) {
				this.children.add(factSet.getLastChild());
			} else {
				this.children.add(factSet);
			}
		}
	}

	public FactSetElement getLastChild() {
		return this.children.get(this.children.size() - 1);
	}

	public void addFactSet(FactSet factSet, LogicalOperator logicalOperator)
			throws Exception {
		this.addFactSet(factSet);
		this.addLogicalOperator(logicalOperator);
	}

	public void addFactSetElement(FactSetElement factSetElement) throws Exception {
		if (factSetElement.getClass() == FactSet.class) {
			this.addFactSet((FactSet) factSetElement);
		} else if (factSetElement.getClass() == Fact.class) {
			this.addFact((Fact) factSetElement);
		} else if (factSetElement.getClass() == LogicalOperator.class) {
			this.addLogicalOperator((LogicalOperator) factSetElement);
		}
	}
	
	public void addFact(Fact fact) throws Exception {
		if (this.children.size() > 0
				&& this.getLastChild().getClass() != LogicalOperator.class)
			throw new Exception(
					"A fact must not be preceded by another fact or fact set without an intermediate logical operator.");
		this.children.add(fact);
	}

	public void addFact(Fact fact, LogicalOperator logicalOperator)
			throws Exception {
		this.addFact(fact);
		this.addLogicalOperator(logicalOperator);
	}

	public void addFact(Fact firstFact, LogicalOperator logicalOperator,
			Fact secondFact) throws Exception {
		this.addFact(firstFact);
		this.addLogicalOperator(logicalOperator);
		this.addFact(secondFact);
	}

	public void addLogicalOperator(LogicalOperator logicalOperator)
			throws Exception {
		if (this.children.size() > 0
				&& this.getLastChild().getClass() == LogicalOperator.class)
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

	public LogicalOperator getLogicalOperator() {
		LogicalOperator logicalOperator = LogicalOperator.NO_VALUE;
		for (FactSetElement factSetElement : this.children) {
			if (factSetElement.getClass() == LogicalOperator.class) {
				if (logicalOperator == LogicalOperator.NO_VALUE) {
					logicalOperator = (LogicalOperator) factSetElement;
				} else if (logicalOperator != factSetElement) {
					logicalOperator = LogicalOperator.MIXED;
				}
			}
		}
		return logicalOperator;
	}
}
