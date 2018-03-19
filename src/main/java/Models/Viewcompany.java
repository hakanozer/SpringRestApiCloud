package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the viewcompany database table.
 * 
 */
@Entity
@NamedQuery(name="Viewcompany.findAll", query="SELECT v FROM Viewcompany v")
public class Viewcompany implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyid;

	private String companyname;

	public Viewcompany() {
	}

	public int getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

}