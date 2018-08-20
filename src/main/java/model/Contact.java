package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONTACTS database table.
 * 
 */
@Entity
@Table(name="CONTACTS")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACTS_ID_GENERATOR", sequenceName="SEQ_CONTACTS", allocationSize=1)
	@GeneratedValue(generator="CONTACTS_ID_GENERATOR")
	private long id;

	private String city;

	private String flat;

	private String house;

	private String street;

	@Column(name="USER_ID")
	private String userId;

	public Contact() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFlat() {
		return this.flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getHouse() {
		return this.house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}