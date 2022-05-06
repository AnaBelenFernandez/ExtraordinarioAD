
package pojos;

import es.ana.pokemon.*;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Ability {

    @SerializedName("ability")
    @Expose
    private Ability__1 ability;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("slot")
    @Expose
    private Integer slot;

    public Ability__1 getAbility() {
        return ability;
    }

    public void setAbility(Ability__1 ability) {
        this.ability = ability;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    @Override
    public String toString()
    {
        return "Ability{" + "ability=" + ability + ", isHidden=" + isHidden + ", slot=" + slot + '}' +'\n';
    }

}
