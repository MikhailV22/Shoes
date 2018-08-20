package SessionBean;

import javax.ejb.Stateless;
import model.Prodtype;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class ProdtypeFacade extends AbstractFacade<Prodtype> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public ProdtypeFacade() {
		super(Prodtype.class);
		// TODO Auto-generated constructor stub
	}
    
    

}
