package de.unipotsdam.rulegenerator.jaxrs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.objects.AdaptationRuleList;

@Path("/dsl")
public class DSLServices extends Services {

	@GET
	@Path("/get-adaptation-rules")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAdaptationRules()
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

		String xslt = new Scanner(new File("resources/noolsDSL.xslt"))
				.useDelimiter("\\Z").next();

		StringWriter xmlResultResource = new StringWriter();

		Transformer xmlTransformer = TransformerFactory.newInstance()
				.newTransformer(new StreamSource(new StringReader(xslt)));

		xmlTransformer.transform(new StreamSource(new StringReader(xml)),
				new StreamResult(xmlResultResource));

		// System.out.println(xmlResultResource.getBuffer().toString());

		return xmlResultResource.getBuffer().toString();
	}
}
