package SessionBean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import model.Cart;
import model.Prod;
import model.SearchResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import JSF.UserController;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class CartFacade extends AbstractFacade<Cart> {
	
	Logger logger = Logger.getLogger(CartFacade.class.getName());
	@Inject
	UserController userController;
	
	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public CartFacade() {
		super(Cart.class);
		// TODO Auto-generated constructor stub
	}
    
    
    public Long getCount() {
    	
		Long cnt =Long.parseLong(getEntityManager().createNativeQuery("SELECT \r\n" + 
        		"COUNT(ID)  \r\n" + 
        		" FROM CART "+
        		" WHERE USER_ID=:userId "
        		)
				.setParameter("userId", userController.getIdentifier())
				.getSingleResult().toString()
				);
		return cnt;
    }
	
	@Override
    public List<Cart> findAll() {
		
		logger.info("Cart.findAll");
		
//		logger.log(Level.INFO, "Cart.findAll");
		
//		System.out.println("searchParam.getSelectedTrademarks()."+searchParam.getProdtypesAsList());
		
		
//		System.out.println("sqlSeason."+searchParam.getSeasonAsList());
//		System.out.println("Cart.findAll");
		List<Cart> list = getEntityManager().createNativeQuery("SELECT \r\n" + 
        		"*  \r\n" + 
        		" FROM CART "+
        		" WHERE USER_ID=:userId "
        		,Cart.class)
				.setParameter("userId", userController.getSessionId())
				.getResultList();
		for(Cart p:list) {
			p.getProd().getPictures().size();
//			p.setColors(colorFacade.findAll());
//			System.out.printf("Sizes %s    %s",p.getId(), p.getSizes().size());
//			System.out.println("");
//			System.out.printf("Colors %s    %s",p.getId(), p.getColors().size());
//			System.out.println("");
		}
		
		return list;
    }    

}
