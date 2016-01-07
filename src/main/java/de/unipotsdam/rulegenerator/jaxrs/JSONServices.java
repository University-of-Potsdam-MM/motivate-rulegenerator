package de.unipotsdam.rulegenerator.jaxrs;

import de.unipotsdam.rulegenerator.jaxrs.services.ContextInformationService;
import de.unipotsdam.rulegenerator.jaxrs.services.ConversionService;
import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.jaxrs.services.StatisticsService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.TransformerFactoryConfigurationError;
import java.io.StringWriter;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONServices.
 */
@Path("/json")
public class JSONServices extends Services {
	final Logger logger = LoggerFactory.getLogger(JSONServices.class);
	
	@POST
	@Path("/get-adaptation-rules")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public AdaptationRuleList getAdaptationRules(@FormParam("ontologyABox") String aBox,
			@FormParam("ontologyId") String ontologyId)
			throws TransformerFactoryConfigurationError, Exception {
		return RuleGeneratorService.generateAdaptationRules(aBox, ontologyId);
	}

	@POST
	@Path("/get-statistics")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStatistics(@FormParam("ontologyABox") String aBox,
			@FormParam("ontologyId") String ontologyId) throws Exception {
		try {
			return StatisticsService.generateStatistics(aBox, ontologyId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@GET
	@Path("/get-context-information")
	@Produces(MediaType.APPLICATION_JSON)
	public String getContextInformation() throws Exception {
		String xmlString = ContextInformationService.getContextInformation();
		JSONObject jsonObject = XML.toJSONObject(xmlString);
		
		return jsonObject.toString();
	}
	
	@POST
	@Path("/convert-from-owl-xml")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String convertFromOWLXML(@FormParam("ontologyABox") String aBox) {
		try {
			String jsonld = ConversionService.convertOWLXMLToJSONLD(aBox);
			System.out.println(jsonld);
			return jsonld;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
