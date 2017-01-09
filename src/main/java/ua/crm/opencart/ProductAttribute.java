package ua.crm.opencart;

import javax.persistence.*;


/**
 * The persistent class for the oc_product_attribute database table.
 * 
 */
@Entity
@Table(name="crm_product_attribute")

public class ProductAttribute {


	@EmbeddedId
	private ProductAttributePK id;

	@Column(name = "text",columnDefinition = "TEXT")
	private String text;

	public ProductAttribute() {
	}

	public ProductAttributePK getId() {
		return this.id;
	}

	public void setId(ProductAttributePK id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}