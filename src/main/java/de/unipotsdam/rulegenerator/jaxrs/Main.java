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
	public static String host = "localhost";
	public static String port = "9998";

	/**
	 * Start server.
	 *
	 * @return the http server
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
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(getBaseURL()), resourceConfig);
    }

    public static String getBaseURL() {
    	return "http://"+host+":"+port+"/";
    }
    
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		if (args.length > 0) host = args[0];
		if (args.length > 1) port = args[1];
		
		final HttpServer server = startServer();
		System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", getBaseURL()));
        System.in.read();
        server.shutdownNow();
	}
}
