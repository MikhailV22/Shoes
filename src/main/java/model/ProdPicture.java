package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the PROD_PICTURES database table.
 * 
 */
@Entity
@Table(name="PROD_PICTURES")
@NamedQuery(name="ProdPicture.findAll", query="SELECT p FROM ProdPicture p")
public class ProdPicture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @SequenceGenerator(name="SEQ_PROD_PICTURES", sequenceName="SEQ_PROD_PICTURES", allocationSize=1)
    @GeneratedValue(generator="SEQ_PROD_PICTURES")
	private Long id;

	private String picture;

//	@Column(name="PROD_ID")
//	private java.math.BigDecimal prodId;

	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "PROD_ID")
	private Prod prod;
	
	
	public ProdPicture() {
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdPicture other = (ProdPicture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}