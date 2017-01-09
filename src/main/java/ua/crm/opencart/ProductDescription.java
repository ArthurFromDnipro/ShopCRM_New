package ua.crm.opencart;

import javax.persistence.*;


/**
 * The persistent class for the oc_product_description database table.
 */
@Entity
@Table(name = "crm_product_description")

public class ProductDescription {


    @EmbeddedId
    private ProductDescriptionPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
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

    @Column(name = "tag", columnDefinition = "TEXT")
    private String tag;

    public ProductDescription() {
    }

    public ProductDescriptionPK getId() {
        return this.id;
    }

    public void setId(ProductDescriptionPK id) {
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

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}