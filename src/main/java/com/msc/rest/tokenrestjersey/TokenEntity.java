package com.msc.rest.tokenrestjersey;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * La classe de referance pour les renvois. dans les classe controlleur qui sont
 * securised, et qui doivent renvoyé un primitif [boolean par exemple] doivent
 * renvoyé TokenEntity. si la methode doit renvoyer une List<Personne> il faut
 * set le Tocken et etendre cette classe.
 *
 * @author Micky
 */
@XmlRootElement(name = "token")
public class TokenEntity {

    private Token token;

    /**
     * @return the token
     */
    public Token getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(Token token) {
        this.token = token;
    }

}
