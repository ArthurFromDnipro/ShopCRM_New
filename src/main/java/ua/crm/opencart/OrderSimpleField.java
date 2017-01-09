package ua.crm.opencart;

import javax.persistence.*;


/**
 * The persistent class for the oc_order_simple_fields database table.
 * 
 */
@Entity
@Table(name="oc_order_simple_fields")

public class OrderSimpleField {


	@Id
	@Column(name="order_id")
	private int orderId;

	@MapsId
	@OneToOne(mappedBy = "orderSimpleField")
	@JoinColumn(name = "order_id")
	private Order order;



	@Column(name = "metadata",columnDefinition = "TEXT")
	private String metadata;


	@Column(name="payment_new_pochta_id",columnDefinition = "TEXT")
	private String paymentNewPochtaId;


	@Column(name="shipping_new_pochta_id",columnDefinition = "TEXT")
	private String shippingNewPochtaId;

	public OrderSimpleField() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getMetadata() {
		return this.metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getPaymentNewPochtaId() {
		return this.paymentNewPochtaId;
	}

	public void setPaymentNewPochtaId(String paymentNewPochtaId) {
		this.paymentNewPochtaId = paymentNewPochtaId;
	}

	public String getShippingNewPochtaId() {
		return this.shippingNewPochtaId;
	}

	public void setShippingNewPochtaId(String shippingNewPochtaId) {
		this.shippingNewPochtaId = shippingNewPochtaId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}