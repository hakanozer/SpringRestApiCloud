package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the viewproductlist database table.
 * 
 */
@Entity
@Table(name="viewproductlist")
@NamedQuery(name="Viewproductlist.findAll", query="SELECT v FROM Viewproductlist v")
public class Viewproductlist implements Serializable {
	private static final long serialVersionUID = 1L;

	private String campaigndetail;

	@Temporal(TemporalType.TIMESTAMP)
	private Date campaignenddate;

	private Integer campaignid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date campaignstartdate;

	private Byte campaignstatu;

	private String campaigntitle;

	private Integer campaigntolerance;

	private int categoryid;

	private String categorytitle;

	private String productdetail;
	@Id
	private int productid;

	private BigDecimal productprice;

	private String producttitle;
	
	public Viewproductlist() {
	}

	public String getCampaigndetail() {
		return this.campaigndetail;
	}

	public void setCampaigndetail(String campaigndetail) {
		this.campaigndetail = campaigndetail;
	}

	public Date getCampaignenddate() {
		return this.campaignenddate;
	}

	public void setCampaignenddate(Date campaignenddate) {
		this.campaignenddate = campaignenddate;
	}

	public int getCampaignid() {
		return this.campaignid;
	}

	public void setCampaignid(int campaignid) {
		this.campaignid = campaignid;
	}

	public Date getCampaignstartdate() {
		return this.campaignstartdate;
	}

	public void setCampaignstartdate(Date campaignstartdate) {
		this.campaignstartdate = campaignstartdate;
	}

	public Byte getCampaignstatu() {
		return this.campaignstatu;
	}

	public void setCampaignstatu(Byte campaignstatu) {
		this.campaignstatu = campaignstatu;
	}

	public String getCampaigntitle() {
		return this.campaigntitle;
	}

	public void setCampaigntitle(String campaigntitle) {
		this.campaigntitle = campaigntitle;
	}

	public int getCampaigntolerance() {
		return this.campaigntolerance;
	}

	public void setCampaigntolerance(int campaigntolerance) {
		this.campaigntolerance = campaigntolerance;
	}

	public int getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategorytitle() {
		return this.categorytitle;
	}

	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
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

}