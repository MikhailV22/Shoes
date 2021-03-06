package JSF;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import SessionBean.SeasonFacade;
import model.Prodtype;
import model.Season;
import java.util.List;

@Named("seasonController")
@SessionScoped
public class SeasonController implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Season> items;
	@EJB
    private SeasonFacade ejbFacade;	

    public SeasonFacade getFacade() {
        return ejbFacade;
    }

    
    
    public List<Season> getItems() {
    	if(items==null) {
    		items = getFacade().findAll();
    	}
		return items;
	}



	public void setItems(List<Season> items) {
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

    
    public static SelectItem[] getSelectItems(List<Season> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Season x : entities) {
            items[i++] = new SelectItem(x.getId(), x.getName());
        }
        return items;
    }	

}
