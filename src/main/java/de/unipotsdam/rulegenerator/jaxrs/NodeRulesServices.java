package de.unipotsdam.rulegenerator.jaxrs;

import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Scanner;

@Path("/noderules")
public class NodeRulesServices extends Services implements ErrorListener,
        ErrorHandler {
    @POST
    @Path("/get-adaptation-rules")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAdaptationRules(@FormParam("ontologyABox") String aBox, @FormParam("ontologyId") String ontologyId) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        // generate rules
        AdaptationRuleList adaptationRuleList;
        try {
            adaptationRuleList = RuleGeneratorService.generateAdaptationRules(
                    aBox, ontologyId);
        } catch (Exception e) {
            return e.getClass() + " " + e.getMessage() + "\n\n"
                    + this.stackTraceToString(e);
        }

        String xml = RuleGeneratorService.XMLFromAdaptationRules(adaptationRuleList);

        String xslt = new Scanner(new File("./resources/nodeRules.xsl"))
                .useDelimiter("\\Z").next();

        System.setProperty("javax.xml.transform.TransformerFactory",
                "net.sf.saxon.TransformerFactoryImpl");

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        parser.getXMLReader().setErrorHandler(this);
        SAXSource xmlInput = new SAXSource(parser.getXMLReader(),
                new InputSource(new StringReader(xml)));

        StringWriter stringWriter = new StringWriter();
        StreamResult xmlOutput = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();

        StreamSource source = new StreamSource(new StringReader(xslt));
        Transformer transformer = transformerFactory.newTransformer(source);
        transformer.setErrorListener(this);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.transform(xmlInput, xmlOutput);

        OutputStreamWriter outputWriter = new OutputStreamWriter(
                new FileOutputStream("./resources/noolsDSLOutput.nools"),
                "UTF-8");
        outputWriter.write(xmlOutput.getWriter().toString());
        outputWriter.close();

        return xmlOutput.getWriter().toString();
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {

    }

    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }

    @Override
    public void warning(TransformerException exception) throws TransformerException {

    }

    @Override
    public void error(TransformerException exception) throws TransformerException {

    }

    @Override
    public void fatalError(TransformerException exception) throws TransformerException {

    }
}