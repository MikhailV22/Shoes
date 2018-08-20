package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TRADEMARKS database table.
 * 
 */
@Entity
@Table(name="TRADEMARKS")
@NamedQuery(name="Trademark.findAll", query="SELECT t FROM Trademark t")
public class Trademark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(generator="SEQ_TRADEMARK")
    @SequenceGenerator(name="SEQ_TRADEMARK", sequenceName="SEQ_TRADEMARK", allocationSize=1)
	private Long id;

	private String commentary;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private BigDecimal isdeleted;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date updatedate;

//	@OneToMany(mappedBy = "trademark", fetch = FetchType.LAZY)
//    private List<Prod> prods;	
	
	
	
//	public List<Prod> getProds() {
//		return prods;
//	}
//
//	public void setProds(List<Prod> prods) {
//		this.prods = prods;
//	}

	public Trademark() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentary() {
		return this.commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
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

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public int hashCode() {
		int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Trademark other = (Trademark) obj;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
		return true;
	}
	
}