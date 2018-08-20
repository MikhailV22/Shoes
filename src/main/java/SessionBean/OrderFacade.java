package SessionBean;
import java.util.List;

import javax.ejb.Stateless;
import model.Order;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class OrderFacade extends AbstractFacade<Order> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	public OrderFacade() {
		super(Order.class);
		// TODO Auto-generated constructor stub
	}
    
    

}



