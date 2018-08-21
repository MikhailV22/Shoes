	package JSF;

	import javax.enterprise.context.SessionScoped;
//	import javax.faces.application.FacesMessage;
//	import javax.faces.context.FacesContext;

	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;

	import javax.ejb.EJB;
	import javax.inject.Inject;
	import javax.inject.Named;

	import EJB.DefaultCartService;
	import EJB.DefaultOrderService;
	import model.Cart;
	import model.Contact;
	import model.Order;
	import model.Orderdetail;
	import model.SearchResult;


	@Named("orderProcessor")
	@SessionScoped
	public class DefaultOrderProcessor   implements Serializable {
		private static final long serialVersionUID = 1L;

		@Inject
		UserController userController;
		
		@EJB
	    private DefaultCartService cartService;
		
		@EJB 
		private DefaultOrderService orderService;

		private Order order;
		private Orderdetail orderdetail;
		private Contact contact;
		private String commentary;

		
		public Long getTotalPrice() {
			return cartService.getTotalPrice();
			
		}
		
		
		public UserController getUserController() {
			return userController;
		}

		public void setUserController(UserController userController) {
			this.userController = userController;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public List<Cart> getItems() {
//	    	System.out.println("getItems.");
	    	return cartService.getItems();
	    }
		
		

		public Contact getContact() {
			if(contact==null) {
				contact = new Contact();
			}
			contact.setCity("Москва");
			contact.setUserId(getUserController().getIdentifier());
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}
		
		
		public String getCommentary() {
			return commentary;
		}

		public void setCommentary(String commentary) {
			this.commentary = commentary;
		}

		public String confirmCart() {
			
//			contact = new Contact();
			order = orderService.getEmptyOrder();

//			order.setRegdate(new Date());
//			order.setOrignum("-");
			order.setUserId(getUserController().getIdentifier());
			order.setSumma(cartService.getTotalPrice());
			order.setAmount(cartService.getTotalCount());
			order.setCommentary(getCommentary());
//			contactFacade.create(contact);
			order.setContact(contact);

			order.setOrderdetails(new ArrayList<>());
			for (Cart item:cartService.getItems()) {
				orderdetail = new Orderdetail();
				orderdetail.setAmount(item.getAmount());
				orderdetail.setPrice(item.getPrice());
				orderdetail.setWhouseId(item.getWhouseId());
				orderdetail.setProdId(item.getProd().getId());
				orderdetail.setSizeId(item.getSize().getId());
				orderdetail.setOrder(order);
				order.getOrderdetails().add(orderdetail);
			}
			
			orderService.create(order);
//			System.out.println("userId="+order.getId());
			order.setOrignum(order.getId().toString());
			orderService.edit(order);
			
			
//			orderEJB.confirmCart(cartEJB);
			//order = orderEJB.getOrder();
//			System.out.println(order.getOrignum());
			cartService.clearCart();
			setCommentary(null);
			contact = null;
//	        FacesContext context = FacesContext.getCurrentInstance();
//	        context.addMessage("",new FacesMessage("Заказ принят."));
			return "Confirm.xhtml?faces-redirect=true";
		}
		
		public DefaultCartService getCartService() {
			return cartService;
		}
		

	}



