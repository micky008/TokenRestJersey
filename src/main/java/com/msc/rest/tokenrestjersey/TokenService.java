package com.msc.rest.tokenrestjersey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Micky
 */
public class TokenService {

    public static boolean DEBUG_MODE = false;

    private static final long WAITING = (DEBUG_MODE ? 10000 : 1800000); //10sec ou 30min


    private static volatile Map<Integer, Token> tokens = new HashMap<>();

    public static synchronized Token getNewToken(Integer idPersonne) {
        UUID idOne = UUID.randomUUID();
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder()
                .setSubject(idOne.toString())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        Token t = new Token();
        t.setTimeMax(System.currentTimeMillis() + WAITING);
        t.setToken(compactJws);
        if (TokenService.DEBUG_MODE) {
            System.out.println(idPersonne + " [add]=>  " + t.getToken());
        }
        tokens.put(idPersonne, t);
        return t;
    }

    public static synchronized boolean isTockenExist(Token token) {
        return tokens.containsValue(token);
    }

    public static synchronized void removeToken(Integer idPersonne) {
        tokens.remove(idPersonne);
    }

    public static synchronized Collection<Token> getAllToken() {
        return tokens.values();
    }

    public static synchronized void removeOldToken() {
        Iterator it = tokens.keySet().iterator();
        while (it.hasNext()) {
            Integer login = (Integer) it.next();
            Token t = tokens.get(login);
            if (System.currentTimeMillis() - t.getTimeMax() >= 0) {
                if (TokenService.DEBUG_MODE) {
                    System.out.println(login + " [remove]=>  " + t.getToken());
                }
                t = null;
                it.remove();
            }
        }
    }
}
