package JSF;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import EJB.DefaultWarehouseService;
import Interceprots.MyLogger;
import JSF.util.JsfUtil;
import SessionBean.WarehouseFacade;
import java.util.List;
import model.Warehouse;



@Named("warehouseController")
@SessionScoped
public class WarehouseController implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Warehouse> items;
//	private Warehouse current;
//	
//	public Warehouse getCurrent() {
//		if(current==null) {
//			current = new Warehouse();
//		}
//		return current;
//	}		
//
//	public void setCurrent(Warehouse current) {
//		this.current = current;
//	}


	@EJB
    private DefaultWarehouseService ejbService;	


    public DefaultWarehouseService getEjbService() {
		return ejbService;
	}

    
    
    public List<Warehouse> getItems() {
		return items;
	}



	public void setItems(List<Warehouse> items) {
		this.items = items;
	}



	public void edit(Warehouse entity) {
    	System.out.printf("id:%s   amout:%s",entity.getProd().getId(),entity.getAmount());
    	System.out.println("");
    	getEjbService().edit(entity);
    }
    
	public List<Warehouse> getAll(){
    	System.out.println("----------------------getAll WAREHOUSES------------------");
    	
    	return getEjbService().findAll();
    }
    
	public List<Warehouse> findByWhouseId(Long prodId,Long whouseId) {
		if (items == null) {
			items = getEjbService().findByWhouseId(prodId,whouseId);
		}
    	return items;
	}

}
