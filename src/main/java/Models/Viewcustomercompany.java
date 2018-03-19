package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viewcustomercompany database table.
 * 
 */
@Entity
@NamedQuery(name="Viewcustomercompany.findAll", query="SELECT v FROM Viewcustomercompany v")
public class Viewcustomercompany implements Serializable {
	private static final long serialVersionUID = 1L;

	private int companyadressid;

	private String companyapikey;

	private String companyfax;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyid;

	private String companymail;

	private String companyname;

	private String companyphone;

	private int customercompanyid;

	private int customerid;

	private String customermail;

	private String customername;

	private String customerpassword;

	private String customerphone;

	private String customersurname;

	public Viewcustomercompany() {
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

	public int getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
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

	public int getCustomercompanyid() {
		return this.customercompanyid;
	}

	public void setCustomercompanyid(int customercompanyid) {
		this.customercompanyid = customercompanyid;
	}

	public int getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomermail() {
		return this.customermail;
	}

	public void setCustomermail(String customermail) {
		this.customermail = customermail;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerpassword() {
		return this.customerpassword;
	}

	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}

	public String getCustomerphone() {
		return this.customerphone;
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	public String getCustomersurname() {
		return this.customersurname;
	}

	public void setCustomersurname(String customersurname) {
		this.customersurname = customersurname;
	}

}