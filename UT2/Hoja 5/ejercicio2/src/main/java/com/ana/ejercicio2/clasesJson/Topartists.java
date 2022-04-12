
package com.ana.ejercicio2.clasesJson;

import com.ana.ejercicio2.*;
import com.ana.ejercicio2.clasesJson.Attr__1;
import com.ana.ejercicio2.clasesJson.Artist;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Topartists {

    @SerializedName("artist")
    @Expose
    private List<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr__1 attr;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Topartists() {
    }

    /**
     * 
     * @param artist
     * @param attr
     */
    public Topartists(List<Artist> artist, Attr__1 attr) {
        super();
        this.artist = artist;
        this.attr = attr;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Attr__1 getAttr() {
        return attr;
    }

    public void setAttr(Attr__1 attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Topartists.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("artist");
        sb.append('=');
        sb.append(((this.artist == null)?"<null>":this.artist));
        sb.append(',');
        sb.append("attr");
        sb.append('=');
        sb.append(((this.attr == null)?"<null>":this.attr));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
