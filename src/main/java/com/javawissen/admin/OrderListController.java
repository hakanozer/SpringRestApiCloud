package com.javawissen.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Models.Orders;
import Models.Vieworderlist;
import Models.Viewproductlist;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class OrderListController {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	int customerId=0;
	
	@RequestMapping(value = "/orderss/{id}", method = RequestMethod.GET)
	public String orderop(@PathVariable String id, Model model, HttpServletRequest req) {
	
		// req.getSession().getAttribute("companyid"));
		customerId=Integer.valueOf(id);
		try {
			Session sesi = sf.openSession();
			// int s=req.getSession().getAttribute("companyid");
			@SuppressWarnings("unchecked")
			List<Vieworderlist> OrderLs = sesi
					.createQuery("from Vieworderlist  where ordercustomerid=:customerid order by orderid desc ")
					.setParameter("customerid", Integer.valueOf(id)).setMaxResults(10).getResultList();
			sesi.close();

			if (OrderLs.size() > 0) {
				model.addAttribute("viewOrderLs", OrderLs);
			}
			
		} catch (Exception e) {
			
		}

		return "/admin/order";
	}

	int itemc=0;
	@ResponseBody
	@RequestMapping(value = "/ajaxOrderLsPage", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String ajaxSamplePage(@RequestParam int itemCount, Model model) {
		Session sesi = sf.openSession();
		itemc=itemCount;
		String rw2="";
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Vieworderlist> OrderLs = sesi.createQuery("from Vieworderlist  where ordercustomerid=:customerid order by orderid desc")
		.setParameter("customerid", Integer.valueOf(customerId)).setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		for (Vieworderlist item : OrderLs) {

			if(item.getOrderstatus()==0) {
				
				rw2="<td> <button  onclick=\"fncStatusChange("+item.getOrderid()+")\" type=\"button\" class=\"btn btn-light\">deliver</button>\r\n" + 
						"															</td>";
				
			}
		
			else {
				
				rw2= "<td> <button disabled onclick=\"fncStatusChange("+item.getOrderid()+")\" type=\"button\" class=\"btn btn-light\">delivered</button>\r\n" + 
					"															</td>";
			}
			
			String rw = "<tr  role=\"sil\" id=\"" + item.getOrderid() + "\">\r\n"
					+ "													<td>" + item.getOrderid() + "</td>\r\n"
					+ "													<td>" + item.getProducttitle() + "</td>\r\n"
					+ "													<td>" + item.getProductdetail() + "</td>\r\n"
					+ "													<td>" + item.getCustomername() + "</td>\r\n"
					+ "													<td>" + item.getCompanyname() + "</td>\r\n"
					+ "													<td>" + item.getOrdercounts()  + "</td>\r\n"
					+ "													<td>" + item.getOrderstatus() + "</td>\r\n"
					+ "													<td>" + item.getOrdertotalprice() + "</td>\r\n"
					+ "													<td>" + item.getOrderdate() + "</td>\r\n"+
					rw2
					+ "													<td></td>\r\n"											
					+ "												</tr>";
			bl.append(rw);
		}

		sesi.close();
		model.addAttribute("viewOrderLs", OrderLs);
		return bl.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxOrderLsCount", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String ajaxPageCount() {
		StringBuilder bl = new StringBuilder();
		Long sayi = Utils.rowCount("Vieworderlist",customerId);
		for (int i = 1; i <= sayi; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageOpenOrder(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/ajaxStatusChange",method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String statusChange(@RequestParam(value="orderId") int id) {
		StringBuilder bl=new StringBuilder();
		
		
		try {
			Session sesi=sf.openSession();
			
			Transaction tr=sesi.beginTransaction();
			int sonuc=sesi.createQuery("update Order set orderstatus=:statu where orderid=:id ")
			.setParameter("id", id).setParameter("statu",(byte)1).executeUpdate();
			tr.commit();
			String rw2="";
			sesi.close();
			if(sonuc>0) {
				
				Session sesi1=sf.openSession();
				@SuppressWarnings("unchecked")
				List<Vieworderlist> OrderLs = sesi1.createQuery("from Vieworderlist  where ordercustomerid=:customerid order by orderid desc")
				.setParameter("customerid", Integer.valueOf(customerId)).setFirstResult((itemc - 1) * 10).setMaxResults(10).list();
				for (Vieworderlist item : OrderLs) {

					if(item.getOrderstatus()==0) {
						
						rw2="<td> <button  onclick=\"fncStatusChange("+item.getOrderid()+")\" type=\"button\" class=\"btn btn-light\">deliver</button>\r\n" + 
								"															</td>";
						
					}
				
					else {
					
						rw2= "<td> <button disabled onclick=\"fncStatusChange("+item.getOrderid()+")\" type=\"button\" class=\"btn btn-light\">delivered</button>\r\n" + 
							"															</td>";
					}
					
					String rw = "<tr  role=\"sil\" id=\"" + item.getOrderid() + "\">\r\n"
							+ "													<td>" + item.getOrderid() + "</td>\r\n"
							+ "													<td>" + item.getProducttitle() + "</td>\r\n"
							+ "													<td>" + item.getProductdetail() + "</td>\r\n"
							+ "													<td>" + item.getCustomername() + "</td>\r\n"
							+ "													<td>" + item.getCompanyname() + "</td>\r\n"
							+ "													<td>" + item.getOrdercounts()  + "</td>\r\n"
							
							+ "													<td>" + item.getOrderstatus() + "</td>\r\n"
							+ "													<td>" + item.getOrdertotalprice() + "</td>\r\n"
							+ "													<td>" + item.getOrderdate() + "</td>\r\n"+
							
							rw2
							
							+ "													<td></td>\r\n"											
							
							+ "												</tr>";
					bl.append(rw);
				}
				sesi1.close();

			}
		} catch (Exception e) {
			
		}
		
		return bl.toString();
	}
	

}
