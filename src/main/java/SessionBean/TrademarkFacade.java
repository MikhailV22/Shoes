package SessionBean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import model.Trademark;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




@Stateless
public class TrademarkFacade extends AbstractFacade<Trademark> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public TrademarkFacade() {
		super(Trademark.class);
		// TODO Auto-generated constructor stub
	}
    
    

}
