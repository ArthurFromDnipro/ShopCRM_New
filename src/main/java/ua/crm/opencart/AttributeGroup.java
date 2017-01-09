package ua.crm.opencart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the oc_attribute_group database table.
 * 
 */
@Entity
@Table(name="crm_attribute_group")

public class AttributeGroup implements Serializable{
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name="attribute_group_id")
	private int attributeGroupId;

	@Column(name="sort_order")
	private int sortOrder;

	public AttributeGroup() {
	}

	public int getAttributeGroupId() {
		return this.attributeGroupId;
	}

	public void setAttributeGroupId(int attributeGroupId) {
		this.attributeGroupId = attributeGroupId;
	}

	public int getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}