package com.javawissen.admin;

import java.util.ArrayList;
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

import Models.Adress;
import Models.City;
import Models.Customer;
import Models.Neighborhood;
import Models.Street;
import Models.Town;
import Models.Viewaddress;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class UserAdressController {

	// kullanýcý adresi
	// Elif, Sinem
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/useraddress", method = RequestMethod.GET)
	public String UserAdress(HttpServletRequest req, Model model) {
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Viewaddress> ls = sesi.createQuery("from Viewaddress order by adressid desc").setMaxResults(10).list();
		model.addAttribute("ls", ls);
		sesi.close();
		return Utils.loginControl(req, "admin/useradress");
	}

	// ajaxAddressPage
	@ResponseBody
	@RequestMapping(value = "/ajaxAddressPage", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String ajaxAddressPage(@RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Viewaddress> ls = sesi.createQuery("from Viewaddress order by adressid desc").setFirstResult((itemCount - 1) * 10)
				.setMaxResults(10).list();
		for (Viewaddress item : ls) {
			String rw="<tr id=\""+item.getAdressid()+"\" role=\"sil\">\r\n" + 
					"												<td>"+item.getAdressid()+"</td>\r\n" + 
					"													<td>"+item.getCustomername()+"</td>\r\n" + 
					"													<td>"+item.getCustomersurname()+"</td>\r\n" + 
					"													<td>"+item.getAdresstitle()+"</td>\r\n" + 
					"													<td>"+item.getCitytitle()+"</td>\r\n" + 
					"													<td>"+item.getTowntitle()+"</td>\r\n" + 
					"													<td>"+item.getNeighborhoodtitle()+"</td>\r\n" + 
					"													<td>"+item.getStreettitle()+"</td>\r\n" + 
					"													<td>"+item.getAdressdescription()+"</td>\r\n" + 
					"													<td>"+item.getAdressinformation()+"</td>\r\n" + 
					"													<td>\r\n" + 
					"														<button onclick=\"fncDelete("+item.getAdressid()+", 'adressid' ,'adress')\" type=\"button\" class=\"btn btn-danger btn-sm\">Sil</button>\r\n" + 
					"														<button type=\"button\" class=\"btn btn-primary btn-sm\">Düzenle</button>\r\n" + 
					"													</td>\r\n" + 
					"												</tr>";
			bl.append(rw);
		}

		sesi.close();
		return bl.toString();
	}

	// ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/ajaxPageCountt", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String ajaxPageCount() {
		StringBuilder bl = new StringBuilder();
		Long sayi = Utils.rowCount("Viewaddress");
		for (int i = 1; i <= sayi; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageOpen(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}

	// Arama Ýþlemi
	int boyut1 = 0;
//Sesi ile customer name ve surnamei getir
	@ResponseBody
	@RequestMapping(value = "/ajaxAddressSearch", method = RequestMethod.POST,produces = "text/html;charset=utf-8")
	public String ajaxAddressSearch(Customer cr,@RequestParam String ara, @RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		ara="%"+ara+"%";
		@SuppressWarnings("unchecked")
		List<Viewaddress> ls = sesi.createQuery("from Viewaddress where customername like '" + ara + "' or customersurname like '" + ara + "'")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		boyut1 = ls.size();
		for (Viewaddress item : ls) {
			String rw="<tr id=\""+item.getAdressid()+"\" role=\"sil\">\r\n" + 
					"												<td>"+item.getAdressid()+"</td>\r\n" + 
					"													<td>"+item.getCustomername()+"</td>\r\n" + 
					"													<td>"+item.getCustomersurname()+"</td>\r\n" + 
					"													<td>"+item.getAdresstitle()+"</td>\r\n" + 
					"													<td>"+item.getCitytitle()+"</td>\r\n" + 
					"													<td>"+item.getTowntitle()+"</td>\r\n" + 
					"													<td>"+item.getNeighborhoodtitle()+"</td>\r\n" + 
					"													<td>"+item.getStreettitle()+"</td>\r\n" + 
					"													<td>"+item.getAdressdescription()+"</td>\r\n" + 
					"													<td>"+item.getAdressinformation()+"</td>\r\n" + 
					"													<td>\r\n" + 
					"														<button onclick=\"fncDelete("+item.getAdressid()+", 'adressid' ,'adress')\" type=\"button\" class=\"btn btn-danger btn-sm\">Sil</button>\r\n" + 
					"														<button type=\"button\" class=\"btn btn-primary btn-sm\">Düzenle</button>\r\n" + 
					"													</td>\r\n" + 
					"												</tr>";
			bl.append(rw);

		}
		sesi.close();
		return bl.toString();
	}

	// Arama Ýþlemi ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/ajaxPageCountSearchh", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String ajaxPageCountSearch(@RequestParam String ara) {
		StringBuilder bl = new StringBuilder();
		Session sesi = sf.openSession();
		ara="%"+ara+"%";
		@SuppressWarnings("unchecked")
		List<Viewaddress> ls = sesi.createQuery("from Viewaddress where customername like '" + ara + "' or customersurname like '" + ara + "'").list();
		int sayi = ls.size();
		int boyut = 0;
		if (sayi % 10 == 0) {
			boyut = sayi / 10;
		} else {
			boyut = (sayi / 10) + 1;
		}
		for (int i = 1; i <= boyut; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageSearch(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}
	//Edit
	@RequestMapping(value="/userAddressUpdate/{adressid}", method=RequestMethod.GET)
	public String userAddressEdit(@PathVariable Integer adressid, Model model, HttpServletRequest req) {
		Session sesi= sf.openSession();
		@SuppressWarnings("unchecked")
		List<Viewaddress> ls=sesi.createQuery("from Viewaddress where adressid='"+adressid+"'").setMaxResults(1).list();
		      List<City> cityLs = cityFill();
		    model.addAttribute("adresidd",ls.get(0).getAdressid());
			model.addAttribute("ls", ls);
			model.addAttribute("cityLs", cityLs);
			sesi.close();
		return Utils.loginControl(req, "admin/userAddressUpdate");
	}
	
	@RequestMapping(value = "/userAddressUpdates/{id}", method = RequestMethod.POST)
	public String addressEditUpdate(Adress vw, HttpServletRequest req,@PathVariable int id) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		vw.getAdressid();
		vw.setAdressid(id);
		sesi.update(vw);
		tr.commit();
		sesi.close();
		return "redirect:/" +Utils.loginControl(req, "admin/useraddress");
	}
	
}
