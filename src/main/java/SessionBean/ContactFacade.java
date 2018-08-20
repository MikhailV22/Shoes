package SessionBean;
import java.util.List;

import javax.ejb.Stateless;
import model.Contact;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class ContactFacade extends AbstractFacade<Contact> {

	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	public ContactFacade() {
		super(Contact.class);
		// TODO Auto-generated constructor stub
	}
    
    

}



