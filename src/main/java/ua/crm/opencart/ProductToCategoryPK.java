package ua.crm.opencart;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oc_product_to_category database table.
 * 
 */
@Embeddable
public class ProductToCategoryPK implements Serializable{
	private static final long serialVersionUID = 1L;


	@Column(name="product_id")
	private int productId;

	@Column(name="category_id")
	private int categoryId;

	public ProductToCategoryPK() {
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductToCategoryPK)) {
			return false;
		}
		ProductToCategoryPK castOther = (ProductToCategoryPK)other;
		return 
			(this.productId == castOther.productId)
			&& (this.categoryId == castOther.categoryId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productId;
		hash = hash * prime + this.categoryId;
		
		return hash;
	}
}