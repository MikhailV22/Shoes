package JSF;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;

import EJB.DefaultOrderService;


@Named("orderController")
@SessionScoped
public class OrderController implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private DefaultOrderService orderProcessor;
	public DefaultOrderService getOrderProcessor() {
		return orderProcessor;
	}
	public void setOrderProcessor(DefaultOrderService orderProcessor) {
		this.orderProcessor = orderProcessor;
	}
	
	
	
	
}
