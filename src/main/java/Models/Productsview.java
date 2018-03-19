package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the productsview database table.
 * 
 */
@Entity
@NamedQuery(name="Productsview.findAll", query="SELECT p FROM Productsview p")
public class Productsview implements Serializable {
	private static final long serialVersionUID = 1L;

	private String campaigntitle;

	private String categorytitle;

	private String companyname;

	private String productdescription;

	private String productdetail;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productid;

	private BigDecimal productprice;

	private String producttitle;

	private String producttype;

	public Productsview() {
	}

	public String getCampaigntitle() {
		return this.campaigntitle;
	}

	public void setCampaigntitle(String campaigntitle) {
		this.campaigntitle = campaigntitle;
	}

	public String getCategorytitle() {
		return this.categorytitle;
	}

	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getProductdescription() {
		return this.productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductdetail() {
		return this.productdetail;
	}

	public void setProductdetail(String productdetail) {
		this.productdetail = productdetail;
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public BigDecimal getProductprice() {
		return this.productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	public String getProducttitle() {
		return this.producttitle;
	}

	public void setProducttitle(String producttitle) {
		this.producttitle = producttitle;
	}

	public String getProducttype() {
		return this.producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

}