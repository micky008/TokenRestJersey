package com.msc.rest.tokenrestjersey;

import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Micky
 */
public class TokenHelper {

    public static Token newToken(Integer idPersonne) {
        TokenService.removeToken(idPersonne);
        return TokenService.getNewToken(idPersonne);
    }

    public static Token newToken(SecurityContext sc) {
        Integer id = Integer.parseInt(sc.getUserPrincipal().getName());
        return newToken(id);
    }
}
