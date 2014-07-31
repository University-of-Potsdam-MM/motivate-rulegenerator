package de.unipotsdam.rulegenerator.jaxrs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;

@Path("/dsl")
public class DSLServices extends Services implements ErrorListener,
		ErrorHandler {

	@GET
	@Path("/get-adaptation-rules/{ontologyABox}/{ontologyId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAdaptationRules(@PathParam("ontologyABox") String ABox,
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

		System.setProperty("javax.xml.transform.TransformerFactory",
				"net.sf.saxon.TransformerFactoryImpl");

		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		parser.getXMLReader().setErrorHandler(this);
		SAXSource xmlInput = new SAXSource(parser.getXMLReader(),
				new InputSource(new StringReader(xml)));

		stringWriter = new StringWriter();
		StreamResult xmlOutput = new StreamResult(stringWriter);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();

		StreamSource source = new StreamSource(new StringReader(xslt));
		// source.setSystemId("resources/noolsDSL.xslt");
		Transformer transformer = transformerFactory.newTransformer(source);
		transformer.setErrorListener(this);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(xmlInput, xmlOutput);
		
		OutputStreamWriter outputWriter = new OutputStreamWriter(new FileOutputStream("resources/noolsDSLOutput.nools"), "UTF-8");
		outputWriter.write(xmlOutput.getWriter().toString());
		outputWriter.close();
		
		return xmlOutput.getWriter().toString();
	}

	@Override
	public void error(TransformerException arg0) throws TransformerException {
		// TODO Auto-generated method stub

	}

	@Override
	public void fatalError(TransformerException arg0)
			throws TransformerException {
		// TODO Auto-generated method stub

	}

	@Override
	public void warning(TransformerException arg0) throws TransformerException {
		// TODO Auto-generated method stub

	}

	@Override
	public void error(SAXParseException arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void fatalError(SAXParseException arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	@Override
	public void warning(SAXParseException arg0) throws SAXException {
		// TODO Auto-generated method stub

	}
}
