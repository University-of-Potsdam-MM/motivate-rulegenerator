package de.unipotsdam.rulegenerator.jaxrs.services;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.unipotsdam.rulegenerator.objects.ContextInformationList;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextInformation.
 */
public class ContextInformationService {

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
	public static ContextInformationList getContextInformations()
			throws JsonParseException, JsonMappingException, IOException {
		ContextInformationList informations = new ContextInformationList();

		ObjectMapper mapper = new ObjectMapper();
		informations = mapper.readValue(ContextInformationService.class.getResourceAsStream("/ContextInformation.json"),
				ContextInformationList.class);

		return informations;
	}
}
