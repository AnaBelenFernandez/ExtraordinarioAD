
package com.ana.ejercicio2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ana.ejercicio2.Artist;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Topartists {

    @SerializedName("artist")
    @Expose
    private List<Artist> artist = null;
    @SerializedName("@attr")
    @Expose
    private Attr__1 attr;

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

}
