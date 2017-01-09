package ua.crm.opencart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the oc_currency database table.
 * 
 */
@Entity
@Table(name="crm_currency")

public class Currency implements Serializable{
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name="currency_id")
	private int currencyId;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_modified")
	private Date dateModified;

	@Column(name="decimal_place")
	private char decimalPlace;

	private boolean status;

	@Column(name="symbol_left")
	private String symbolLeft;

	@Column(name="symbol_right")
	private String symbolRight;

	private String title;

	private float value;

	public Currency() {
	}

	public int getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}


	public char getDecimalPlace() {
		return decimalPlace;
	}

	public void setDecimalPlace(char decimalPlace) {
		this.decimalPlace = decimalPlace;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSymbolLeft() {
		return this.symbolLeft;
	}

	public void setSymbolLeft(String symbolLeft) {
		this.symbolLeft = symbolLeft;
	}

	public String getSymbolRight() {
		return this.symbolRight;
	}

	public void setSymbolRight(String symbolRight) {
		this.symbolRight = symbolRight;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}