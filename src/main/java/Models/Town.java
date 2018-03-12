package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the town database table.
 * 
 */
@Entity
@NamedQuery(name="Town.findAll", query="SELECT t FROM Town t")
public class Town implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int townid;

	private int towncityid;

	private int townkey;

	private String towntitle;

	public Town() {
	}

	public int getTownid() {
		return this.townid;
	}

	public void setTownid(int townid) {
		this.townid = townid;
	}

	public int getTowncityid() {
		return this.towncityid;
	}

	public void setTowncityid(int towncityid) {
		this.towncityid = towncityid;
	}

	public int getTownkey() {
		return this.townkey;
	}

	public void setTownkey(int townkey) {
		this.townkey = townkey;
	}

	public String getTowntitle() {
		return this.towntitle;
	}

	public void setTowntitle(String towntitle) {
		this.towntitle = towntitle;
	}

}