package ua.crm.opencart;



import javax.persistence.*;


/**
 * The persistent class for the oc_product_to_category database table.
 * 
 */
@Entity
@Table(name="crm_product_to_category")

public class ProductToCategory {


	@EmbeddedId
	private ProductToCategoryPK id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;


	@Column(name="main_category")
	private boolean mainCategory;

	public ProductToCategory() {
	}

	public ProductToCategoryPK getId() {
		return this.id;
	}

	public void setId(ProductToCategoryPK id) {
		this.id = id;
	}

	public boolean isMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(boolean mainCategory) {
		this.mainCategory = mainCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}