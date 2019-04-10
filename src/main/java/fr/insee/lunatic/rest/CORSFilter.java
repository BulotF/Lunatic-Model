package fr.insee.lunatic.rest;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CORSFilter implements ClientResponseFilter {

	static final Logger logger = LoggerFactory.getLogger(CORSFilter.class);

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {

    	logger.debug("Filtering response for CORS support.");

        MultivaluedMap<String, String> headers = responseContext.getHeaders();
 
        headers.add("Access-Control-Allow-Origin", "*");        
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, X-Jersey-Tracing-Accept");
	}
}
