package ua.crm.opencart;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the oc_product_special database table.
 * 
 */
@Entity
@Table(name="crm_product_special")

public class ProductSpecial {


	@Id
	@Column(name = "product_special_id")
	private int productSpecialId;

	@Column(name = "customer_group_id")
	private int customerGroupId;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_end")
	private Date dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_start")
	private Date dateStart;

	private BigDecimal price;

	private int priority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;



	public ProductSpecial() {
	}

	public int getProductSpecialId() {
		return this.productSpecialId;
	}

	public void setProductSpecialId(int productSpecialId) {
		this.productSpecialId = productSpecialId;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}