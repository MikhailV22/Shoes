package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PROD_COLORS database table.
 * 
 */
@Entity
@Table(name="PROD_COLORS")
@NamedQuery(name="ProdColor.findAll", query="SELECT p FROM ProdColor p")
public class ProdColor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="SEQ_PROD_COLORS", sequenceName="SEQ_PROD_COLORS", allocationSize=1)
    @GeneratedValue(generator="SEQ_PROD_COLORS")
	private long id;

	private BigDecimal isdeleted;

	@Column(name="PROD_ID")
	private BigDecimal prodId;


	//bi-directional many-to-one association to Color
//	@ManyToOne(optional = false, fetch = FetchType.EAGER)
//    @JoinColumn(name = "COLOR_ID")
//	private Color color;

	public ProdColor() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(BigDecimal isdeleted) {
		this.isdeleted = isdeleted;
	}

	public BigDecimal getProdId() {
		return this.prodId;
	}

	public void setProdId(BigDecimal prodId) {
		this.prodId = prodId;
	}

//	public Color getColor() {
//		return this.color;
//	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}

}