package EJB;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import SessionBean.WarehouseFacade;
import model.Warehouse;

@Stateless
public class DefaultWarehouseService {

	private Warehouse current;
	
	@EJB
    private SessionBean.WarehouseFacade ejbFacade;	

	public DefaultWarehouseService() {
	}
	
	public Warehouse getCurrent() {
		if(current==null) {
			current = new Warehouse();
		}
		return current;
	}

	public void setCurrent(Warehouse current) {
		this.current = current;
	}


    private WarehouseFacade getFacade() {
        return ejbFacade;
    }
    
    public void edit(Warehouse entity) {
    	getFacade().edit(entity);
    }

    public List<Warehouse> findAll(){
    	System.out.println("----------------------getAll WAREHOUSES------------------");
    	return getFacade().findAll();
    }
    
	public List<Warehouse> findByWhouseId(Long prodId,Long whouseId) {
    	return getFacade().findByWhouseId(prodId,whouseId);
	}
	

}
