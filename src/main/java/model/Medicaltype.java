package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MEDICALTYPES database table.
 * 
 */
@Entity
@Table(name="MEDICALTYPES")
@NamedQuery(name="Medicaltype.findAll", query="SELECT m FROM Medicaltype m")
public class Medicaltype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(generator="SEQ_MEDICALTYPE")
    @SequenceGenerator(name="SEQ_MEDICALTYPE", sequenceName="SEQ_MEDICALTYPE", allocationSize=1)
	private Long id;

	private String commentary;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private BigDecimal isdeleted;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date updatedate;

	public Medicaltype() {
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
	public String toString() {
		return  id.toString();
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
		Medicaltype other = (Medicaltype) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}