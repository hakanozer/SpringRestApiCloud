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
import Models.Customers;
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
	public String ajaxAddressSearch(Customers cr,@RequestParam String ara, @RequestParam int itemCount) {
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

	// User Address Add
	@RequestMapping(value = "/userAddressAdd", method = RequestMethod.GET)
	public String userAddressAdd(Model model, HttpServletRequest req) {

		List<City> cityLs = cityFill();
		List<Customers> userLs = userFill();
		model.addAttribute("cityLs", cityLs);
		model.addAttribute("userLs", userLs);
		boolean error = req.getSession().getAttribute("error") != null;
		if (error) {
			String er = "" + req.getSession().getAttribute("error");
			model.addAttribute("error", er);
			req.getSession().removeAttribute("error");
		}
		return Utils.loginControl(req, "admin/userAddressAdd");
	}

	// Ýnsert
	@RequestMapping(value = "/useraddresssave", method = RequestMethod.POST)
	public String userAddressSave(Adress adr, Model model, HttpServletRequest req) {
		if (adr.getAdresscustomerid() == -1 || adr.getAdresstitle().equals("") || adr.getAdressdescription().equals("")
				|| adr.getAdresscityid() == -1) {
			req.getSession().setAttribute("error", "Eksik bilgi girdiniz !");
			return "redirect:/admin/userAddressAdd";
		} else {
			Session sesi = sf.openSession();
			Transaction tr = sesi.beginTransaction();
			adr.setAdressid(Integer.MAX_VALUE);
			sesi.save(adr);
			tr.commit();
			sesi.close();
		}
		return "redirect:/admin/userAddressAdd";
	}

	@ResponseBody
	@RequestMapping(value = "/useraddresstown", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String userTown(@RequestParam int cityid) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		City ct = (City) sesi.createQuery("from City  where cityid='" + cityid + "'").getSingleResult();
		@SuppressWarnings("unchecked")
		List<Town> townLs = sesi.createQuery("from Town  where towncityid='" + ct.getCitykey() + "'").list();
		bl.append("<option value=\"-1\" selected=\"selected\">Please select your town</option>");
		for (Town item : townLs) {
			String rw = " <option value=\"" + item.getTownid() + "\">" + item.getTowntitle() + "</option>";
			bl.append(rw);
		}
		sesi.close();
		return bl.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/useraddressneighborhood", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String userNeighborhood(@RequestParam int townid) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		Town tw = (Town) sesi.createQuery("from Town where townid='" + townid + "'").getSingleResult();
		@SuppressWarnings("unchecked")
		List<Neighborhood> neighborhoodLs = sesi
				.createQuery("from Neighborhood where neighborhoodtownid='" + tw.getTownkey() + "'").list();
		bl.append("<option value=\"-1\" selected=\"selected\">Please select your neighborhood</option>");
		for (Neighborhood item : neighborhoodLs) {
			String rw = "<option value=\"" + item.getNeighborhoodid() + "\">" + item.getNeighborhoodtitle()
					+ "</option>";
			bl.append(rw);
		}
		sesi.close();
		return bl.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/useraddressstreet", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	public String userStreet(@RequestParam int neighborhoodid) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		Neighborhood ng = (Neighborhood) sesi
				.createQuery("from Neighborhood where neighborhoodid='" + neighborhoodid + "'").getSingleResult();
		@SuppressWarnings("unchecked")
		List<Street> streetLs = sesi
				.createQuery("from Street where streetneighborhoodid='" + ng.getNeighborhoodkey() + "'").list();
		bl.append("<option value=\"-1\" selected=\"selected\">Please select your street</option>");
		for (Street item : streetLs) {
			String rw = "<option value=\"" + item.getStreetid() + "\">" + item.getStreettitle() + "</option>";
			bl.append(rw);
		}
		sesi.close();
		return bl.toString();
	}

	@SuppressWarnings("unchecked")
	public List<City> cityFill() {
		List<City> cityLs = new ArrayList<City>();
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		cityLs = sesi.createQuery("from City").list();
		tr.commit();
		sesi.close();
		return cityLs;
	}

	@SuppressWarnings("unchecked")
	public List<Customers> userFill() {
		List<Customers> userLs = new ArrayList<Customers>();
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		userLs = sesi.createQuery("from Customer").list();
		tr.commit();
		sesi.close();
		return userLs;
	}
	
	//Edit
	@RequestMapping(value="/userAddressUpdate/{adressid}", method=RequestMethod.GET)
	public String userAddressEdit(@PathVariable Integer adressid, Model model, HttpServletRequest req) {
		//Adress ad=(Adress) req.getSession().getAttribute("adr");
		Session sesi= sf.openSession();
	
		@SuppressWarnings("unchecked")
		List<Viewaddress> ls=sesi.createQuery("from Viewaddress where adressid='"+adressid+"'").setMaxResults(1).list();
		//if (ls.get(0).getAdressid() != ad.getAdresscityid()) {
			//model.addAttribute("error", "Company id is not validated !");
		//} else {
		      List<City> cityLs = cityFill();
		    model.addAttribute("adresidd",ls.get(0).getAdressid());
			model.addAttribute("ls", ls);
			System.out.println("id " + adressid);
			model.addAttribute("cityLs", cityLs);
			sesi.close();
		//}
		return Utils.loginControl(req, "admin/userAddressUpdate");
	}
	
	@RequestMapping(value = "/userAddressUpdates/{id}", method = RequestMethod.POST)
	public String campaignEditUpdate(Adress vw, HttpServletRequest req,@PathVariable int id) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		vw.getAdressid();
		vw.setAdressid(id);
		sesi.update(vw);
		tr.commit();
		sesi.close();
		System.out.println("update geldim");
		return "redirect:/" +Utils.loginControl(req, "admin/useraddress");
	}
}
