package de.unipotsdam.rulegenerator.jaxrs;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.unipotsdam.rulegenerator.jaxrs.services.ContextInformationService;
import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import de.unipotsdam.rulegenerator.rules.ContextInformation;
import de.unipotsdam.rulegenerator.rules.ContextInformationList;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLServices.
 */
@Path("/xml")
public class XMLServices extends Services {

	/**
	 * Context information xml.
	 * 
	 * @return the context information list
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@GET
	@Path("/get-context-information")
	@Produces(MediaType.TEXT_XML)
	public ContextInformationList getContextInformation()
			throws JsonParseException, JsonMappingException, IOException {
		return ContextInformationService.getContextInformation();
	}

	/**
	 * Context information json.
	 * 
	 * @param id
	 *            the id
	 * @return the context information
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@GET
	@Path("/get-context-information/{id}")
	@Produces(MediaType.TEXT_XML)
	public ContextInformation getContextInformation(@PathParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		return ContextInformationService.getContextInformation(id);
	}

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
		return RuleGeneratorService.generateAdaptationRules();
	}
}
