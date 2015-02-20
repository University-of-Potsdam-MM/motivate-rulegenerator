package de.unipotsdam.rulegenerator.jaxrs;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/owl")
public class OWLServices extends Services {
	@GET
	@Path("/get-knowledge-ontology")
	@Produces(MediaType.TEXT_XML)
	public String getKnowledgeOntology() throws IOException {
		File file = new File("knowledge.owl");
		
		byte[] encoded = Files.readAllBytes(file.toPath());
		return new String(encoded, StandardCharsets.UTF_8);
	}
}