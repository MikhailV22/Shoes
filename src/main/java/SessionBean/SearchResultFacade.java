package SessionBean;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import model.Prod;
import model.SearchResult;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import JSF.SearchParam;

/**
 * Session Bean implementation class ProdtypeFacade
 */
@Stateless
public class SearchResultFacade extends AbstractFacade< SearchResult> {
	@EJB
	private WarehouseFacade warehouseFacade;

	@EJB
	private ColorFacade colorFacade;

	@EJB
	private ProdPictureFacade prodPictureFacade;
	
	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public SearchResultFacade() {
		super(SearchResult.class);
		// TODO Auto-generated constructor stub
	}
    
	@Inject
	SearchParam searchParam;
    
	@Override
    public List<SearchResult> findAll() {
//		System.out.println("searchParam.getSelectedTrademarks()."+searchParam.getProdtypesAsList());
		
//        return getEntityManager().createNativeQuery("select * from prod",Prod.class).getResultList();
		String sqlProdType=searchParam.getProdtypesAsList();
		if (!searchParam.getProdtypesAsList().equals("")) {
			sqlProdType = " AND PRODTYPE_ID IN ("+sqlProdType+")";
		}
		
		String sqlGender=searchParam.getGendersAsList();
		if (!sqlGender.equals("")) {
			sqlGender = " AND GENDER_ID IN ("+sqlGender+")";
		}
		
		String sqlMedicaltype=searchParam.getMedicaltypeAsList();
		if (!sqlMedicaltype.equals("")) {
			sqlMedicaltype = " AND MEDICALTYPE_ID IN ("+sqlMedicaltype+")";
		}
		
		String sqlSeason=searchParam.getSeasonAsList();
		if (!sqlSeason.equals("")) {
			sqlSeason = " AND SEASON_ID IN ("+sqlSeason+")";
		}
		
		String sqlSizes=searchParam.getListAsString(searchParam.getSelectedSizes());
		if (!sqlSizes.equals("")) {
			sqlSizes = " AND P.ID IN (SELECT PROD_ID FROM PROD_SIZES WHERE SIZE_ID IN("+sqlSizes+"))";
		}

		String sqlColors=searchParam.getListAsString(searchParam.getSelectedColors());
		if (!sqlColors.equals("")) {
			sqlColors = " AND P.ID IN (SELECT PROD_ID FROM PROD_COLORS WHERE COLOR_ID IN("+sqlColors+"))";
		}
		
//		System.out.println("sqlColors."+searchParam.getListAsString(searchParam.getSelectedColors()));
//		System.out.println("sqlColors."+sqlColors);
		List<SearchResult> list = getEntityManager().createNativeQuery("SELECT \r\n" + 
        		"P.ID,  \r\n" + 
        	    "P.ID  PROD_ID, \r\n" + 
        		"   1 WHOUSE_ID, 1 SIZE_ID, \r\n" + 
        		"   '1' USER_ID, \r\n" + 
        		"   p_price.getPrice(P.ID,'BASE') PRICE, \r\n" + 
        		"   1 AMOUNT  \r\n" + 
        		" FROM PROD P "+
        		" LEFT JOIN "+
        		" (select prod_id, count(*)cnt from WAREHOUSE WH group by prod_id) cnt on p.id=cnt.prod_id "+
        		" WHERE 1=1 "
        		+sqlProdType
        		+sqlGender
        		+sqlMedicaltype
        		+sqlSeason
        		+sqlSizes
        		+sqlColors
        		+" ORDER BY CNT "
        		,SearchResult.class).getResultList();
		for(SearchResult p:list) {
			p.getProd().setWarehouse(warehouseFacade.findByWhouseId(p.getProd().getId(), Long.parseLong("1")));
			p.getProd().setColors(colorFacade.findByProd(p.getProd().getId()));
			p.getProd().setPictures(prodPictureFacade.findByProd(p.getProd().getId()));
			
//			System.out.printf("%s    %s",p.getProd().getId(), Long.parseLong("1"));
//			System.out.println("");
		}
		return list;
    }
    

}


