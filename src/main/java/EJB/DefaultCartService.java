package EJB;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import JSF.UserController;
import SessionBean.CartFacade;
import SessionBean.SizeFacade;
import model.Cart;
import model.SearchResult;

//@Stateful
@Stateless
public class DefaultCartService {
	private Cart current;
	private List<Cart> items;

	Long totalAmount = Long.valueOf(0);
	Long totalPrice = Long.valueOf(0);
	private String commentary="";

	@EJB
	private CartFacade ejbFacade;

	@Inject
	UserController userController;


	public List<Cart> getItems() {
//		System.out.println("getItems.");
		if (items == null) {
			items = getFacade().findAll();
		}
		return items;
	}

	public void setItems(List<Cart> items) {
		this.items = items;
	}

	public UserController getUserController() {
		return userController;
	}

	public CartFacade getFacade() {
		return ejbFacade;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Cart getCurrent() {
		return current;
	}

	public void setCurrent(Cart current) {
		this.current = current;
	}

	@EJB
	SizeFacade sizeFacade;
	
	private void refreshCart() {
		items = null;
		
		totalAmount = getItems().stream()
				.mapToLong((item) -> item.getAmount())
				.sum();
		totalPrice = getItems().stream()
		.mapToLong((item)->item.getAmount() * item.getPrice())
		.sum();
	}

	public void add(SearchResult item) {
//		System.out.println("sizeId="+item.getSizeId());
		current = new Cart();
		current.setUserId(getUserController().getIdentifier());
		current.setProd(item.getProd());
		current.setSize(sizeFacade.find(item.getSizeId()));
		current.setAmount(item.getAmount());
		current.setPrice(item.getPrice());
		current.setWhouseId(item.getWhouseId());
		getFacade().create(current);
		refreshCart();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("", new FacesMessage("Добавлен."));
	}

	public void del(Cart item) {
//		System.out.println("sizeId="+item.getSizeId());
		getFacade().remove(item);
		refreshCart();
//		FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage("",new FacesMessage("Добавлен."));
	}

	public void edit(Cart item) {
//		System.out.println("sizeId="+item.getSizeId());
		getFacade().edit(item);
		refreshCart();
//		FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage("",new FacesMessage("Добавлен."));
	}


//	public Long getTotalCount() {
//		System.out.println("getCount." + getItems().size());
//		totalAmount = Long.valueOf(0);
//		items.stream().forEach((item) -> {
//			totalAmount += item.getAmount();
//			System.out.println("amount." + item.getAmount());
//		});
//		return totalAmount;
////    	return getFacade().getCount();
//	}

	public Long getTotalCount() {
		return totalAmount;
	}
	
	public Long getTotalPrice() {
		return totalPrice;
	}
	
	public void clearCart() {
		for (Cart cart:items) {
			getFacade().remove(cart);
		}
		refreshCart();
	}

//	@EJB 
//	OrderEJB orderEJB;
	
//	public void confirmCart() {
//		orderEJB.confirmCart(this);
//		order = orderEJB.getOrder();
//		System.out.println(order.getOrignum());
//		clearCart();
//		FacesContext context = FacesContext.getCurrentInstance();
//		context.addMessage("", new FacesMessage("Заказ принят."));
//	}
	

}
