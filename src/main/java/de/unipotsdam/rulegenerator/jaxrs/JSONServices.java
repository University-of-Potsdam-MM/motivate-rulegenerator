package de.unipotsdam.rulegenerator.jaxrs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.unipotsdam.rulegenerator.jaxrs.services.ContextInformationService;
import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.objects.AdaptationRuleList;
import de.unipotsdam.rulegenerator.objects.ContextInformation;
import de.unipotsdam.rulegenerator.objects.ContextInformationList;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONServices.
 */
@Path("/json")
public class JSONServices extends Services {

	/**
	 * Context information json.
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
	@Produces(MediaType.APPLICATION_JSON)
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
	@Produces(MediaType.APPLICATION_JSON)
	public ContextInformation getContextInformation(@PathParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		return ContextInformationService.getContextInformation(id);
	}

	@GET
	@Path("/generate-adaptation-rules")
	@Produces(MediaType.TEXT_PLAIN)
	public String generateAdaptationRules()
			throws TransformerFactoryConfigurationError, TransformerException,
			FileNotFoundException {
		AdaptationRuleList adaptationRuleList = RuleGeneratorService
				.generateAdaptationRules();

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
}
