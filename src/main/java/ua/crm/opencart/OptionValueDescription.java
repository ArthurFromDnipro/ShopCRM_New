package ua.crm.opencart;

import javax.persistence.*;


/**
 * The persistent class for the oc_option_value_description database table.
 * 
 */
@Entity
@Table(name="crm_option_value_description")

public class OptionValueDescription {


	@EmbeddedId
	private OptionValueDescriptionPK id;

	private String name;

	@Column(name="option_id")
	private int optionId;

	public OptionValueDescription() {
	}

	public OptionValueDescriptionPK getId() {
		return this.id;
	}

	public void setId(OptionValueDescriptionPK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

}