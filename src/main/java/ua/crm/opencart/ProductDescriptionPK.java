package ua.crm.opencart;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oc_product_description database table.
 * 
 */
@Embeddable
public class ProductDescriptionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="product_id")
	private int productId;

	@Column(name="language_id")
	private int languageId;

	public ProductDescriptionPK() {
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
		if (!(other instanceof ProductDescriptionPK)) {
			return false;
		}
		ProductDescriptionPK castOther = (ProductDescriptionPK)other;
		return 
			(this.productId == castOther.productId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}