package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customers.findAll", query="SELECT c FROM Customers c")
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerid;

	private int customercompanyid;

	private String customermail;

	private String customername;

	private String customerpassword;

	private String customerphone;

	private String customersurname;

	public Customers() {
	}

	public int getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getCustomercompanyid() {
		return this.customercompanyid;
	}

	public void setCustomercompanyid(int customercompanyid) {
		this.customercompanyid = customercompanyid;
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