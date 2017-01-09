package ua.crm.opencart;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the oc_category_description database table.
 */
@Entity
@Table(name = "crm_category_description")

public class CategoryDescription implements Serializable {
    private static final long serialVersionUID = 1L;


    @EmbeddedId
    private CategoryDescriptionPK id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private Language language;



    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "meta_description")
    private String metaDescription;

    @Column(name = "meta_keyword")
    private String metaKeyword;

    private String name;

    @Column(name = "seo_h1")
    private String seoH1;

    @Column(name = "seo_title")
    private String seoTitle;

    public CategoryDescription() {
    }

    public CategoryDescriptionPK getId() {
        return this.id;
    }

    public void setId(CategoryDescriptionPK id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaDescription() {
        return this.metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeyword() {
        return this.metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoH1() {
        return this.seoH1;
    }

    public void setSeoH1(String seoH1) {
        this.seoH1 = seoH1;
    }

    public String getSeoTitle() {
        return this.seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}