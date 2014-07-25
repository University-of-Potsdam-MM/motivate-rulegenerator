package de.unipotsdam.rulegenerator.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Services {	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String defaultResponse() {
		return "Use the provided application.wadl to get a list of all available interfaces.";
	}
}
