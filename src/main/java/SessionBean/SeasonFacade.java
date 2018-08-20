package SessionBean;
import javax.ejb.Stateless;
import model.Season;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class SeasonFacade extends AbstractFacade< Season> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public SeasonFacade() {
		super(Season.class);
		// TODO Auto-generated constructor stub
	}
    
    

}

