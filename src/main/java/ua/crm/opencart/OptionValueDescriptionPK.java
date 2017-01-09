package ua.crm.opencart;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oc_option_value_description database table.
 * 
 */
@Embeddable
public class OptionValueDescriptionPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="option_value_id")
	private int optionValueId;

	@Column(name="language_id")
	private int languageId;

	public OptionValueDescriptionPK() {
	}
	public int getOptionValueId() {
		return this.optionValueId;
	}
	public void setOptionValueId(int optionValueId) {
		this.optionValueId = optionValueId;
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
		if (!(other instanceof OptionValueDescriptionPK)) {
			return false;
		}
		OptionValueDescriptionPK castOther = (OptionValueDescriptionPK)other;
		return 
			(this.optionValueId == castOther.optionValueId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.optionValueId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}