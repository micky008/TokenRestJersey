package com.msc.rest.tokenrestjersey;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * Toutes les classe Controller de Jersey doivent étendre cette classe.
 *
 * @author Micky
 */
public class TokenController {

    @Context
    SecurityContext securityContext;

    protected Integer getIdPersonneConnecter(SecurityContext sc) {
        return Integer.parseInt(sc.getUserPrincipal().getName());
    }

}
