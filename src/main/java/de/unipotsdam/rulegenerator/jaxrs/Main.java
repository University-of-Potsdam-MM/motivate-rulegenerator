package de.unipotsdam.rulegenerator.jaxrs;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * Gets the port.
	 *
	 * @param defaultPort the default port
	 * @return the port
	 */
	private static int getPort(int defaultPort) {
		// grab port from environment, otherwise fall back to default port 9998
		String httpPort = System.getProperty("jersey.test.port");
		if (null != httpPort) {
			try {
				return Integer.parseInt(httpPort);
			} catch (NumberFormatException e) {
			}
		}
		return defaultPort;
	}

	/**
	 * Gets the base uri.
	 *
	 * @return the base uri
	 */
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost/").port(getPort(9998))
				.build();
	}

	/** The Constant BASE_URI. */
	public static final URI BASE_URI = getBaseURI();

	/**
	 * Start server.
	 *
	 * @return the http server
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected static HttpServer startServer() throws IOException {
		ResourceConfig resourceConfig = new PackagesResourceConfig(
				"de.unipotsdam.rulegenerator");

		// Add AuthFilter ////////////
		resourceConfig.getProperties().put(
				"com.sun.jersey.spi.container.ContainerRequestFilters",
				"de.unipotsdam.rulegenerator.jaxrs.AuthenticationFilter");

		System.out.println("Starting grizzly2...");

		// SSLContextConfigurator sslCon = new SSLContextConfigurator();

		// return GrizzlyServerFactory.createHttpServer(BASE_URI,
		// ContainerFactory
		// .createContainer(HttpHandler.class, resourceConfig), true,
		// new SSLEngineConfigurator(sslCon));

		return GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		// Grizzly 2 initialization
		HttpServer httpServer = startServer();
		System.out.println(String.format(
				"Jersey app started with WADL available at "
						+ "%sapplication.wadl\nHit enter to stop it...",
				BASE_URI));
		System.in.read();
		httpServer.stop();
	}
}
