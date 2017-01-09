package ua.crm.opencart;

import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oc_category database table.
 */
@Entity
@Table(name = "crm_category")

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    private int column;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    private Date dateAdded;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    private Date dateModified;

    private String image;

//    @Column(name = "parent_id")
//    private int parentId;


//    @Convert(converter = CategoryParentConvertor.class,
//            attributeName = "parent_id")

    @ManyToOne
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "parent_id")
    @JoinFormula(value = "CASE parent_id WHEN 0 THEN NULL ELSE parent_id END")
    private Category parent;

//    @OneToMany(mappedBy = "parent")
//    private List<Category> childCategory = new ArrayList<>();


    @Column(name = "sort_order")
    private int sortOrder;

    private boolean status;

    private boolean top;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryDescription> categoryDescriptions = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.REFRESH)
    private List<ProductToCategory> productToCategory = new ArrayList<>();


    public Category() {
    }

    public CategoryDescription getCategoryDescriptionUA() {
        final CategoryDescription[] pD = {new CategoryDescription()};

        categoryDescriptions.forEach(n -> {
            if (n.getLanguage().getLanguageId() == 3) {
                pD[0] = n;
            }
        });

        return pD[0];


    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Date getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

//    public List<Category> getChildCategory() {
//        return childCategory;
//    }
//
//    public void setChildCategory(List<Category> childCategory) {
//        this.childCategory = childCategory;
//    }

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

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public List<CategoryDescription> getCategoryDescriptions() {
        return categoryDescriptions;
    }

    public void setCategoryDescriptions(List<CategoryDescription> categoryDescriptions) {
        this.categoryDescriptions = categoryDescriptions;
    }

    public List<ProductToCategory> getProductToCategory() {
        return productToCategory;
    }

    public void setProductToCategory(List<ProductToCategory> productToCategory) {
        this.productToCategory = productToCategory;
    }
}