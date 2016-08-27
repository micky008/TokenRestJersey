package com.msc.rest.tokenrestjersey;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Micky
 */
public class TokenSecurityContext implements SecurityContext {

    private String idUserConnected;

    @Override
    public Principal getUserPrincipal() {
        return new Principal() {

            @Override
            public String getName() {
                return idUserConnected;
            }
        };
    }

    @Override
    public boolean isUserInRole(String role) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }

    public void setIdUserConnected(String idConnected) {
        this.idUserConnected = idConnected;
    }

}
