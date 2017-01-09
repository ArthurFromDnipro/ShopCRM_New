package ua.crm.opencart;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oc_attribute_group_description database table.
 * 
 */
@Embeddable
public class AttributeGroupDescriptionPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="attribute_group_id")
	private int attributeGroupId;

	@Column(name="language_id")
	private int languageId;

	public AttributeGroupDescriptionPK() {
	}
	public int getAttributeGroupId() {
		return this.attributeGroupId;
	}
	public void setAttributeGroupId(int attributeGroupId) {
		this.attributeGroupId = attributeGroupId;
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
		if (!(other instanceof AttributeGroupDescriptionPK)) {
			return false;
		}
		AttributeGroupDescriptionPK castOther = (AttributeGroupDescriptionPK)other;
		return 
			(this.attributeGroupId == castOther.attributeGroupId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.attributeGroupId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}