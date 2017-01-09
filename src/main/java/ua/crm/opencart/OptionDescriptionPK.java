package ua.crm.opencart;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the oc_option_description database table.
 * 
 */
@Embeddable
public class OptionDescriptionPK implements Serializable{
	private static final long serialVersionUID = 1L;


	@Column(name="option_id")
	private int optionId;

	@Column(name="language_id")
	private int languageId;

	public OptionDescriptionPK() {
	}
	public int getOptionId() {
		return this.optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
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
		if (!(other instanceof OptionDescriptionPK)) {
			return false;
		}
		OptionDescriptionPK castOther = (OptionDescriptionPK)other;
		return 
			(this.optionId == castOther.optionId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.optionId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}