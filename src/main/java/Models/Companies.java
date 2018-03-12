package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@NamedQuery(name="Companies.findAll", query="SELECT c FROM Companies c")
public class Companies implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyid;

	private int companyadressid;

	private String companyapikey;

	private String companyfax;

	private String companymail;

	private String companyname;

	private String companyphone;

	public Companies() {
	}

	public int getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public int getCompanyadressid() {
		return this.companyadressid;
	}

	public void setCompanyadressid(int companyadressid) {
		this.companyadressid = companyadressid;
	}

	public String getCompanyapikey() {
		return this.companyapikey;
	}

	public void setCompanyapikey(String companyapikey) {
		this.companyapikey = companyapikey;
	}

	public String getCompanyfax() {
		return this.companyfax;
	}

	public void setCompanyfax(String companyfax) {
		this.companyfax = companyfax;
	}

	public String getCompanymail() {
		return this.companymail;
	}

	public void setCompanymail(String companymail) {
		this.companymail = companymail;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyphone() {
		return this.companyphone;
	}

	public void setCompanyphone(String companyphone) {
		this.companyphone = companyphone;
	}

}