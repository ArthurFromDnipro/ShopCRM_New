package ua.crm.opencart;

import javax.persistence.*;


/**
 * The persistent class for the oc_product_option database table.
 * 
 */
@Entity
@Table(name="crm_product_option")

public class ProductOption {


	@Id
	@Column(name="product_option_id")
	private int productOptionId;

	@Column(name="option_id")
	private int optionId;


	@Column(name="option_value",columnDefinition = "TEXT")
	private String optionValue;

	@Column(name="product_id")
	private int productId;

	private boolean required;

	public ProductOption() {
	}

	public int getProductOptionId() {
		return this.productOptionId;
	}

	public void setProductOptionId(int productOptionId) {
		this.productOptionId = productOptionId;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOptionValue() {
		return this.optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}