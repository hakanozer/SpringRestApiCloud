package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@NamedQuery(name="Products.findAll", query="SELECT p FROM Products p")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productid;

	private int productadressesid;

	private int productcampaignid;

	private String productcategoryid;

	

	private int productcompanyid;

	private String productdescription;

	private String productdetail;

	private String productlatitude;

	private String productlongtitude;

	private String productmap;

	private BigDecimal productprice;

	private String producttitle;

	private String producttype;

	public Products() {
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getProductadressesid() {
		return this.productadressesid;
	}

	public void setProductadressesid(int productadressesid) {
		this.productadressesid = productadressesid;
	}

	public int getProductcampaignid() {
		return this.productcampaignid;
	}

	public void setProductcampaignid(int productcampaignid) {
		this.productcampaignid = productcampaignid;
	}

	

	public int getProductcompanyid() {
		return this.productcompanyid;
	}

	public void setProductcompanyid(int productcompanyid) {
		this.productcompanyid = productcompanyid;
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

	public String getProductlatitude() {
		return this.productlatitude;
	}

	public void setProductlatitude(String productlatitude) {
		this.productlatitude = productlatitude;
	}

	public String getProductlongtitude() {
		return this.productlongtitude;
	}

	public void setProductlongtitude(String productlongtitude) {
		this.productlongtitude = productlongtitude;
	}

	public String getProductmap() {
		return this.productmap;
	}

	public void setProductmap(String productmap) {
		this.productmap = productmap;
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
	
	public String getProductcategoryid() {
		return productcategoryid;
	}

	public void setProductcategoryid(String productcategoryid) {
		this.productcategoryid = productcategoryid;
	}

}