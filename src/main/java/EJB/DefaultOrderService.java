package EJB;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

//import SessionBean.CartEJB;
//import SessionBean.ContactFacade;
import SessionBean.OrderFacade;
//import model.Cart;
//import model.Contact;
import model.Order;
//import model.Orderdetail;

@Stateless
public class DefaultOrderService {
	
	@EJB
	private OrderFacade orderFacade;
//	@EJB
//	private ContactFacade contactFacade;
	
	private Order order;
//	private Orderdetail orderdetail;
//	private Contact contact;

	
	private OrderFacade getFacade() {
		return orderFacade;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

//	public Orderdetail getOrderdetail() {
//		return orderdetail;
//	}
//
//	public void setOrderdetail(Orderdetail orderdetail) {
//		this.orderdetail = orderdetail;
//	}
//
//	public Contact getContact() {
//		return contact;
//	}
//
//	public void setContact(Contact contact) {
//		this.contact = contact;
//	}

	public void create(Order entity) {
		getFacade().create(entity);
//		order = entity;
	}

	public void edit(Order entity) {
		getFacade().edit(entity);
	}
	
	public Order getEmptyOrder() {
		order = new Order();
//		order.setContact(new Contact());
		order.setRegdate(new Date());
		order.setOrignum("-");
		return order;
	}

//	public void confirmCart(CartEJB cart) {
//		order = new Order();
//		contact = new Contact();
//		order.setOrderdetails(new ArrayList<>());
//
//		order.setRegdate(new Date());
//		order.setOrignum("-");
//		order.setUserId("test");
//		order.setSumma(cart.getTotalPrice());
//		order.setAmount(cart.getTotalCount());
//		order.setCommentary(cart.getCommentary());
//		
//		contact.setCity("moscow");
////		contactFacade.create(contact);
//		
//		order.setContact(contact);
//
//		for (Cart item:cart.getItems()) {
//			orderdetail = new Orderdetail();
//			orderdetail.setAmount(item.getAmount());
//			orderdetail.setPrice(item.getPrice());
//			orderdetail.setWhouseId(item.getWhouseId());
//			orderdetail.setProdId(item.getProd().getId());
//			orderdetail.setSizeId(item.getSize().getId());
//			orderdetail.setOrder(order);
//			order.getOrderdetails().add(orderdetail);
//		}
//		
//		orderFacade.create(order);
////		System.out.println("userId="+order.getId());
//		order.setOrignum(order.getId().toString());
//		orderFacade.edit(order);
//	}
	

}
