package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the campaigns database table.
 * 
 */
@Entity
@NamedQuery(name="Campaigns.findAll", query="SELECT c FROM Campaigns c")
public class Campaigns implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int campaignid;

	private int campaigncompanyid;

	private String campaigndetail;

	@Temporal(TemporalType.DATE)
	private Date campaignenddate;

	@Temporal(TemporalType.DATE)
	private Date campaignstartdate;

	private byte campaignstatu;

	private String campaigntitle;

	private int campaigntolerance;

	public Campaigns() {
	}

	public int getCampaignid() {
		return this.campaignid;
	}

	public void setCampaignid(int campaignid) {
		this.campaignid = campaignid;
	}

	public int getCampaigncompanyid() {
		return this.campaigncompanyid;
	}

	public void setCampaigncompanyid(int campaigncompanyid) {
		this.campaigncompanyid = campaigncompanyid;
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

}