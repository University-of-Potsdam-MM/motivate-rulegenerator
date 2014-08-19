package de.unipotsdam.rulegenerator.rules;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "adaptationRules")
public class AdaptationRuleList {
	@XmlElement(name = "adaptationRule")
	@JsonProperty("adaptationRule")
	private List<AdaptationRule> list = new ArrayList<AdaptationRule>();

	public List<AdaptationRule> getList() {
		return list;
	}

	public void setList(List<AdaptationRule> list) {
		this.list = list;
	}
	
	public void addAdaptationRule(AdaptationRule adaptationRule) {
		this.list.add(adaptationRule);
	}
}
