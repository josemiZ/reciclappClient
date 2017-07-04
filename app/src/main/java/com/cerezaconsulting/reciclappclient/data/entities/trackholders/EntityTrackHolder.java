package com.cerezaconsulting.reciclappclient.data.entities.trackholders;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by miguel on 20/06/17.
 */

public class EntityTrackHolder<T> implements Serializable{
    private ArrayList<T> data;
    private String next_page_url;

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }
}
