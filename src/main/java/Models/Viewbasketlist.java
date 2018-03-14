package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the viewbasketlist database table.
 * 
 */
@Entity
@Table(name="viewbasketlist")
@NamedQuery(name="Viewbasketlist.findAll", query="SELECT v FROM Viewbasketlist v")
public class Viewbasketlist implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer basketcustomerid;
	@Id
	private Integer basketid;

	private Integer basketproductcount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date campaignenddate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date campaignstartdate;

	private Byte campaignstatu;

	private String campaigntitle;

	private Integer campaigntolerance;

	private String categorytitle;

	private String productdetail;

	private Integer productid;

	private BigDecimal productprice;

	private String producttitle;

	public Viewbasketlist() {
	}

	public Integer getBasketcustomerid() {
		return this.basketcustomerid;
	}

	public void setBasketcustomerid(Integer basketcustomerid) {
		this.basketcustomerid = basketcustomerid;
	}

	public Integer getBasketid() {
		return this.basketid;
	}

	public void setBasketid(Integer basketid) {
		this.basketid = basketid;
	}

	public Integer getBasketproductcount() {
		return this.basketproductcount;
	}

	public void setBasketproductcount(Integer basketproductcount) {
		this.basketproductcount = basketproductcount;
	}

	public Date getCampaignenddate() {
		return this.campaignenddate;
	}

	public void setCampaignenddate(Date campaignenddate) {
		this.campaignenddate = campaignenddate;
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

	public Integer getCampaigntolerance() {
		return this.campaigntolerance;
	}

	public void setCampaigntolerance(Integer campaigntolerance) {
		this.campaigntolerance = campaigntolerance;
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

	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
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