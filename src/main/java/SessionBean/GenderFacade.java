package SessionBean;

import javax.ejb.Stateless;
import model.Gender;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class GenderFacade extends AbstractFacade<Gender> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public GenderFacade() {
		super(Gender.class);
		// TODO Auto-generated constructor stub
	}
    
    

}
