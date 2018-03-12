package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the view_companies_adress database table.
 * 
 */
@Entity
@Table(name="view_companies_adress")
@NamedQuery(name="ViewCompaniesAdress.findAll", query="SELECT v FROM ViewCompaniesAdress v")
public class ViewCompaniesAdress implements Serializable {
	private static final long serialVersionUID = 1L;

	private String adressdescription;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adressid;

	private String adresstitle;

	private String citytitle;

	private int companyid;

	private String neighborhoodtitle;

	private String streettitle;

	private String towntitle;

	public ViewCompaniesAdress() {
	}

	public String getAdressdescription() {
		return this.adressdescription;
	}

	public void setAdressdescription(String adressdescription) {
		this.adressdescription = adressdescription;
	}

	public int getAdressid() {
		return this.adressid;
	}

	public void setAdressid(int adressid) {
		this.adressid = adressid;
	}

	public String getAdresstitle() {
		return this.adresstitle;
	}

	public void setAdresstitle(String adresstitle) {
		this.adresstitle = adresstitle;
	}

	public String getCitytitle() {
		return this.citytitle;
	}

	public void setCitytitle(String citytitle) {
		this.citytitle = citytitle;
	}

	public int getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public String getNeighborhoodtitle() {
		return this.neighborhoodtitle;
	}

	public void setNeighborhoodtitle(String neighborhoodtitle) {
		this.neighborhoodtitle = neighborhoodtitle;
	}

	public String getStreettitle() {
		return this.streettitle;
	}

	public void setStreettitle(String streettitle) {
		this.streettitle = streettitle;
	}

	public String getTowntitle() {
		return this.towntitle;
	}

	public void setTowntitle(String towntitle) {
		this.towntitle = towntitle;
	}

}