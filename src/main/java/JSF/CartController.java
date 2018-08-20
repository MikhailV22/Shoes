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

	import EJB.OrderEJB;
	import SessionBean.CartEJB;
	import model.Cart;
	import model.Contact;
	import model.Order;
	import model.Orderdetail;
	import model.SearchResult;


	@Named("cartController")
	@SessionScoped
	public class CartController   implements Serializable {
		private static final long serialVersionUID = 1L;

		@Inject
		UserController userController;
		
		@EJB
	    private CartEJB cartEJB;
		
		@EJB 
		private OrderEJB orderEJB;

		private Order order;

		
		
		
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
	    	return cartEJB.getItems();
	    }
		
		
//		public String getOrignum() {
//			return order.getOrignum();
//		}
//
//		public String getSumma() {
//			return order.getSumma().toString();
//		}

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
			return cartEJB.getCommentary();
		}

		public void setCommentary(String commentary) {
			cartEJB.setCommentary(commentary);
		}

		public Long getTotalCount() {
			return cartEJB.getTotalCount();
		}
		
		public Long getTotalPrice() {
			return cartEJB.getTotalPrice();
			
		}
		
		
		
		
	    public void add(SearchResult item) {
			cartEJB.add(item);
		}

		public void del(Cart item) {
			cartEJB.del(item);
		}
		
		public void edit(Cart item) {
			cartEJB.edit(item);
		}
		
		

		private Orderdetail orderdetail;
		private Contact contact;
		
		

		public String confirmCart() {
			
//			contact = new Contact();
			order = orderEJB.getEmptyOrder();
			order.setOrderdetails(new ArrayList<>());

//			order.setRegdate(new Date());
//			order.setOrignum("-");
			order.setUserId(getUserController().getIdentifier());
			order.setSumma(cartEJB.getTotalPrice());
			order.setAmount(cartEJB.getTotalCount());
			order.setCommentary(cartEJB.getCommentary());
//			contactFacade.create(contact);
			order.setContact(contact);

			for (Cart item:cartEJB.getItems()) {
				orderdetail = new Orderdetail();
				orderdetail.setAmount(item.getAmount());
				orderdetail.setPrice(item.getPrice());
				orderdetail.setWhouseId(item.getWhouseId());
				orderdetail.setProdId(item.getProd().getId());
				orderdetail.setSizeId(item.getSize().getId());
				orderdetail.setOrder(order);
				order.getOrderdetails().add(orderdetail);
			}
			
			orderEJB.create(order);
//			System.out.println("userId="+order.getId());
			order.setOrignum(order.getId().toString());
			orderEJB.edit(order);
			
			
//			orderEJB.confirmCart(cartEJB);
			//order = orderEJB.getOrder();
//			System.out.println(order.getOrignum());
			cartEJB.clearCart();
			setCommentary(null);
			contact = null;
//	        FacesContext context = FacesContext.getCurrentInstance();
//	        context.addMessage("",new FacesMessage("Заказ принят."));
			return "Confirm.xhtml?faces-redirect=true";
		}

//		public String confirmCart() {
//			
//			
//			orderEJB.confirmCart(cartEJB);
//			order = orderEJB.getOrder();
//			System.out.println(order.getOrignum());
//			cartEJB.clearCart();
//			setCommentary(null);
////	        FacesContext context = FacesContext.getCurrentInstance();
////	        context.addMessage("",new FacesMessage("Заказ принят."));
//			return "Confirm.xhtml";
//		}
		

	}



