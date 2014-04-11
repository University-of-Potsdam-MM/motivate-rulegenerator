package de.unipotsdam.rulegenerator.jaxrs;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.unipotsdam.rulegenerator.jaxrs.services.ContextInformationService;
import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.objects.AdaptationRule;
import de.unipotsdam.rulegenerator.objects.ContextInformationList;

@Path("/json")
public class JSONServices extends Services {
	
	@GET
	@Path("/context-information")
	@Produces(MediaType.APPLICATION_JSON)
	public ContextInformationList contextInformationJson()
			throws JsonParseException, JsonMappingException, IOException {
		return ContextInformationService.getContextInformations();
	}

	@GET
	@Path("/rules")
	@Produces(MediaType.APPLICATION_JSON)
	public AdaptationRule adaptationRuleJson() {
		return RuleGeneratorService.generateFakeRule();
	}
}
