package de.unipotsdam.rulegenerator.jaxrs.rules;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.unipotsdam.rulegenerator.objects.AdaptationRule;

@Path("/json/rules")
public class RuleGeneratorServiceJSON extends RuleGeneratorService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public AdaptationRule adaptationRuleJson() {
		return this.generateFakeRule();
	}
}
