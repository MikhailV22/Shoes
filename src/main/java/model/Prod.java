package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PROD database table.
 * 
 */
@Entity
@NamedQuery(name="Prod.findAll", query="SELECT p FROM Prod p")
public class Prod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(generator="SEQ_PROD")
    @SequenceGenerator(name="SEQ_PROD", sequenceName="SEQ_PROD", allocationSize=1)
	private Long id;

	private String code;

	@Column(name="COLLECTION_ID")
	private BigDecimal collectionId;

	private String commentary;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	@Lob
	private String descr;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "GENDER_ID")
	private Gender gender;

//	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEDICALTYPE_ID", nullable = true)
	private Medicaltype medicaltype;

	private String name;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODTYPE_ID")
	private Prodtype prodtype;

	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "SEASON_ID")
	private Season season;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "TRADEMARK_ID")
	private Trademark trademark;
	
	@OneToMany(mappedBy = "prod", targetEntity=Warehouse.class)
	private List<Warehouse> warehouse;	
	
	@OneToMany(mappedBy = "prod",fetch = FetchType.LAZY, targetEntity=ProdPicture.class, cascade = CascadeType.MERGE)
	private List<ProdPicture> pictures = new ArrayList<>();
	
//	@OneToMany(mappedBy = "prod",fetch = FetchType.LAZY, targetEntity=Sizes.class, cascade = CascadeType.MERGE)
//	private List<Sizes> sizes = new ArrayList<>();	
	
	@ManyToMany(targetEntity=Sizes.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PROD_SIZES",
            joinColumns = @JoinColumn(name = "PROD_ID"),
            inverseJoinColumns = @JoinColumn(name = "SIZE_ID")
    )
	private List<Sizes> sizes = new ArrayList<>();

	@ManyToMany(targetEntity=Color.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "PROD_COLORS",
            joinColumns = @JoinColumn(name = "PROD_ID"),
            inverseJoinColumns = @JoinColumn(name = "COLOR_ID")
    )
	private List<Color> colors = new ArrayList<>();
//	@Transient
//	private Long amount;
	

//	public Long getAmount() {
//		if(amount==null) {
//			amount = Long.valueOf(1);
//		}
//		return amount;
//	}
//
//	public void setAmount(Long amount) {
//		this.amount = amount;
//	}

	
	public List<Warehouse> getWarehouse() {
		return warehouse;
	}

	public List<ProdPicture> getPictures() {
		return pictures;
	}

	public void setPictures(List<ProdPicture> pictures) {
		this.pictures = pictures;
	}

	public void setWarehouse(List<Warehouse> warehouse) {
		this.warehouse = warehouse;
	}


	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public List<Sizes> getSizes() {
		return sizes;
	}

	public void setSizes(List<Sizes> sizes) {
		this.sizes = sizes;
	}


	@Temporal(TemporalType.DATE)
	private Date updatedate;

	public Prod() {
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

	public BigDecimal getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(BigDecimal collectionId) {
		this.collectionId = collectionId;
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

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

//	public BigDecimal getGenderId() {
//		return this.genderId;
//	}
//
//	public void setGenderId(BigDecimal genderId) {
//		this.genderId = genderId;
//	}

	

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Medicaltype getMedicaltype() {
		return medicaltype;
	}

	public void setMedicaltype(Medicaltype medicaltype) {
		this.medicaltype = medicaltype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
//	public BigDecimal getProdtypeId() {
//		return this.prodtypeId;
//	}
//
//	public void setProdtypeId(BigDecimal prodtypeId) {
//		this.prodtypeId = prodtypeId;
//	}

	public Prodtype getProdtype() {
		return prodtype;
	}

	public void setProdtype(Prodtype prodtype) {
		this.prodtype = prodtype;
	}

//	public BigDecimal getSeasonId() {
//		return this.seasonId;
//	}
//
//	public void setSeasonId(BigDecimal seasonId) {
//		this.seasonId = seasonId;
//	}

//	public BigDecimal getTrademarkId() {
//		return this.trademarkId;
//	}
//
//	public void setTrademarkId(BigDecimal trademarkId) {
//		this.trademarkId = trademarkId;
//	}
	

	public Date getUpdatedate() {
		return this.updatedate;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Trademark getTrademark() {
		return trademark;
	}

	public void setTrademark(Trademark trademark) {
		this.trademark = trademark;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "Prod [id=" + id + ", name=" + name + "]";
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

		Prod other = (Prod) obj;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
		return true;
	}
	
	

	
}