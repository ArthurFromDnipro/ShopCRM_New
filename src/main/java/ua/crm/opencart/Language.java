package ua.crm.opencart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the oc_language database table.
 */
@Entity
@Table(name = "crm_language")

public class Language implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "language_id")
    private int languageId;

    private String code;

    private String directory;

    private String filename;

    private String image;

    private String locale;

    private String name;

    @Column(name = "sort_order")
    private int sortOrder;

    private boolean status;

    @OneToMany(mappedBy = "language", cascade = CascadeType.REFRESH)
    private List<CategoryDescription> categoryDescriptions = new ArrayList<>();

    @OneToMany(mappedBy = "language", cascade = CascadeType.REFRESH)
    private List<ProductDescription> productDescriptions = new ArrayList<>();


    public Language() {
    }

    public int getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDirectory() {
        return this.directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<CategoryDescription> getCategoryDescriptions() {
        return categoryDescriptions;
    }

    public void setCategoryDescriptions(List<CategoryDescription> categoryDescriptions) {
        this.categoryDescriptions = categoryDescriptions;
    }

    public List<ProductDescription> getProductDescriptions() {
        return productDescriptions;
    }

    public void setProductDescriptions(List<ProductDescription> productDescriptions) {
        this.productDescriptions = productDescriptions;
    }
}