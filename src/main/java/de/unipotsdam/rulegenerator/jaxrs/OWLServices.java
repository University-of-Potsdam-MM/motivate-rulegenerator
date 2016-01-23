package de.unipotsdam.rulegenerator.jaxrs;

import de.unipotsdam.rulegenerator.jaxrs.services.ConversionService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

	@POST
	@Path("/convert-from-json-ld")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_XML)
	public Response convertFromJSONLD(@FormParam("jsonld") String jsonld) {
		try {
			return Response.ok() //200
					.entity(ConversionService.convertJSONLDToOWLXML(jsonld))
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
					.allow("OPTIONS").build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}