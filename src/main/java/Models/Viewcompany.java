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
	private Integer companyid;

	public Integer getCompanyid() {
		return companyid;
	}




	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	private String companyname;

	public Viewcompany() {
	}


	

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

}