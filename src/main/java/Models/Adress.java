package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the adress database table.
 * 
 */
@Entity
@NamedQuery(name="Adress.findAll", query="SELECT a FROM Adress a")
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adressid;

	private int adresscityid;

	private int adresscompaniesid;

	private int adresscustomerid;

	private String adressdescription;

	private String adressinformation;

	private int adressneighborhoodid;

	private int adressstreetid;

	private String adresstitle;

	private int adresstownid;

	public Adress() {
	}

	public int getAdressid() {
		return this.adressid;
	}

	public void setAdressid(int adressid) {
		this.adressid = adressid;
	}

	public int getAdresscityid() {
		return this.adresscityid;
	}

	public void setAdresscityid(int adresscityid) {
		this.adresscityid = adresscityid;
	}

	public int getAdresscompaniesid() {
		return this.adresscompaniesid;
	}

	public void setAdresscompaniesid(int adresscompaniesid) {
		this.adresscompaniesid = adresscompaniesid;
	}

	public int getAdresscustomerid() {
		return this.adresscustomerid;
	}

	public void setAdresscustomerid(int adresscustomerid) {
		this.adresscustomerid = adresscustomerid;
	}

	public String getAdressdescription() {
		return this.adressdescription;
	}

	public void setAdressdescription(String adressdescription) {
		this.adressdescription = adressdescription;
	}

	public String getAdressinformation() {
		return this.adressinformation;
	}

	public void setAdressinformation(String adressinformation) {
		this.adressinformation = adressinformation;
	}

	public int getAdressneighborhoodid() {
		return this.adressneighborhoodid;
	}

	public void setAdressneighborhoodid(int adressneighborhoodid) {
		this.adressneighborhoodid = adressneighborhoodid;
	}

	public int getAdressstreetid() {
		return this.adressstreetid;
	}

	public void setAdressstreetid(int adressstreetid) {
		this.adressstreetid = adressstreetid;
	}

	public String getAdresstitle() {
		return this.adresstitle;
	}

	public void setAdresstitle(String adresstitle) {
		this.adresstitle = adresstitle;
	}

	public int getAdresstownid() {
		return this.adresstownid;
	}

	public void setAdresstownid(int adresstownid) {
		this.adresstownid = adresstownid;
	}

}