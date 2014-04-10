package de.unipotsdam.rulegenerator.jaxrs.contextinformation;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.unipotsdam.rulegenerator.objects.ContextInformationList;

@Path("/json/context-information")
public class ContextInformationServiceJSON extends ContextInformationService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ContextInformationList contextInformationJson()
			throws JsonParseException, JsonMappingException, IOException {
		return this.getContextInformations();
	}
}
