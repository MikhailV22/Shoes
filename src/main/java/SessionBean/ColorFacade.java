package SessionBean;
import java.util.List;

import javax.ejb.Stateless;
import model.Color;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class ColorFacade extends AbstractFacade<Color> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }


	public List<Color> findByProd(Object id){
		List<Color> item  = getEntityManager()
				.createQuery("SELECT c "
						+ "from Color c "
						+ " join fetch c.prods p "
						+ "where p.id =:id "
//						+ " join fetch p.sizes s "
//						+ " join fetch p.colors c "
						,Color.class)
				.setParameter("id",id)
				.getResultList();
		
		return item;
	}
	
	public ColorFacade() {
		super(Color.class);
		// TODO Auto-generated constructor stub
	}
    
    

}


