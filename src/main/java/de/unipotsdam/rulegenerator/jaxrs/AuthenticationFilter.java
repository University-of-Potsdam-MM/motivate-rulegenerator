package de.unipotsdam.rulegenerator.jaxrs;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticationFilter.
 */
public class AuthenticationFilter implements ContainerRequestFilter {

	// Exception thrown if user is unauthorized.
	/** The Constant unauthorized. */
	private final static WebApplicationException unauthorized = new WebApplicationException(
			Response.status(Status.UNAUTHORIZED)
					.header(HttpHeaders.WWW_AUTHENTICATE,
							"Basic realm=\"realm\"")
					.entity("Page requires login.").build());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sun.jersey.spi.container.ContainerRequestFilter#filter(com.sun.jersey
	 * .spi.container.ContainerRequest)
	 */
	@Override
	public ContainerRequest filter(ContainerRequest containerRequest)
			throws WebApplicationException {

		// Automatically allow certain requests.
		String method = containerRequest.getMethod();
		String path = containerRequest.getPath(true);
		if (method.equals("GET") && (path.equals("application.wadl")
				|| path.equals("owl/get-knowledge-ontology")))
			return containerRequest;

		// Get the authentication passed in HTTP headers parameters
		String auth = containerRequest.getHeaderValue("authorization");
		if (auth == null)
			throw unauthorized;

		auth = auth.replaceFirst("[Bb]asic ", "");
		String userColonPass = new String(Base64.decodeBase64(auth));

		if (!userColonPass.equals("admin:8SPAp3uMInbBjBDr"))
			throw unauthorized;

		return containerRequest;
	}
}