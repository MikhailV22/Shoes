package JSF;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import SessionBean.SizeFacade;
import model.Sizes;
import java.util.List;

@Named("sizeController")
@SessionScoped
public class SizeController   implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
    private SizeFacade ejbFacade;
	
	private List<Sizes> items;

    public SizeFacade getFacade() {
        return ejbFacade;
    }

    
    public List<Sizes> getItems() {
    	if(items==null) {
    		items = getFacade().findAll();
    	}
		return items;
	}


	public void setItems(List<Sizes> items) {
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

    
    public static SelectItem[] getSelectItems(List<Sizes> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("0", "---");
            i++;
        }
        for (Sizes x : entities) {
            items[i++] = new SelectItem(x, x.getName());
        }
        return items;
    }	

}
