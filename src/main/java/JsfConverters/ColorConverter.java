package JsfConverters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import SessionBean.ColorFacade;
import model.Color;

@Named("colorConverter")
@RequestScoped
public final class ColorConverter implements Converter {

    @EJB
    private ColorFacade service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//    	System.out.println("value."+value);
        try {
            long parsedValue = Long.parseLong(value);
            
            if (parsedValue == 0) {
                return null;
            }
            if (parsedValue < 0) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message Summary parsedValue < 0", "Message"));
            }

            Color entity = service.find(parsedValue);
            if (entity == null) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_WARN, "Message Summary entity == null", "Message"));
            }

//        	System.out.println("entity."+entity.getName());
//        	System.out.println("entityClass."+entity.getClass().getName() );
            return entity;
//            return parsedValue;
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message Summary NumberFormatException", "Message"), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
//    	System.out.println("getAsString."+value.getClass().getName());
    	
        //return value instanceof Long ? value.toString() : "0";
        return value instanceof Color ? ((Color) value).getId().toString() : "0";
    }
}