package com.msc.rest.tokenrestjersey.helper;

import com.msc.rest.tokenrestjersey.TokenEntity;

/**
 *
 * @author micky
 */
public class Helper<T> extends TokenEntity {

    private T obj;

    /**
     * @return the bool
     */
    public T getObject() {
        return obj;
    }

    public void setObject(T obj) {
        this.obj = obj;
    }

}
