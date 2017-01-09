package ua.crm.opencart;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the oc_attribute_description database table.
 * 
 */
@Entity
@Table(name="crm_attribute_description")

public class AttributeDescription implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AttributeDescriptionPK id;

	private String name;

	public AttributeDescription() {
	}

	public AttributeDescriptionPK getId() {
		return this.id;
	}

	public void setId(AttributeDescriptionPK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}