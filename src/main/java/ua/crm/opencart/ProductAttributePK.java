package ua.crm.opencart;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oc_product_attribute database table.
 * 
 */
@Embeddable
public class ProductAttributePK implements Serializable{
	private static final long serialVersionUID = 1L;


	@Column(name="product_id")
	private int productId;

	@Column(name="attribute_id")
	private int attributeId;

	@Column(name="language_id")
	private int languageId;

	public ProductAttributePK() {
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAttributeId() {
		return this.attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
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
		if (!(other instanceof ProductAttributePK)) {
			return false;
		}
		ProductAttributePK castOther = (ProductAttributePK)other;
		return 
			(this.productId == castOther.productId)
			&& (this.attributeId == castOther.attributeId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productId;
		hash = hash * prime + this.attributeId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}