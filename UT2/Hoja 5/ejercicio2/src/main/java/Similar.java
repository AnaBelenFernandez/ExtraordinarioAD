
package com.ana.ejercicio2;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Similar {

    @SerializedName("similarartists")
    @Expose
    private Similarartists similarartists;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Similar() {
    }

    /**
     * 
     * @param similarartists
     */
    public Similar(Similarartists similarartists) {
        super();
        this.similarartists = similarartists;
    }

    public Similarartists getSimilarartists() {
        return similarartists;
    }

    public void setSimilarartists(Similarartists similarartists) {
        this.similarartists = similarartists;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Similar.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("similarartists");
        sb.append('=');
        sb.append(((this.similarartists == null)?"<null>":this.similarartists));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
