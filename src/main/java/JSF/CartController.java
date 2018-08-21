	package JSF;

	import javax.enterprise.context.SessionScoped;
//	import javax.faces.application.FacesMessage;
//	import javax.faces.context.FacesContext;

	import java.io.Serializable;
	import java.util.List;

	import javax.ejb.EJB;
	import javax.inject.Inject;
	import javax.inject.Named;

	import EJB.DefaultCartService;
	import model.Cart;
	import model.SearchResult;


	@Named("cartController")
	@SessionScoped
	public class CartController   implements Serializable {
		private static final long serialVersionUID = 1L;

		@Inject
		UserController userController;
		
		@EJB
	    private DefaultCartService cartService;
		
		
		public UserController getUserController() {
			return userController;
		}

		public void setUserController(UserController userController) {
			this.userController = userController;
		}


		public List<Cart> getItems() {
	    	return cartService.getItems();
	    }
		
		public Long getTotalCount() {
			return cartService.getTotalCount();
		}
		
		public Long getTotalPrice() {
			return cartService.getTotalPrice();
			
		}
		
		
	    public void add(SearchResult item) {
	    	cartService.add(item);
		}

		public void del(Cart item) {
			cartService.del(item);
		}
		
		public void edit(Cart item) {
			cartService.edit(item);
		}

		public DefaultCartService getCartService() {
			return cartService;
		}

		
		

	}



