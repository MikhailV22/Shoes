package JSF;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import SessionBean.MedicaltypeFacade;
import model.Medicaltype;
import java.util.List;

@Named("medicaltypeController")
@SessionScoped
public class MedicaltypeController   implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
    private MedicaltypeFacade ejbFacade;
	
	private List<Medicaltype> items;

    public MedicaltypeFacade getFacade() {
        return ejbFacade;
    }

    
    public List<Medicaltype> getItems() {
    	if(items==null) {
    		items = getFacade().findAll();
    	}
		return items;
	}


	public void setItems(List<Medicaltype> items) {
		this.items = items;
	}


	public SelectItem[] getItemsAvailableSelectMany() {
//        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
        return getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
//        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
        return getSelectItems(ejbFacade.findAll(), true);
    }

    
    public static SelectItem[] getSelectItems(List<Medicaltype> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("0", "---");
            i++;
        }
        for (Medicaltype x : entities) {
            items[i++] = new SelectItem(x, x.getName());
        }
        return items;
    }	

}
