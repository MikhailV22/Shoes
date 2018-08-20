	package model;

	import java.io.Serializable;
	import javax.persistence.*;


	/**
	 * The persistent class for the CART database table.
	 * 
	 */
	@Entity
	@Table(name="SEARCH_RESULT")
	public class SearchResult implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name="ID")
		private Long id;

		@Column(name="AMOUNT")
		private Long amount;

		@Column(name="PRICE")
		private Long price;

//		@Column(name="PROD_ID")
//		private Long prodId;
		@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	    @JoinColumn(name = "PROD_ID")
		private Prod prod;

		@Column(name="SIZE_ID")
		private Long sizeId;

		@Column(name="USER_ID")
		private String userId;

		@Column(name="WHOUSE_ID")
		private Long whouseId;

		public SearchResult() {
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

		public Long getPrice() {
			return this.price;
		}

		public void setPrice(Long price) {
			this.price = price;
		}

//		public Long getProdId() {
//			return this.prodId;
//		}
//
//		public void setProdId(Long prodId) {
//			this.prodId = prodId;
//		}

		public Long getSizeId() {
			return this.sizeId;
		}

		public Prod getProd() {
			return prod;
		}

		public void setProd(Prod prod) {
			this.prod = prod;
		}

		public void setSizeId(Long sizeId) {
			this.sizeId = sizeId;
		}

		public String getUserId() {
			return this.userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public Long getWhouseId() {
			return this.whouseId;
		}

		public void setWhouseId(Long whouseId) {
			this.whouseId = whouseId;
		}

	}