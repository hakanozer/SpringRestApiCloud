package com.javawissen.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Models.Category;
import Models.Products;
import Models.Sample;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class ProductController {

	// ürün ekleme düzenleme silme listeleme
	// Ramazan, Hüssam, Muharrem, Enes
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String ornekAc(HttpServletRequest req, Model model) {
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Products> ls = sesi.createQuery("from Products order by productid desc").setMaxResults(10).list();
		// model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("ls", ls);
		System.out.println(ls.get(0).getProductdescription());
		sesi.close();
		return Utils.loginControl(req, "admin/product");
	}

	// ajaxSamplePage
	@ResponseBody
	@RequestMapping(value = "/ajaxProductPage", method = RequestMethod.POST)
	public String ajaxProductPage(@RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Products> ls = sesi.createQuery("from Products order by productid desc")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		for (Products item : ls) {
			String rw = "<tr  role=\"sil\" id=\"" + item.getProductid() + "\">\r\n"
					+ "													<td>" + item.getProductid() + "</td>\r\n"
					+ "													<td>" + item.getProducttitle() + "</td>\r\n"
					+ "													<td>" + item.getProductdescription()
					+ "</td>\r\n"
					+ "													<td><span class=\"label label-success\">Approved</span></td>\r\n"
					+ "													<td>\r\n"
					+ "														<button onclick=\"fncDelete("
					+ item.getProductid()
					+ ", 'productid' ,'products')\" type=\"button\" class=\"btn btn-danger btn-sm\">Sil</button>\r\n"
					+ "														<button type=\"button\" class=\"btn btn-primary btn-sm\">Düzenle</button>\r\n"
					+ "													</td>\r\n"
					+ "												</tr>";
			bl.append(rw);
		}

		sesi.close();
		return bl.toString();
	}

	// ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/ajaxProductPageCount", method = RequestMethod.POST)
	public String ajaxProductCount() {
		StringBuilder bl = new StringBuilder();
		Long sayi = Utils.rowCount("Products");
		for (int i = 1; i <= sayi; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageOpen(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}

	// Arama Ýþlemi
	int boyut1 = 0;

	@ResponseBody
	@RequestMapping(value = "/ajaxProductSearch", method = RequestMethod.POST)
	public String ajaxProductSearch(@RequestParam String ara, @RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		ara = "%" + ara + "%";
		@SuppressWarnings("unchecked")
		List<Products> ls = sesi
				.createQuery(
						"from Products  where producttitle like '" + ara + "' or productdescription like '" + ara + "'")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		boyut1 = ls.size();
		for (Products item : ls) {
			String rw = "<tr  role=\"sil\" id=\"" + item.getProductid() + "\">\r\n" + "				<td>"
					+ item.getProductid() + "</td>\r\n" + "				<td>" + item.getProductcompanyid() + "</td>\r\n"
					+ "				<td>" + item.getProducttitle() + "</td>\r\n" + "               <td>"
					+ item.getProductcategoryid() + "</td>\r\n" + "               <td>" + item.getProductdescription()
					+ "</td>\r\n" + "               <td>" + item.getProductdetail() + "</td>\r\n"
					+ "               <td>" + item.getProductprice() + "</td>\r\n" + "               <td>"
					+ item.getProducttype() + "</td>\r\n" + "               <td>" + item.getProductcampaignid()
					+ "</td>\r\n" + "               <td>" + item.getProductadressesid() + "</td>\r\n"
					+ "			<td>\r\n" + "				<button onclick=\"fncDelete(" + item.getProductid()
					+ ", 'sid' ,'sample')\" type=\"button\" class=\"btn btn-danger btn-sm\">Sil</button>\r\n"
					+ "				<button type=\"button\" class=\"btn btn-primary btn-sm\">Düzenle</button>\r\n"
					+ "				</td>\r\n" + "			</tr>";
			bl.append(rw);

		}

		sesi.close();
		return bl.toString();
	}

	// Arama Ýþlemi ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/ajaxProductPageCountSearch", method = RequestMethod.POST)
	public String ajaxProductPageCountSearch(@RequestParam String ara) {
		StringBuilder bl = new StringBuilder();
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Sample> ls = sesi
				.createQuery(
						"from Products  where producttitle like '" + ara + "' or productdescription like '" + ara + "'")
				.list();
		int sayi = ls.size();
		int boyut = 0;
		if (sayi % 10 == 0) {
			boyut = sayi / 10;
			System.out.println(boyut);
		} else {
			boyut = (sayi / 10) + 1;
			System.out.println(boyut);
		}
		for (int i = 1; i <= boyut; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageProductSearch(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}

	@RequestMapping(value = "/productAdd", method = RequestMethod.GET)
	public String productAdd(Model model) {
		Session sesi = sf.openSession();
		System.out.println("burda");
		@SuppressWarnings("unchecked")
		List<Category> lc = sesi.createQuery("from Category where categorycompanyid=1").list();
		// model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("lc", lc);

		sesi.close();

		return "admin/productAdd";
	}

	@ResponseBody
	@RequestMapping(value = "/productInsert", method = RequestMethod.POST)
	public String productInsert(Products prd) {
		
	
		System.out.println("insert iþlemi");
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		// int yaz=(Integer) sesi.save(prd);
		int readStatu = (Integer) sesi.save(prd);
		tr.commit();
		sesi.close();

		if (readStatu > 0) {
			return "true";
		}else {
			return "";
		}
	}
}
