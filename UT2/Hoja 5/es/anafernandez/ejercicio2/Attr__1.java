
package es.anafernandez.ejercicio2;

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

}
