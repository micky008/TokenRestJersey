package com.msc.rest.tokenrestjersey.helper;

import com.msc.rest.tokenrestjersey.TokenEntity;
import java.util.List;

/**
 *
 * @author Micky
 */
public class ListHelper<T> extends TokenEntity {

    private List<T> list;

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }
}
