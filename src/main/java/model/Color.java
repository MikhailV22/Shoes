package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the COLORS database table.
 * 
 */
@Entity
@Table(name="COLORS")
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name="SEQ_COLORS", sequenceName="SEQ_COLORS", allocationSize=1)
    @GeneratedValue(generator="SEQ_COLORS")
	private Long id;

	private String code;

	private BigDecimal isdeleted;

	private String name;

	//bi-directional many-to-one association to ProdColor
//	@OneToMany(mappedBy="color")
//	private List<ProdColor> prodColors;
	
	
	@ManyToMany(mappedBy = "colors")
	private List<Prod> prods = new ArrayList<>();	

	
	
	public List<Prod> getProds() {
		return prods;
	}

	public void setProds(List<Prod> prods) {
		this.prods = prods;
	}

	public Color() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(BigDecimal isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		Color other = (Color) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", name=" + name + "]";
	}

//	public List<ProdColor> getProdColors() {
//		return this.prodColors;
//	}
//
//	public void setProdColors(List<ProdColor> prodColors) {
//		this.prodColors = prodColors;
//	}

//	public ProdColor addProdColor(ProdColor prodColor) {
//		getProdColors().add(prodColor);
//		prodColor.setColor(this);
//
//		return prodColor;
//	}
//
//	public ProdColor removeProdColor(ProdColor prodColor) {
//		getProdColors().remove(prodColor);
//		prodColor.setColor(null);
//
//		return prodColor;
//	}

	
	
}