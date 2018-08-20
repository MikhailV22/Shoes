package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRODTYPES database table.
 * 
 */
@Entity
@Table(name="PRODTYPES")
@NamedQuery(name="Prodtype.findAll", query="SELECT p FROM Prodtype p")
public class Prodtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(generator="SEQ_PRODTYPES")
    @SequenceGenerator(name="SEQ_PRODTYPES", sequenceName="SEQ_PRODTYPES", allocationSize=1)
	private Long id;

	private String commentary;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private BigDecimal isdeleted;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date updatedate;

	public Prodtype() {
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

}