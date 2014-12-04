package de.unipotsdam.rulegenerator.jaxrs;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.jaxrs.services.StatisticsService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONServices.
 */
@Path("/json")
public class JSONServices extends Services {
	final Logger logger = LoggerFactory.getLogger(JSONServices.class);
	
	@GET
	@Path("/get-adaptation-rules/{ontologyABox}/{ontologyId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAdaptationRules(@PathParam("ontologyABox") String aBox,
			@PathParam("ontologyId") String ontologyId)
			throws TransformerFactoryConfigurationError, Exception {
		// Write received ontology to file system

		// String ontologyFileName = ontologyId + ".owl";
		// PrintWriter writer = new PrintWriter("src/" + ontologyFileName,
		// "UTF-8");
		// writer.println(ABox);
		// writer.close();

		// generate rules
		AdaptationRuleList adaptationRuleList = RuleGeneratorService
				.generateAdaptationRules(aBox, ontologyId);

		String xml;
		StringWriter stringWriter = new StringWriter();
		try {
			JAXBContext context = JAXBContext
					.newInstance(AdaptationRuleList.class);
			Marshaller carMarshaller = context.createMarshaller();
			carMarshaller.marshal(adaptationRuleList, stringWriter);
			xml = stringWriter.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

		String xslt = new Scanner(new File("resources/noolsJSON.xslt"))
				.useDelimiter("\\Z").next();

		StringWriter xmlResultResource = new StringWriter();

		Transformer xmlTransformer = TransformerFactory.newInstance()
				.newTransformer(new StreamSource(new StringReader(xslt)));

		xmlTransformer.transform(new StreamSource(new StringReader(xml)),
				new StreamResult(xmlResultResource));
		
		return xmlResultResource.getBuffer().toString();
	}

	@POST
	@Path("/get-statistics")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public String getStatistics(@FormParam("ontologyABox") String aBox,
			@FormParam("ontologyId") String ontologyId) throws Exception {
		logger.debug("foo {}", 1);
		logger.info("bar");
		try {
			return StatisticsService.generateStatistics(aBox, ontologyId);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
}
