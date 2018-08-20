package SessionBean;
import java.util.List;

import javax.ejb.Stateless;
import model.ProdPicture;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class ProdPictureFacade extends AbstractFacade<ProdPicture> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }


	public List<ProdPicture> findByProd(Object id){
		List<ProdPicture> item  = getEntityManager()
				.createQuery("SELECT PIC "
						+ "from ProdPicture PIC "
						+ " join fetch PIC.prod p "
						+ "where p.id =:id "
//						+ " join fetch p.sizes s "
//						+ " join fetch p.colors c "
						,ProdPicture.class)
				.setParameter("id",id)
				.getResultList();
		
		return item;
	}

	
	public ProdPictureFacade() {
		super(ProdPicture.class);
		// TODO Auto-generated constructor stub
	}
    
    

}


