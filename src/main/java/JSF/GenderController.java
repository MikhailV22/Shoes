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
import SessionBean.GenderFacade;
import model.Gender;


import java.util.List;

@Named("genderController")
@SessionScoped
public class GenderController   implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Gender> items;

	@EJB
    private GenderFacade ejbFacade;	

    public GenderFacade getFacade() {
        return ejbFacade;
    }

    
    
    public List<Gender> getItems() {
    	if(items==null) {
    		items = getFacade().findAll();
    	}
		return items;
	}



	public void setItems(List<Gender> items) {
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

    
    public static SelectItem[] getSelectItems(List<Gender> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Gender x : entities) {
            items[i++] = new SelectItem(x.getId(), x.getName());
        }
        return items;
    }	

    @FacesConverter(forClass = Gender.class)
    public static class GenderControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GenderController controller = (GenderController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "genderController");
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
            if (object instanceof Gender) {
            	Gender o = (Gender) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Gender.class.getName());
            }
        }
    }    
	

}
