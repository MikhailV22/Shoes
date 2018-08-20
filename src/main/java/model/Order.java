package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;


	
	@Id
	@SequenceGenerator(name="ORDERS_ID_GENERATOR", sequenceName="SEQ_ORDERS", allocationSize=1)
	@GeneratedValue(generator="ORDERS_ID_GENERATOR")
	private Long id;

	private Long amount;

	private String commentary;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
	@JoinColumn(name = "CONTACT_ID")
	private Contact contact;

//	@Column(name="CONTACT_ID")
//	private BigDecimal contactId;

	private String orignum;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private Long summa;

	@Column(name="USER_ID")
	private String userId;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="order", fetch = FetchType.EAGER, 
			targetEntity=Orderdetail.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private List<Orderdetail> orderdetails;

	public Order() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCommentary() {
		return this.commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}


	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getOrignum() {
		return this.orignum;
	}

	public void setOrignum(String orignum) {
		this.orignum = orignum;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Long getSumma() {
		return this.summa;
	}

	public void setSumma(Long summa) {
		this.summa = summa;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Orderdetail addOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setOrder(this);

		return orderdetail;
	}

	public Orderdetail removeOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setOrder(null);

		return orderdetail;
	}

}