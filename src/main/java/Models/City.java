package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cityid;

	private int citykey;

	private String citytitle;

	public City() {
	}

	public int getCityid() {
		return this.cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getCitykey() {
		return this.citykey;
	}

	public void setCitykey(int citykey) {
		this.citykey = citykey;
	}

	public String getCitytitle() {
		return this.citytitle;
	}

	public void setCitytitle(String citytitle) {
		this.citytitle = citytitle;
	}

}