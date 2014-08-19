package de.unipotsdam.rulegenerator.rules;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "contextInformationList")
public class ContextInformationList {
	@XmlElement(name = "contextInformation")
	@JsonProperty("contextInformations")
	private List<ContextInformation> list;

	public List<ContextInformation> getList() {
		return list;
	}

	public void setList(List<ContextInformation> contextInformationList) {
		this.list = contextInformationList;
	}

	public ContextInformation getContextInformation(String id) {
		for (ContextInformation contextInformation : this.getList()) {
			if (contextInformation.getId().equals(id))
				return contextInformation;
		}
		return null;
	}
}