package com.msc.rest.tokenrestjersey;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Classe qui fais le Before. Si une methode @Secure est appeler, cette classe
 * et utilser avant. Ne pas oublier de la déclarer dans les UseerRessourses
 * [dans le Main]
 *
 * @author Micky
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class TokenFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Get the HTTP Authorization header from the request
     
        String debugmode = requestContext.getHeaderString("DEBUGMODE");
        if (debugmode != null) {
            return;
        }
        
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null) {
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        String idUserName = requestContext.getHeaderString(HttpHeaders.ALLOW);

        TokenSecurityContext tsc = new TokenSecurityContext();
        tsc.setIdUserConnected(idUserName);
        requestContext.setSecurityContext(tsc);

        try {

            // Validate the token
            validateToken(idUserName, authorizationHeader);

        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private void validateToken(String userConnecter, String token) throws Exception {
        Token t = new Token();
        t.setToken(token);
        if (!TokenService.isTockenExist(Integer.parseInt(userConnecter), t)) {
            throw new Exception();
        }
    }
}
