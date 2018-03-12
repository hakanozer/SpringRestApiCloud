package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the street database table.
 * 
 */
@Entity
@NamedQuery(name="Street.findAll", query="SELECT s FROM Street s")
public class Street implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int streetid;

	private int streetneighborhoodid;

	private String streettitle;

	public Street() {
	}

	public int getStreetid() {
		return this.streetid;
	}

	public void setStreetid(int streetid) {
		this.streetid = streetid;
	}

	public int getStreetneighborhoodid() {
		return this.streetneighborhoodid;
	}

	public void setStreetneighborhoodid(int streetneighborhoodid) {
		this.streetneighborhoodid = streetneighborhoodid;
	}

	public String getStreettitle() {
		return this.streettitle;
	}

	public void setStreettitle(String streettitle) {
		this.streettitle = streettitle;
	}

}