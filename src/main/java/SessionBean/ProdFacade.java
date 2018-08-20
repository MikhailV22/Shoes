package SessionBean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import model.Prod;
import model.SearchResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;

import JSF.SearchParam;




@Stateless
public class ProdFacade extends AbstractFacade<Prod> {
	@EJB
	private WarehouseFacade warehouseFacade;

	@EJB
	private ColorFacade colorFacade;
	
	@PersistenceContext(unitName = "shoesPU")
    private EntityManager em;

	@Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public ProdFacade() {
		super(Prod.class);
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	SearchParam searchParam;

	public void clear() {
		getEntityManager().clear();
	}

	public void detach(Object e) {
		getEntityManager().detach(e);
	}
	
	@Override
	public Prod find(Object id){
		Prod p = super.find(id);
//    	Hibernate.initialize(p.getSizes());
//    	Hibernate.initialize(p.getColors());

		p.getPictures().size();
//		p.getSizes().size();
//		p.getColors().size();

//		getEntityManager().detach(p);
//		getEntityManager().detach(p.getColors());
//		getEntityManager().clear();
		
		return p;
	}
	
	@Override
	public List<Prod>findAll(){
		List<Prod> list = getEntityManager()
				.createQuery("SELECT p "
						+ "from Prod p "
						+ " left join fetch p.pictures pic "
//						+ " left join fetch p.sizes s "
//						+ " left join fetch p.colors c "
						,Prod.class)
				.getResultList();
		for(Prod p:list) {
			p.getSizes().size();
			p.getColors().size();
//			p.setColors(colorFacade.findAll());
//			System.out.printf("Sizes %s    %s",p.getId(), p.getSizes().size());
//			System.out.println("");
//			System.out.printf("Colors %s    %s",p.getId(), p.getColors().size());
//			System.out.println("");
		}
		return list;
	}
	
//	@Override
//    public List<Prod> findAll() {
////		System.out.println("searchParam.getSelectedTrademarks()."+searchParam.getProdtypesAsList());
//		
////        return getEntityManager().createNativeQuery("select * from prod",Prod.class).getResultList();
//		String sqlProdType=searchParam.getProdtypesAsList();
//		if (!searchParam.getProdtypesAsList().equals("")) {
//			sqlProdType = " AND PRODTYPE_ID IN ("+sqlProdType+")";
//		}
//		
//		String sqlGender=searchParam.getGendersAsList();
//		if (!sqlGender.equals("")) {
//			sqlGender = " AND GENDER_ID IN ("+sqlGender+")";
//		}
//		
//		String sqlMedicaltype=searchParam.getMedicaltypeAsList();
//		if (!sqlMedicaltype.equals("")) {
//			sqlMedicaltype = " AND MEDICALTYPE_ID IN ("+sqlMedicaltype+")";
//		}
//		
//		String sqlSeason=searchParam.getSeasonAsList();
//		if (!sqlSeason.equals("")) {
//			sqlSeason = " AND SEASON_ID IN ("+sqlSeason+")";
//		}
//		
//		System.out.println("sqlSeason."+sqlSeason);
//		List<Prod> list = getEntityManager().createNativeQuery("SELECT \r\n" + 
//        		"P.ID, NAME, CODE, \r\n" + 
//        		"   P.CREATEDATE, P.UPDATEDATE, "+
//        	    "P.TRADEMARK_ID, \r\n" + 
//        		"   COLLECTION_ID, PRODTYPE_ID, MEDICALTYPE_ID, \r\n" + 
//        		"   COMMENTARY, SEASON_ID, GENDER_ID, \r\n" + 
//        		"   DESCR,\r\n" + 
//        		"   10 AMOUNT\r\n" + 
//        		" FROM PROD P "+
//        		" WHERE 1=1 "
//        		+sqlProdType
//        		+sqlGender
//        		+sqlMedicaltype
//        		+sqlSeason
//        		,Prod.class).getResultList();
//		System.out.println("--1--");
//		for(Prod p:list) {
//			p.setWarehouse(warehouseFacade.findByWhouseId(p.getId(), Long.parseLong("1")));
//			System.out.printf("%s    %s",p.getId(), Long.parseLong("1"));
//			System.out.println("");
//		}
//		System.out.println("--2--");
//		return list;
//    }

}
