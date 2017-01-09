package ua.crm.opencart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the oc_option database table.
 * 
 */
@Entity
@Table(name="crm_option")

public class Option implements Serializable{
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name="option_id")
	private int optionId;

	@Column(name="sort_order")
	private int sortOrder;

	private String type;

	public Option() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}