package ua.crm.opencart;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the oc_product_option_value database table.
 * 
 */
@Entity
@Table(name="oc_product_option_value")

public class ProductOptionValue {


	@Id
	@Column(name="product_option_value_id")
	private int productOptionValueId;

	@Column(name="option_id")
	private int optionId;

	@Column(name="option_value_id")
	private int optionValueId;

	private int points;

	@Column(name="points_prefix")
	private String pointsPrefix;

	private BigDecimal price;

	@Column(name="price_prefix")
	private String pricePrefix;

	@Column(name="product_id")
	private int productId;

	@Column(name="product_option_id")
	private int productOptionId;

	private int quantity;

	private boolean subtract;

	private BigDecimal weight;

	@Column(name="weight_prefix")
	private String weightPrefix;

	public ProductOptionValue() {
	}

	public int getProductOptionValueId() {
		return this.productOptionValueId;
	}

	public void setProductOptionValueId(int productOptionValueId) {
		this.productOptionValueId = productOptionValueId;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getOptionValueId() {
		return this.optionValueId;
	}

	public void setOptionValueId(int optionValueId) {
		this.optionValueId = optionValueId;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getPointsPrefix() {
		return this.pointsPrefix;
	}

	public void setPointsPrefix(String pointsPrefix) {
		this.pointsPrefix = pointsPrefix;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPricePrefix() {
		return this.pricePrefix;
	}

	public void setPricePrefix(String pricePrefix) {
		this.pricePrefix = pricePrefix;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductOptionId() {
		return this.productOptionId;
	}

	public void setProductOptionId(int productOptionId) {
		this.productOptionId = productOptionId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isSubtract() {
		return subtract;
	}

	public void setSubtract(boolean subtract) {
		this.subtract = subtract;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getWeightPrefix() {
		return this.weightPrefix;
	}

	public void setWeightPrefix(String weightPrefix) {
		this.weightPrefix = weightPrefix;
	}

}