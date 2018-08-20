package JSF;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.List;



@Named("searchParam")
@SessionScoped
public class SearchParam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<String> selectedProdtypes;
	private List<String> selectedGenders;
	private List<String> selectedMedicaltype;
	private List<String> selectedSeason;
	private List<String> selectedSizes;
	private List<String> selectedColors;
	
	
	
	



	public List<String> getSelectedProdtypes() {
		return selectedProdtypes;
	}

	public void setSelectedProdtypes(List<String> selectedProdtypes) {
		this.selectedProdtypes = selectedProdtypes;
	}

	public List<String> getSelectedGenders() {
		return selectedGenders;
	}

	public void setSelectedGenders(List<String> selectedGenders) {
		this.selectedGenders = selectedGenders;
	}

	public List<String> getSelectedMedicaltype() {
		return selectedMedicaltype;
	}

	public void setSelectedMedicaltype(List<String> selectedMedicaltype) {
		this.selectedMedicaltype = selectedMedicaltype;
	}

	public List<String> getSelectedSeason() {
		return selectedSeason;
	}

	public void setSelectedSeason(List<String> selectedSeason) {
		this.selectedSeason = selectedSeason;
	}

	public List<String> getSelectedSizes() {
		return selectedSizes;
	}

	public void setSelectedSizes(List<String> selectedSizes) {
		this.selectedSizes = selectedSizes;
	}

	public List<String> getSelectedColors() {
		return selectedColors;
	}

	public void setSelectedColors(List<String> selectedColors) {
		this.selectedColors = selectedColors;
	}

	String str="";
	public String getListAsString(List<String> list) {
		str = "";
		if (list==null) {
			return "";
		}
		list.stream()
			.forEach(
					(item)->{str +=','+item;}
					);
		return str.replaceFirst(",","");
	}

	public String getProdtypesAsList() {
		return getListAsString(getSelectedProdtypes());
	}
	
	public String getGendersAsList() {
		return getListAsString(getSelectedGenders());
	}
	
	public String getMedicaltypeAsList() {
		return getListAsString(getSelectedMedicaltype());
	}

	public String getSeasonAsList() {
		return getListAsString(getSelectedSeason());
	}

}
