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
	
	public String stackTraceToString(Throwable e) {
	    StringBuilder sb = new StringBuilder();
	    for (StackTraceElement element : e.getStackTrace()) {
	        sb.append(element.toString());
	        sb.append("\n");
	    }
	    return sb.toString();
	}
}
