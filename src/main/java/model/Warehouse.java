package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;


/**
 * The persistent class for the WAREHOUSE database table.
 * 
 */
@Entity
@Table(name="WAREHOUSE")
@NamedQuery(name="Warehouse.findAll", query="SELECT w FROM Warehouse w")
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @SequenceGenerator(name="SEQ_WAREHOUSE", sequenceName="SEQ_WAREHOUSE", allocationSize=1)
    @GeneratedValue(generator="SEQ_WAREHOUSE")
	private long id;

	private BigDecimal amount;

	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROD_ID")
	private Prod prod;

//	@Column(name="PROD_ID")
//	private BigDecimal prodId;

	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "SIZE_ID")
	private Sizes size;
//	@Column(name="SIZE_ID")
//	private BigDecimal sizeId;

	@Column(name="WHOUSE_ID")
	private BigDecimal whouseId;

	public Warehouse() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

//	public BigDecimal getProdId() {
//		return this.prodId;
//	}
//
//	public void setProdId(BigDecimal prodId) {
//		this.prodId = prodId;
//	}


	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}


	public Sizes getSize() {
		return size;
	}

	public void setSize(Sizes size) {
		this.size = size;
	}

	public BigDecimal getWhouseId() {
		return this.whouseId;
	}

	public void setWhouseId(BigDecimal whouseId) {
		this.whouseId = whouseId;
	}

}