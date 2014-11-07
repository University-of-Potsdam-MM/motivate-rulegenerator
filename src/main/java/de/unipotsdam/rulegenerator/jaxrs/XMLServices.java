package de.unipotsdam.rulegenerator.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLServices.
 */
@Path("/xml")
public class XMLServices extends Services {
	
	/**
	 * Adaptation rule xml.
	 * 
	 * @return the adaptation rule list
	 * @throws Exception 
	 */
	@GET
	@Path("/get-adaptation-rules")
	@Produces(MediaType.TEXT_XML)
	public AdaptationRuleList getAdaptationRules() throws Exception {
		return RuleGeneratorService.generateAdaptationRules(null, null);
	}
}
