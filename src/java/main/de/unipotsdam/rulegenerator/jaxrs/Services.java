package de.unipotsdam.rulegenerator.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;

public class Services {
	protected PelletReasoner reasoner;
	protected OWLDataFactory dataFactory;
	protected OWLOntologyManager manager;
	protected OWLOntology ontology;	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String defaultResponse() {
		return "Use the provided application.wadl to get a list of all available interfaces.";
	}
}
