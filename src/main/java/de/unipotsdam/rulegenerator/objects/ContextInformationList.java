package de.unipotsdam.rulegenerator.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "contextInformations")
public class ContextInformationList {
	@XmlElement(name = "contextInformation")
	@JsonProperty("contextInformations")
	private List<ContextInformation> contextInformationList;

	public List<ContextInformation> getContextInformationList() {
		return contextInformationList;
	}

	public void setContextInformationList(
			List<ContextInformation> contextInformationList) {
		this.contextInformationList = contextInformationList;
	}
}