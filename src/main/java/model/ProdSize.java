package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the PROD_SIZES database table.
 * 
 */
@Entity
@Table(name="PROD_SIZES")
@NamedQuery(name="ProdSize.findAll", query="SELECT p FROM ProdSize p")
public class ProdSize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(generator="SEQ_PROD_SIZES")
    @SequenceGenerator(name="SEQ_PROD_SIZES", sequenceName="SEQ_PROD_SIZES", allocationSize=1)
	private Long id;

	@Column(name="PROD_ID")
	private java.math.BigDecimal prodId;

	@Column(name="SIZE_ID")
	private java.math.BigDecimal sizeId;

	public ProdSize() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.math.BigDecimal getProdId() {
		return this.prodId;
	}

	public void setProdId(java.math.BigDecimal prodId) {
		this.prodId = prodId;
	}

	public java.math.BigDecimal getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(java.math.BigDecimal sizeId) {
		this.sizeId = sizeId;
	}

}