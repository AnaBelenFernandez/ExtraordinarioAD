
package com.ana.ejercicio2.clasesJson;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Artist {

    @SerializedName("streamable")
    @Expose
    private String streamable;
    @SerializedName("image")
    @Expose
    private List<Image> image = null;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("playcount")
    @Expose
    private String playcount;
    @SerializedName("@attr")
    @Expose
    private Attr attr;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param image
     * @param mbid
     * @param streamable
     * @param playcount
     * @param name
     * @param attr
     * @param url
     */
    public Artist(String streamable, List<Image> image, String mbid, String url, String playcount, Attr attr, String name) {
        super();
        this.streamable = streamable;
        this.image = image;
        this.mbid = mbid;
        this.url = url;
        this.playcount = playcount;
        this.attr = attr;
        this.name = name;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
       return "Nombre: "+this.name+" url: "+this.url+" escuchado "+this.playcount+ " veces.";
    }

}
