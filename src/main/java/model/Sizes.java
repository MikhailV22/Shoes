	package model;

	import java.io.Serializable;
	import javax.persistence.*;
	import javax.validation.constraints.NotNull;

	import java.util.ArrayList;
	import java.util.List;


	/**
	 * The persistent class for the WAREHOUSE database table.
	 * 
	 */
	@Entity
	@Table(name="SIZES")
	@NamedQuery(name="Sizes.findAll", query="SELECT w FROM Sizes w")
	public class Sizes implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
	    @NotNull
	    @SequenceGenerator(name="SEQ_SIZES", sequenceName="SEQ_SIZES", allocationSize=1)
	    @GeneratedValue(generator="SEQ_SIZES")
		private Long id;

		@Column(name="NAME")
		private String name;


		@ManyToMany(mappedBy = "sizes")
		private List<Prod> prods = new ArrayList<>();
		
		public List<Prod> getProds() {
			return prods;
		}

		public void setProds(List<Prod> prods) {
			this.prods = prods;
		}

		public Sizes() {
		}

		public Long getId() {
			return this.id;
		}

		public void setId(Long id) {
			this.id = id;
		}


//		public Prod getProd() {
//			return prod;
//		}
//
//		public void setProd(Prod prod) {
//			this.prod = prod;
//		}

		public String getName() {
			return name;
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
			Sizes other = (Sizes) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}


	}