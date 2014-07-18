package de.unipotsdam.rulegenerator.jaxrs.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.unipotsdam.rulegenerator.objects.ContextInformation;
import de.unipotsdam.rulegenerator.objects.ContextInformationList;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextInformation.
 */
public class ContextInformationService {

	private static ContextInformationList loadContextInformations()
			throws JsonParseException, JsonMappingException, IOException {
		ContextInformationList informations = new ContextInformationList();

		ObjectMapper mapper = new ObjectMapper();
		// informations = mapper.readValue(ContextInformationService.class
		// .getResourceAsStream("/ContextInformation.json"),
		// ContextInformationList.class);
		informations = mapper.readValue(new File(
				"resources/ContextInformation.json"),
				ContextInformationList.class);

		return informations;
	}

	/**
	 * Gets the context informations.
	 * 
	 * @return the context informations
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static ContextInformationList getContextInformation()
			throws JsonParseException, JsonMappingException, IOException {
		return ContextInformationService.loadContextInformations();
	}

	public static ContextInformation getContextInformation(String id)
			throws JsonParseException, JsonMappingException, IOException {
		ContextInformationList contextInformationList = ContextInformationService
				.loadContextInformations();
		return contextInformationList.getContextInformation(id);
	}
}
