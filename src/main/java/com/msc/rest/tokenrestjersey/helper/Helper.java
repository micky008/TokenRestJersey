package com.msc.rest.tokenrestjersey.helper;

import com.msc.rest.tokenrestjersey.TokenEntity;

/**
 *
 * @author micky
 * @param <T>
 */
public class Helper<T> extends TokenEntity  {

    private T myObject;

    /**
     * @return the bool
     */
    public T getMyObject() {
        return myObject;
    }

    public void setMyObject(T obj) {
        this.myObject = obj;
    }

  
}
