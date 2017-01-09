package ua.crm.opencart;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the oc_option_description database table.
 * 
 */
@Entity
@Table(name="crm_option_description")

public class OptionDescription implements Serializable{
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private OptionDescriptionPK id;

	private String name;

	public OptionDescription() {
	}

	public OptionDescriptionPK getId() {
		return this.id;
	}

	public void setId(OptionDescriptionPK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}