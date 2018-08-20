package SessionBean;

import javax.ejb.Stateless;
import model.Medicaltype;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class MedicaltypeFacade extends AbstractFacade<Medicaltype> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public MedicaltypeFacade() {
		super(Medicaltype.class);
		// TODO Auto-generated constructor stub
	}
    
    

}
