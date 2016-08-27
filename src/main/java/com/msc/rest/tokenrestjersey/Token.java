package com.msc.rest.tokenrestjersey;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe representant le token. le param timeMax c'est la valeur au
 * System.currentTimeMillis() + (30 minutes).
 *
 * @author Micky
 */
//http://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
public class Token implements Serializable {

    private String token;
    private long timeMax;

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the timeMax
     */
    public long getTimeMax() {
        return timeMax;
    }

    /**
     * @param timeMax the timeMax to set
     */
    public void setTimeMax(long timeMax) {
        this.timeMax = timeMax;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.token);
        hash = 67 * hash + (int) (this.timeMax ^ (this.timeMax >>> 32));
        return hash;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Token)) {
            return false;
        }
        return token.equals(((Token) o).getToken());
    }

}
