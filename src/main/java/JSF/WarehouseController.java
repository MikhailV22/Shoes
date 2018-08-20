package JSF;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import Interceprots.MyLogger;
import JSF.util.JsfUtil;
import SessionBean.WarehouseFacade;
import java.util.List;
import model.Warehouse;



@Named("warehouseController")
@SessionScoped
public class WarehouseController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Warehouse current;
	
	
	public Warehouse getCurrent() {
		if(current==null) {
			current = new Warehouse();
		}
		return current;
	}

	public void setCurrent(Warehouse current) {
		this.current = current;
	}


	@EJB
    private SessionBean.WarehouseFacade ejbFacade;	

    private WarehouseFacade getFacade() {
        return ejbFacade;
    }

    public List<Warehouse> getAll(){
    	System.out.println("----------------------getAll WAREHOUSES------------------");
    	return getFacade().findAll();
    }
    
	public List<Warehouse> findByWhouseId(Long prodId,Long whouseId) {
    	return getFacade().findByWhouseId(prodId,whouseId);
	}

}
