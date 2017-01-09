package ua.crm.opencart;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the oc_attribute_group_description database table.
 * 
 */
@Entity
@Table(name="crm_attribute_group_description")

public class AttributeGroupDescription implements Serializable{
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private AttributeGroupDescriptionPK id;

	private String name;

	public AttributeGroupDescription() {
	}

	public AttributeGroupDescriptionPK getId() {
		return this.id;
	}

	public void setId(AttributeGroupDescriptionPK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}