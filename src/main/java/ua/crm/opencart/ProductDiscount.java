package ua.crm.opencart;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the oc_product_discount database table.
 * 
 */
@Entity
@Table(name="crm_product_discount")

public class ProductDiscount {


	@Id
	@Column(name="product_discount_id")
	private int productDiscountId;

	@Column(name="customer_group_id")
	private int customerGroupId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_end")
	private Date dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private Date dateStart;

	private BigDecimal price;

	private int priority;

	@Column(name="product_id")
	private int productId;

	private int quantity;

	public ProductDiscount() {
	}

	public int getProductDiscountId() {
		return this.productDiscountId;
	}

	public void setProductDiscountId(int productDiscountId) {
		this.productDiscountId = productDiscountId;
	}

	public int getCustomerGroupId() {
		return this.customerGroupId;
	}

	public void setCustomerGroupId(int customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}