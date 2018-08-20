package SessionBean;
import java.util.List;

import javax.ejb.Stateless;
import model.Sizes;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class SizeFacade extends AbstractFacade<Sizes> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }


	public List<Sizes> findByProd(Object id){
		List<Sizes> item  = getEntityManager()
				.createQuery("SELECT c "
						+ "from Sizes c "
						+ " join fetch c.prods p "
						+ "where p.id =:id "
//						+ " join fetch p.sizes s "
//						+ " join fetch p.colors c "
						,Sizes.class)
				.setParameter("id",id)
				.getResultList();
		
		return item;
	}
	
	public SizeFacade() {
		super(Sizes.class);
		// TODO Auto-generated constructor stub
	}
    
    

}


