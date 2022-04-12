
package com.ana.ejercicio2;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Topartists {

    @SerializedName("artist")
    @Expose
    private List<Artistjtp> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr__1 attr;

    public List<Artistjtp> getArtist() {
        return artist;
    }

    public void setArtist(List<Artistjtp> artist) {
        this.artist = artist;
    }

    public Attr__1 getAttr() {
        return attr;
    }

    public void setAttr(Attr__1 attr) {
        this.attr = attr;
    }

}
