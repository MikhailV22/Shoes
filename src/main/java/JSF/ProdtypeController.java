package JSF;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;

import JSF.util.JsfUtil;
import SessionBean.ProdtypeFacade;
import model.Prodtype;


import java.util.List;

@Named("prodtypeController")
@SessionScoped
public class ProdtypeController   implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Prodtype> items;
	
	@EJB
    private ProdtypeFacade ejbFacade;	

    public ProdtypeFacade getFacade() {
        return ejbFacade;
    }

    public SelectItem[] getItemsAvailableSelectMany() {
//        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
        return getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
//        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
        return getSelectItems(ejbFacade.findAll(), true);
    }

    
    public static SelectItem[] getSelectItems(List<Prodtype> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Prodtype x : entities) {
            items[i++] = new SelectItem(x.getId(), x.getName());
        }
        return items;
    }	

    
    
    
    public List<Prodtype> getItems() {
    	if(items==null) {
    		items = getFacade().findAll();
    	}
		return items;
	}

	public void setItems(List<Prodtype> items) {
		this.items = items;
	}




	@FacesConverter(forClass = Prodtype.class)
    public static class ProdtypeControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProdtypeController controller = (ProdtypeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "prodtypeController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Prodtype) {
            	Prodtype o = (Prodtype) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Prodtype.class.getName());
            }
        }
    }    
	

}
