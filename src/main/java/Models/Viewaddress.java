package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viewaddress database table.
 * 
 */
@Entity
@NamedQuery(name="Viewaddress.findAll", query="SELECT v FROM Viewaddress v")
public class Viewaddress implements Serializable {
	private static final long serialVersionUID = 1L;

	private String adressdescription;

	@Id
	private int adressid;

	private String adressinformation;

	private String adresstitle;

	private int cityid;

	private String citytitle;

	private int customerid;

	private String customername;

	private String customersurname;

	private int neighborhoodid;

	private String neighborhoodtitle;

	private int streetid;

	private String streettitle;

	private int townid;

	private String towntitle;

	public Viewaddress() {
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

	public String getAdressinformation() {
		return this.adressinformation;
	}

	public void setAdressinformation(String adressinformation) {
		this.adressinformation = adressinformation;
	}

	public String getAdresstitle() {
		return this.adresstitle;
	}

	public void setAdresstitle(String adresstitle) {
		this.adresstitle = adresstitle;
	}

	public int getCityid() {
		return this.cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCitytitle() {
		return this.citytitle;
	}

	public void setCitytitle(String citytitle) {
		this.citytitle = citytitle;
	}

	public int getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomersurname() {
		return this.customersurname;
	}

	public void setCustomersurname(String customersurname) {
		this.customersurname = customersurname;
	}

	public int getNeighborhoodid() {
		return this.neighborhoodid;
	}

	public void setNeighborhoodid(int neighborhoodid) {
		this.neighborhoodid = neighborhoodid;
	}

	public String getNeighborhoodtitle() {
		return this.neighborhoodtitle;
	}

	public void setNeighborhoodtitle(String neighborhoodtitle) {
		this.neighborhoodtitle = neighborhoodtitle;
	}

	public int getStreetid() {
		return this.streetid;
	}

	public void setStreetid(int streetid) {
		this.streetid = streetid;
	}

	public String getStreettitle() {
		return this.streettitle;
	}

	public void setStreettitle(String streettitle) {
		this.streettitle = streettitle;
	}

	public int getTownid() {
		return this.townid;
	}

	public void setTownid(int townid) {
		this.townid = townid;
	}

	public String getTowntitle() {
		return this.towntitle;
	}

	public void setTowntitle(String towntitle) {
		this.towntitle = towntitle;
	}

}