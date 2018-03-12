package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the admins database table.
 * 
 */
@Entity
@NamedQuery(name="Admins.findAll", query="SELECT a FROM Admins a")
public class Admins implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;

	private int acompanyid;

	private String amail;

	private String aname;

	private String apassword;

	private String aphone;

	private String apicpath;

	private String asurname;

	@Column(name="remember_me")
	private String rememberMe;

	public Admins() {
	}

	public int getAid() {
		return this.aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAcompanyid() {
		return this.acompanyid;
	}

	public void setAcompanyid(int acompanyid) {
		this.acompanyid = acompanyid;
	}

	public String getAmail() {
		return this.amail;
	}

	public void setAmail(String amail) {
		this.amail = amail;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApassword() {
		return this.apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public String getAphone() {
		return this.aphone;
	}

	public void setAphone(String aphone) {
		this.aphone = aphone;
	}

	public String getApicpath() {
		return this.apicpath;
	}

	public void setApicpath(String apicpath) {
		this.apicpath = apicpath;
	}

	public String getAsurname() {
		return this.asurname;
	}

	public void setAsurname(String asurname) {
		this.asurname = asurname;
	}

	public String getRememberMe() {
		return this.rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

}