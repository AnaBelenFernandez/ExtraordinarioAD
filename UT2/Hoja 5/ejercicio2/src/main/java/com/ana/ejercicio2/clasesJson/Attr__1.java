
package com.ana.ejercicio2.clasesJson;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Attr__1 {

    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("totalPages")
    @Expose
    private String totalPages;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("perPage")
    @Expose
    private String perPage;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attr__1() {
    }

    /**
     * 
     * @param total
     * @param perPage
     * @param totalPages
     * @param page
     * @param user
     */
    public Attr__1(String user, String totalPages, String page, String total, String perPage) {
        super();
        this.user = user;
        this.totalPages = totalPages;
        this.page = page;
        this.total = total;
        this.perPage = perPage;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attr__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("totalPages");
        sb.append('=');
        sb.append(((this.totalPages == null)?"<null>":this.totalPages));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
        sb.append(',');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null)?"<null>":this.total));
        sb.append(',');
        sb.append("perPage");
        sb.append('=');
        sb.append(((this.perPage == null)?"<null>":this.perPage));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
