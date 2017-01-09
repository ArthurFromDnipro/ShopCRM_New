package ua.crm.opencart;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oc_category_description database table.
 */
@Embeddable
public class CategoryDescriptionPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "category_id")
    private int categoryId;



    @Column(name = "language_id")
    private int languageId;




    public CategoryDescriptionPK() {
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryDescriptionPK)) {
            return false;
        }
        CategoryDescriptionPK castOther = (CategoryDescriptionPK) other;
        return
                (this.categoryId == castOther.categoryId)
                        && (this.languageId == castOther.languageId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.categoryId;
        hash = hash * prime + this.languageId;

        return hash;
    }
}