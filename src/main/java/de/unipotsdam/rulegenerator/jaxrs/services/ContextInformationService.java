package de.unipotsdam.rulegenerator.jaxrs.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextInformationService.
 */
public class ContextInformationService extends Service {
	
	/**
	 * Gets the context information.
	 *
	 * @return the context information
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String getContextInformation() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get("resources/measurable-context-information.xml"));
		return new String(encoded, StandardCharsets.UTF_8);
	}
}
