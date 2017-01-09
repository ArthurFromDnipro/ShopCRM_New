package ua.crm.opencart;

import javax.persistence.*;


/**
 * The persistent class for the oc_product_image database table.
 * 
 */
@Entity
@Table(name="crm_product_image")

public class ProductImage {


	@Id
	@Column(name="product_image_id")
	private int productImageId;

	private String image;

	@Column(name="product_id")
	private int productId;

	@Column(name="sort_order")
	private int sortOrder;

	public ProductImage() {
	}

	public int getProductImageId() {
		return this.productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}