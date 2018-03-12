package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the sample database table.
 * 
 */
@Entity
@NamedQuery(name="Sample.findAll", query="SELECT s FROM Sample s")
public class Sample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;

	private String sdesc;

	private BigDecimal ssprice;

	private String stitle;

	public Sample() {
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSdesc() {
		return this.sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public BigDecimal getSsprice() {
		return this.ssprice;
	}

	public void setSsprice(BigDecimal ssprice) {
		this.ssprice = ssprice;
	}

	public String getStitle() {
		return this.stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

}