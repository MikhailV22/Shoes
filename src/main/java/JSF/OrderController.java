package JSF;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;

import EJB.OrderEJB;


@Named("orderController")
@SessionScoped
public class OrderController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private OrderEJB orderEJB;
	public OrderEJB getOrderEJB() {
		return orderEJB;
	}
	public void setOrderEJB(OrderEJB orderEJB) {
		this.orderEJB = orderEJB;
	}
	
	
	
	
}
