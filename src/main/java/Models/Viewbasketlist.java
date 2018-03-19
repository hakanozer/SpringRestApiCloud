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
@NamedQuery(name="Viewbasketlist.findAll", query="SELECT v FROM Viewbasketlist v")
public class Viewbasketlist implements Serializable {
	private static final long serialVersionUID = 1L;

	private int basketcustomerid;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int basketid;

	private int basketproductcount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date campaignenddate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date campaignstartdate;

	private byte campaignstatu;

	private String campaigntitle;

	private int campaigntolerance;

	private String categorytitle;

	private String productdetail;

	private int productid;

	private BigDecimal productprice;

	private String producttitle;

	public Viewbasketlist() {
	}

	public int getBasketcustomerid() {
		return this.basketcustomerid;
	}

	public void setBasketcustomerid(int basketcustomerid) {
		this.basketcustomerid = basketcustomerid;
	}

	public int getBasketid() {
		return this.basketid;
	}

	public void setBasketid(int basketid) {
		this.basketid = basketid;
	}

	public int getBasketproductcount() {
		return this.basketproductcount;
	}

	public void setBasketproductcount(int basketproductcount) {
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

	public byte getCampaignstatu() {
		return this.campaignstatu;
	}

	public void setCampaignstatu(byte campaignstatu) {
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