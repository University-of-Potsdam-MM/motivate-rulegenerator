package de.unipotsdam.rulegenerator.jaxrs;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:9998/";
    
	/**
	 * Start server.
	 *
	 * @return the http server
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
    	final ResourceConfig resourceConfig = new ResourceConfig().packages("de.unipotsdam.rulegenerator.jaxrs");

    	//FIXME: AuthFilter an Jersey 2.13 anpassen
		// Add AuthFilter ////////////
		//resourceConfig.getProperties().put(
		//		"com.sun.jersey.spi.container.ContainerRequestFilters",
		//		"de.unipotsdam.rulegenerator.jaxrs.AuthenticationFilter");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdownNow();
	}
}
