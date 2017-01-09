package ua.crm.opencart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the oc_option_value database table.
 * 
 */
@Entity
@Table(name="crm_option_value")

public class OptionValue implements Serializable{
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name="option_value_id")
	private int optionValueId;

	private String image;

	@Column(name="option_id")
	private int optionId;

	@Column(name="sort_order")
	private int sortOrder;

	public OptionValue() {
	}

	public int getOptionValueId() {
		return this.optionValueId;
	}

	public void setOptionValueId(int optionValueId) {
		this.optionValueId = optionValueId;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}