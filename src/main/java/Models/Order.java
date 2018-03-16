package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderid;

	private int ordercompanyid;

	private String ordercounts;

	private int ordercustomerid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;

	private String orderproductids;

	private byte orderstatus;

	private BigDecimal ordertotalprice;

	public Order() {
	}

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

	public String getOrderproductids() {
		return this.orderproductids;
	}

	public void setOrderproductids(String orderproductids) {
		this.orderproductids = orderproductids;
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

}