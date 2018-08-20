package JSF;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import org.hibernate.Hibernate;

import Interceprots.MyLogger;
import JSF.util.JsfUtil;
import SessionBean.ColorFacade;
import SessionBean.ProdFacade;
import SessionBean.SizeFacade;
import model.Prod;
import model.Prodtype;
import model.Season;
import model.Sizes;
import model.Trademark;
import model.Color;
import model.Gender;
import model.Medicaltype;

import java.util.ArrayList;
import java.util.List;



@Named("prodController")
@SessionScoped
public class ProdController  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Prod> items;
	
	private Prod current;
	private int selectedSize;
	
	
	
	public int getSelectedSize() {
		return selectedSize;
	}

	public void setSelectedSize(int selectedSize) {
		this.selectedSize = selectedSize;
	}

	public Prod getCurrent() {
		if(current==null) {
			current = new Prod();
		}
		return current;
	}

	public void setCurrent(Prod current) {
		this.current = current;
	}

	private String test = "test string";
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Inject
	ProdtypeController prodtypeController;
	
	
	public ProdtypeController getProdtypeController() {
		return prodtypeController;
	}

	public void setProdtypeController(ProdtypeController prodtypeController) {
		this.prodtypeController = prodtypeController;
	}

	@Inject
	TrademarkController trademarkController;
	
	
	public TrademarkController getTrademarkController() {
		return trademarkController;
	}

	public void setTrademarkController(TrademarkController trademarkController) {
		this.trademarkController = trademarkController;
	}

	@EJB
    private SessionBean.ProdFacade ejbFacade;	

    private ProdFacade getFacade() {
        return ejbFacade;
    }

//    @Interceptors( MyLogger.class )
//    public List<Prod> getAll(){
//    	System.out.println("----------------------getAll------------------");
//    	return getFacade().findAll();
//    }
    
    
    
    public void refreshList() {
		items=getFacade().findAll();
    }    
    
    public List<Prod> getItems() {
    	if(items==null) {
    		items=getFacade().findAll();
    	}
		return items;
	}

	public void setItems(List<Prod> items) {
		this.items = items;
	}

	public String prepareAdd() {
    	current = null;
    	
        if (getCurrent().getTrademark()== null){
        	getCurrent().setTrademark(new Trademark());
//        	getCurrent().setTrademark(getTrademarkController().getFacade().find((long) 1));
        }        
//    	getCurrent().setProdtype(new Prodtype());
//    	getCurrent().getProdtype().setId(Long.valueOf(2));
        if (getCurrent().getProdtype()== null){
        	getCurrent().setProdtype(new Prodtype());
//        	getCurrent().setProdtype(getProdtypeController().getFacade().find((long) 1));
        }        

        if (getCurrent().getGender()== null){
        	getCurrent().setGender(new Gender());
        }        
    	getCurrent().setMedicaltype(new Medicaltype());
    	getCurrent().setSeason(new Season());
    	
    	return "Create.xhtml";
    }
    
   
    public String add() {
    	try {
        	System.out.println("id."+getCurrent().getMedicaltype());
        	if(getCurrent().getMedicaltype().getId().longValue()==0) {
        		getCurrent().setMedicaltype(null);        	
        	}
//        	Trademark tm = new Trademark();
//        	tm.setId(1);
//        	tm.setName("Ortuzzi");
//        	getCurrent().setTrademark(tm);
        	if (getCurrent().getProdtype().getId()==null) {
    	        FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("mainForm:prodtype1",new FacesMessage("Укажите тип."));
                //JsfUtil.addErrorMessage("mainForm:summa","������� ��� ������.");
        		
        		return null;
        	}
        	getFacade().create(current);
        	items = null;
        	return "List.xhtml";
			
		} catch (Exception e) {
//	        FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка записи.","Ошибка записи."));
            JsfUtil.addErrorMessage("Ошибка записи.");
            
        	return "";

//            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
//            FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
		}
    }
    
    
    
    public String prepareEdit(Prod item) {
//    	item.getSizes();
//    	item.getColors();
//    	System.out.println("item.id="+item.getId());
//    	String path = System.getProperty("jboss.server.data.dir");
//    	System.out.println("path="+path);
    	
    	current = getFacade().find(item.getId());
    	current.setColors(colorFacade.findByProd(item.getId()));
    	current.setSizes(sizeFacade.findByProd(item.getId()));
//    	setSelectedColors(colorFacade.findAll());
    	
    	//setSelectedSizes(current.getSizes());
    	
//    	System.out.println("current.colors="+current.getColors().size());
//    	current.getSizes();
//    	current.getColors();

//    	setCurrent(item);
//    	current.getSizes().size();
//    	current.getColors().size();
    	
//    	if(getCurrent().getMedicaltype()==null) {
//        	getCurrent().setMedicaltype(new Medicaltype());
//    	}
    	return "Edit.xhtml";
    }

    public String Edit() {
//    	if(getCurrent().getMedicaltype().getId().longValue()==0) {
//    		getCurrent().setMedicaltype(null);        	
//    	}
    	System.out.println("colors."+current.getColors().size());
    	//current.setColors(getSelectedColors());
    	//current.setSizes(getSelectedSizes());
//    	getFacade().clear();
    	getFacade().edit(current);
    	items = null;
    	return "List.xhtml";
    }

    public String del(Prod item) {
    	try {
//        	System.out.println("id."+getCurrent().getId());
        	getFacade().remove(item);
        	items = null;
        	return "";
			
		} catch (Exception e) {
//	        FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ошибка записи.","Ошибка записи."));
            JsfUtil.addErrorMessage("Ошибка записи.");
            
        	return "";

//            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
//            FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
		}
    }

    public void addSize() {
//    	Sizes size = new Sizes();
//    	size.setProd(getCurrent());
//    	size.setName("size name");
//    	getCurrent().getSizes().add(size);
    	
    }
    
    @EJB
    private ColorFacade colorFacade;

    @EJB
    private SizeFacade sizeFacade;
    
//    public void addColor() {
//    	System.out.println("current.colors."+current.getColors().size());
//    	System.out.println("colors."+getSelectedColors().size());
//    	Color color = colorFacade.find(Long.valueOf(1));
//    	System.out.println("color."+color.getName());
//    	getCurrent().getColors().add(color);
//    	getFacade().edit(current);
//    }
    

//    private List<Color> selectedColors = new ArrayList<>();
//	public List<Color> getSelectedColors() {
//		return selectedColors;
//	}
//	public void setSelectedColors(List<Color> selectedColors) {
//		this.selectedColors = selectedColors;
//	}

    private List<Sizes> selectedSizes = new ArrayList<>();



	public List<Sizes> getSelectedSizes() {
		return selectedSizes;
	}

	public void setSelectedSizes(List<Sizes> selectedSizes) {
		this.selectedSizes = selectedSizes;
	}
    
    
}
