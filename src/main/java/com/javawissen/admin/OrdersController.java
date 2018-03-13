package com.javawissen.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Models.Basket;
import Models.Customer;
import Models.Viewproductlist;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class OrdersController {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	int productCount = 0;
	Date date=new Date();
	@RequestMapping(value = "/orderManagement", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String orderOpen(HttpServletRequest req, Model model) {
		productCount = 0;
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Viewproductlist> productList = sesi.createQuery("from Viewproductlist order by productid desc")
				.setMaxResults(10).list();
		
		for (Viewproductlist item : productList) {
			System.out.println("kampanya batarih: "+item.getCampaignstartdate());
			if(item.getCampaignstartdate()==null && item.getCampaignenddate()==null ) {
				item.setCampaigntitle(null);
				item.setCampaigndetail(null);
			}else  {
				if(date.after(item.getCampaignstartdate()) && date.before(item.getCampaignenddate())){
					System.out.println("date: "+date);
				}else {
					System.out.println(item.getCampaigntitle());
					item.setCampaigntitle(null);
					System.out.println(item.getCampaigntitle());
					item.setCampaigndetail(null);
				}
			}
		}
		
		model.addAttribute("productList", productList);
		sesi.close();
		// bring customer
		int companyid = (Integer) req.getSession().getAttribute("companyid");
		Session sesi2 = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customerLs = sesi2.createQuery("from Customer where customercompanyid =:companyid ")
				.setParameter("companyid", companyid).getResultList();
		model.addAttribute("customer", customerLs);
		sesi2.close();

		return Utils.loginControl(req, "/admin/orderManagement");
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxOrderPage", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String ajaxSamplePage(@RequestParam int itemCount, Model model) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Viewproductlist> productLs = sesi.createQuery("from Viewproductlist order by productid desc")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		for (Viewproductlist item : productLs) {

			System.out.println("kampanya batarih: "+item.getCampaignstartdate());
			if(item.getCampaignstartdate()==null && item.getCampaignenddate()==null ) {
				item.setCampaigntitle(null);
				item.setCampaigndetail(null);
			}else  {
				if(date.after(item.getCampaignstartdate()) && date.before(item.getCampaignenddate())){
					System.out.println("date: "+date);
				}else {
					System.out.println(item.getCampaigntitle());
					item.setCampaigntitle(null);
					System.out.println(item.getCampaigntitle());
					item.setCampaigndetail(null);
				}
			}

			String rw = "<tr  role=\"sil\" id=\"" + item.getProductid() + "\">\r\n"
					+ "													<td>" + item.getProductid() + "</td>\r\n"
					+ "													<td>" + item.getProducttitle() + "</td>\r\n"
					+ "													<td>" + item.getProductdetail() + "</td>\r\n"
					+ "													<td>" + item.getCategorytitle() + "</td>\r\n"
					+ "													<td>" + item.getCampaigntitle() + "</td>\r\n"
					+ "													<td>" + item.getCampaigndetail() + "</td>\r\n"
					+ "													<td>" + item.getProductprice() + "</td>\r\n"
					+ "													<td></td>\r\n" +

					"													<td>\r\n"
					+ "														<button onclick=\"fncAdd("
					+ item.getProductid()
					+ ")\" type=\"button\"  style=\"color:green;\"  class=\"fa fa--plus\"></button>\r\n"
					+ "													</td>\r\n"
					+ "												</tr>";
			bl.append(rw);
		}

		sesi.close();
		model.addAttribute("productList", productLs);
		return bl.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxOrderPageCount", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String ajaxPageCount() {
		StringBuilder bl = new StringBuilder();
		Long sayi = Utils.rowCount("Viewproductlist");
		for (int i = 1; i <= sayi; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageOpen(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}

	// Search operation
	int boyut1 = 0;
	

	@ResponseBody
	@RequestMapping(value = "/ajaxOrderSearch", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String ajaxSampleSearch(@RequestParam String ara, @RequestParam int itemCount) {
		Session sesi = sf.openSession();
		ara = "%" + ara + "%";
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Viewproductlist> productLs = sesi
				.createQuery("from Viewproductlist  where producttitle like '" + ara + "' or categorytitle like '" + ara
						+ "' or campaigntitle like '" + ara + "'")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		boyut1 = productLs.size();
		for (Viewproductlist item : productLs) {
			String rw = "<tr  role=\"sil\" id=\"" + item.getProductid() + "\">\r\n"
					+ "													<td>" + item.getProductid() + "</td>\r\n"
					+ "													<td>" + item.getProducttitle() + "</td>\r\n"
					+ "													<td>" + item.getProductdetail() + "</td>\r\n"
					+ "													<td>" + item.getCategorytitle() + "</td>\r\n"
					+ "													<td>" + item.getCampaigntitle() + "</td>\r\n"
					+ "													<td>" + item.getCampaigndetail() + "</td>\r\n"
					+ "													<td>" + item.getProductprice() + "</td>\r\n" +

					"													<td>\r\n"
					+ "														<button onclick=\"fncAdd("
					+ item.getProductid()
					+ ")\" type=\"button\"  style=\"color:green;\"  class=\"fa fa--plus\"></button>\r\n"
					+ "													</td>\r\n"
					+ "												</tr>";
			bl.append(rw);

		}

		sesi.close();
		return bl.toString();
	}

	// Arama işlemi ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/ajaxOrderPageCountSearch", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String ajaxPageCountSearch(@RequestParam String ara) {
		ara = "%" + ara + "%";
		StringBuilder bl = new StringBuilder();
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Viewproductlist> productLs = sesi.createQuery("from Viewproductlist  where producttitle like '" + ara
				+ "'  or categorytitle like '" + ara + "' or campaigntitle like '" + ara + "'").list();
		int sayi = productLs.size();
		int boyut = 0;
		if (sayi % 10 == 0) {
			boyut = sayi / 10;
			System.out.println(boyut);
		} else {
			boyut = (sayi / 10) + 1;
			System.out.println(boyut);
		}
		for (int i = 1; i <= boyut; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageSearch(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}

	// Add
	@ResponseBody
	@RequestMapping(value = "/cartAdd", method = RequestMethod.POST)
	public int Add(HttpServletRequest req, Model model, @RequestParam int id) {
		productCount = 0;

		try {
			Session sesi1 = sf.openSession();
			@SuppressWarnings("unchecked")
			List<Basket> productcountLs = sesi1.createQuery("from Basket where basketcustomerid=:basketcid")
					.setParameter("basketcid", id).getResultList();
			if (productcountLs.size() > 0) {
				for (Basket item : productcountLs) {
					productCount += item.getBasketproductcount();
				}

			}
			sesi1.close();
		} catch (Exception e) {
			System.err.println("Ürün adet Getirme hatasi: " + e);
		}
		model.addAttribute("cid", id);
		
		return productCount;

	}

	// CartProductAdd
	@ResponseBody
		@RequestMapping(value = "/cartProductAdd", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
		public String ajaxCartProductAdd(HttpServletRequest req, Model model,@RequestParam  int customerid,
				@RequestParam  int productid,@RequestParam  int productcount) {
			Date date=new Date();
			String result="";
			/*SimpleDateFormat date=new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
			date.format(dt);*/
		
			Session sesi1=sf.openSession();
			@SuppressWarnings("unchecked")
			List<Basket> basketLs = sesi1.createQuery("from Basket where basketcustomerid  =:basketcustomerid and basketproductid=:basketproductid ")
			.setParameter("basketcustomerid", customerid)
			.setParameter("basketproductid",productid)
			.getResultList();
			sesi1.close();
			
			
			if(basketLs.size()>0) {
				Session sesi2=sf.openSession();
				Transaction tr=sesi2.beginTransaction();
				Basket basket=new Basket();
				basket.setBasketid(basketLs.get(0).getBasketid());
				basket.setBasketcustomerid(customerid);
				basket.setBasketproductid(productid);
				basket.setBasketproductcount(basketLs.get(0).getBasketproductcount()+1);
				basket.setBasketdate(date);
				sesi2.update(basket);
				tr.commit();
				sesi2.close();
				result="Basarili";
				
			}else {
			
			
			try {
				Session sesi = sf.openSession();
				Transaction tr=sesi.beginTransaction();
				Basket basket=new Basket();
				basket.setBasketid(Integer.MAX_VALUE);
				basket.setBasketcustomerid(customerid);
				basket.setBasketproductid(productid);
				basket.setBasketproductcount(productcount);
				basket.setBasketdate(date);
				sesi.save(basket);
				
				tr.commit();
				sesi.close();
				result="Basarili";
			} catch (Exception e) {
				System.err.println("Sepete Ürün Ekleme Hatasi: " + e);
			}
			
		}return result;}
		
	
}
