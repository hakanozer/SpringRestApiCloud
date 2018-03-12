package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the vieworderlist database table.
 * 
 */
@Entity
@NamedQuery(name="Vieworderlist.findAll", query="SELECT v FROM Vieworderlist v")
public class Vieworderlist implements Serializable {
	private static final long serialVersionUID = 1L;

	private String companyname;

	private String customername;

	private Integer ordercompanyid;

	private String ordercounts;

	private Integer ordercustomerid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
@Id
	private int orderid;

	private byte orderstatus;

	private BigDecimal ordertotalprice;

	private String productdetail;

	private String producttitle;

	public Vieworderlist() {
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public int getOrdercompanyid() {
		return this.ordercompanyid;
	}

	public void setOrdercompanyid(int ordercompanyid) {
		this.ordercompanyid = ordercompanyid;
	}

	public String getOrdercounts() {
		return this.ordercounts;
	}

	public void setOrdercounts(String ordercounts) {
		this.ordercounts = ordercounts;
	}

	public int getOrdercustomerid() {
		return this.ordercustomerid;
	}

	public void setOrdercustomerid(int ordercustomerid) {
		this.ordercustomerid = ordercustomerid;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public byte getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(byte orderstatus) {
		this.orderstatus = orderstatus;
	}

	public BigDecimal getOrdertotalprice() {
		return this.ordertotalprice;
	}

	public void setOrdertotalprice(BigDecimal ordertotalprice) {
		this.ordertotalprice = ordertotalprice;
	}

	public String getProductdetail() {
		return this.productdetail;
	}

	public void setProductdetail(String productdetail) {
		this.productdetail = productdetail;
	}

	public String getProducttitle() {
		return this.producttitle;
	}

	public void setProducttitle(String producttitle) {
		this.producttitle = producttitle;
	}

}