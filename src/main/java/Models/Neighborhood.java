package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the neighborhood database table.
 * 
 */
@Entity
@NamedQuery(name="Neighborhood.findAll", query="SELECT n FROM Neighborhood n")
public class Neighborhood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int neighborhoodid;

	private int neighborhoodkey;

	private String neighborhoodtitle;

	private int neighborhoodtownid;

	public Neighborhood() {
	}

	public int getNeighborhoodid() {
		return this.neighborhoodid;
	}

	public void setNeighborhoodid(int neighborhoodid) {
		this.neighborhoodid = neighborhoodid;
	}

	public int getNeighborhoodkey() {
		return this.neighborhoodkey;
	}

	public void setNeighborhoodkey(int neighborhoodkey) {
		this.neighborhoodkey = neighborhoodkey;
	}

	public String getNeighborhoodtitle() {
		return this.neighborhoodtitle;
	}

	public void setNeighborhoodtitle(String neighborhoodtitle) {
		this.neighborhoodtitle = neighborhoodtitle;
	}

	public int getNeighborhoodtownid() {
		return this.neighborhoodtownid;
	}

	public void setNeighborhoodtownid(int neighborhoodtownid) {
		this.neighborhoodtownid = neighborhoodtownid;
	}

}