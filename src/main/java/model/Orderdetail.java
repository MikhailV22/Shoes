package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ORDERDETAIL database table.
 * 
 */
@Entity
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDERDETAIL_ID_GENERATOR", sequenceName="SEQ_ORDERDETAIL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDERDETAIL_ID_GENERATOR")
	private long id;

	private Long amount;

	private Long price;

	@Column(name="PROD_ID")
	private Long prodId;

	@Column(name="SIZE_ID")
	private Long sizeId;

	@Column(name="WHOUSE_ID")
	private Long whouseId;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	public Orderdetail() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public Long getWhouseId() {
		return whouseId;
	}

	public void setWhouseId(Long whouseId) {
		this.whouseId = whouseId;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}