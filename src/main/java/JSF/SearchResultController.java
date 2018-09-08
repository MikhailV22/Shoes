

package JSF;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import Interceprots.MyLogger;
import JSF.util.JsfUtil;
import SessionBean.SearchResultFacade;
import model.SearchResult;
import model.Prodtype;
import model.Season;
import model.Trademark;
import model.Gender;
import model.Medicaltype;

import java.util.List;



@Named("searchResultController")
@RequestScoped
public class SearchResultController  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<SearchResult> items;
	
	private SearchResult current;
	
	
	public SearchResult getCurrent() {
		if(current==null) {
			current = new SearchResult();
		}
		return current;
	}

	public void setCurrent(SearchResult current) {
		this.current = current;
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
    private SessionBean.SearchResultFacade ejbFacade;	

    private SearchResultFacade getFacade() {
        return ejbFacade;
    }

    
    
    public void find() {
    	
    	items = null;
    }
    
    public List<SearchResult> getItems() {
    	if(items==null) {
    		items=getFacade().findAll();
    	}
		return items;
	}

	public void setItems(List<SearchResult> items) {
		this.items = items;
	}

}
