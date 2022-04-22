
package com.ana.ejercicio2.clasesJson;

import com.ana.ejercicio2.clasesJson.Topartists;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ObjetoPrincipal {

    @SerializedName("topartists")
    @Expose
    private Topartists topartists;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ObjetoPrincipal() {
    }

    /**
     * 
     * @param topartists
     */
    public ObjetoPrincipal(Topartists topartists) {
        super();
        this.topartists = topartists;
    }

    public Topartists getTopartists() {
        return topartists;
    }

    public void setTopartists(Topartists topartists) {
        this.topartists = topartists;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ObjetoPrincipal.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("topartists");
        sb.append('=');
        sb.append(((this.topartists == null)?"<null>":this.topartists));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
