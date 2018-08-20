package SessionBean;
import java.util.List;

import javax.ejb.Stateless;
import model.Orderdetail;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class OrderDetailFacade extends AbstractFacade<Orderdetail> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	public OrderDetailFacade() {
		super(Orderdetail.class);
		// TODO Auto-generated constructor stub
	}
    
    

}



