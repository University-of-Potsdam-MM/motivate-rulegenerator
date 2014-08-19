package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import de.unipotsdam.rulegenerator.enums.FactOperator;
import de.unipotsdam.rulegenerator.enums.LogicalOperator;
import de.unipotsdam.rulegenerator.ontology.custom.MyConstraintRequirement;
import de.unipotsdam.rulegenerator.ontology.custom.MyMeasurableContextInformation;

@XmlRootElement(name="factSet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Fact.class, LogicalOperator.class})
public class FactSet implements FactSetElement {
	@XmlAnyElement
	private List<FactSetElement> children = new ArrayList<FactSetElement>();

	static public FactSet FactSetFromConstraintRequirement(MyConstraintRequirement requirement) throws Exception {
		FactSet factSet = new FactSet();
		
		if (requirement.getSpecificTailType().equals("ContextInformationConstraintRequirement") && requirement.hasContextInformation()) {
			MyMeasurableContextInformation measurableInformation = (MyMeasurableContextInformation) requirement.getContextInformation().toArray()[0];
			factSet.addFact(new Fact(measurableInformation.getSpecificContextInformationType(), FactOperator.valueOf(measurableInformation.getValueOperator()), measurableInformation.getValue().toString()));
		} else if (requirement.getSpecificTailType().equals("IntervalConstraintRequirement") && requirement.hasHasStartingTime() && requirement.hasHasEndTime()) {
			String startingTime = requirement.getStartTime();
			String endTime = requirement.getEndTime();
			
			Fact startingTimeFact = new Fact("CurrentTimeMeasurableInformation", FactOperator.GREATER_THEN, startingTime);
			Fact endTimeFact = new Fact("CurrentTimeMeasurableInformation", FactOperator.LESS_THEN, endTime);
			
			factSet.addFact(startingTimeFact, LogicalOperator.AND, endTimeFact);
		} else if (requirement.getSpecificTailType().equals("RankingConstraintRequirement")) {
			
		} else if (requirement.getSpecificTailType().equals("MetaDataConstraintRequirement")) {
			
		}
		
		return factSet;
	}

	
	public List<FactSetElement> getChildren() {
		return children;
	}

	public void setChildren(List<FactSetElement> children) {
		this.children = children;
	}

	public void addFactSet(FactSet factSet) throws Exception {
		if (this.children.size() > 0
				&& this.getLastObject().getClass() != LogicalOperator.class) {
			throw new Exception(
					"A fact set must not be preceded by another fact or fact set without an intermediate logical operator. Last Object Class: "+this.getLastObject().getClass());
		} else {
			this.children.add(factSet);
		}
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
	
	public void addFact(Fact firstFact, LogicalOperator logicalOperator, Fact secondFact)
			throws Exception {
		this.addFact(firstFact);
		this.addLogicalOperator(logicalOperator);
		this.addFact(secondFact);
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
