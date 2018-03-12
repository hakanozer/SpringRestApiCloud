package Models;

import java.io.Serializable;
import javax.persistence.*;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;

=======
>>>>>>> 2f476fb85f7ae94701fc8fa3947a155931dcad2a

/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
<<<<<<< HEAD
	private Integer customerid;

	private Integer customercompanyid;
=======
	private int customerid;

	private int customercompanyid;
>>>>>>> 2f476fb85f7ae94701fc8fa3947a155931dcad2a

	private String customermail;

	private String customername;

<<<<<<< HEAD
	@JsonIgnore
=======
>>>>>>> 2f476fb85f7ae94701fc8fa3947a155931dcad2a
	private String customerpassword;

	private String customerphone;

	private String customersurname;

	public Customer() {
	}

<<<<<<< HEAD

	public Integer getCustomercompanyid() {
		return this.customercompanyid;
	}

	public void setCustomercompanyid(Integer customercompanyid) {
		this.customercompanyid = customercompanyid;
	}

	public Integer getCustomerid() {
		return customerid;
	}


	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}


=======
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

>>>>>>> 2f476fb85f7ae94701fc8fa3947a155931dcad2a
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