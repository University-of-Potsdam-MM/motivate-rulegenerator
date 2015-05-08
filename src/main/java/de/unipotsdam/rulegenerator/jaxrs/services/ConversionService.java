package de.unipotsdam.rulegenerator.jaxrs.services;

import no.s11.owlapijsonld.JsonLdOntologyFormat;
import no.s11.owlapijsonld.JsonLdParserFactory;
import no.s11.owlapijsonld.JsonLdStorer;
import org.coode.owlapi.turtle.TurtleOntologyFormat;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.io.RDFXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ConversionService extends Service {

	/**
	 *
	 * @param aBox
	 * @return
	 * @throws Exception
	 */
	public static String convertOWLXMLToJSONLD(String aBox) throws Exception {
		loadOntology(aBox);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		JsonLdStorer.register(manager);
		manager.saveOntology(ontology, new JsonLdOntologyFormat(), baos);

		return baos.toString(String.valueOf(StandardCharsets.UTF_8));
	}

	/**
	 *
	 * @param jsonld
	 * @return
	 * @throws OWLOntologyCreationException
	 * @throws OWLOntologyStorageException
	 * @throws UnsupportedEncodingException
	 */
	public static String convertJSONLDToOWLXML(String jsonld) throws Exception {
		JsonLdParserFactory.register();
		loadOntology(jsonld);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		manager.saveOntology(ontology, new OWLXMLOntologyFormat(), baos);

		return baos.toString(String.valueOf(StandardCharsets.UTF_8));
	}
}
