package SessionBean;
import java.util.List;

import javax.ejb.Stateless;
import model.Warehouse;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class WarehouseFacade extends AbstractFacade<Warehouse> {

	@PersistenceContext(unitName = "shoesPU")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
	    return em;
	}
	
	public WarehouseFacade() {
		super(Warehouse.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Warehouse> findAll() {
	    return getEntityManager().createNativeQuery("SELECT * FROM WAREHOUSE",Warehouse.class).getResultList();
	}

	public List<Warehouse> findByWhouseId(Long prodId,Long whouseId) {
	    return getEntityManager().createNativeQuery(
	    		"SELECT * FROM WAREHOUSE "+
	    " WHERE WHOUSE_ID=:whouseId AND PROD_ID=:prodId"
	    		,Warehouse.class)
	    		.setParameter("prodId", prodId)
	    		.setParameter("whouseId", whouseId)
	    		.getResultList();
	}
}


