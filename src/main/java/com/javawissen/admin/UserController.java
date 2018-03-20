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

import Models.Customers;
import Models.Sample;
import Models.Viewcustomercompany;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class UserController {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String ornekAc(HttpServletRequest req, Model model) {
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customers> liste = sesi.createQuery("from Customers order by customerid desc").setMaxResults(10).list();
		// model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("liste", liste);
		sesi.close();
		return Utils.loginControl(req, "admin/users");
	}

	// ajaxCustomerPage
	@ResponseBody
	@RequestMapping(value = "/ajaxCustomerPage", method = RequestMethod.POST)
	public String ajaxCustomerPage(@RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Customers> ls = sesi.createQuery("from Customers order by customerid desc")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		for (Customers item : ls) {
			String rw = "<tr  role=\"sil\" id=\"" + item.getCustomerid() + "\">\r\n"
					+ "													<td>" + item.getCustomerid() + "</td>\r\n"
					+ "													<td>" + item.getCustomername() + "</td>\r\n"
					+ "													<td>" + item.getCustomersurname() + "</td>\r\n"
					+ "													<td>" + item.getCustomermail() + "</td>\r\n"
					+ "													<td>" + item.getCustomercompanyid()
					+ "</td>\r\n" + "													<td>" + item.getCustomerphone()
					+ "</td>\r\n" + "													<td>\r\n"
					+ "														<button onclick=\"fncCustomerDelete("
					+ item.getCustomerid()
					+ ", 'customerid' ,'customers')\" type=\"button\" class=\"btn btn-danger btn-sm\">Delete</button>\r\n"
					+ "														<button type=\"button\" class=\"btn btn-primary btn-sm\">Edit</button>\r\n"
					+ "													</td>\r\n"
					+ "												</tr>";
			bl.append(rw);
		}

		sesi.close();
		return bl.toString();

	}

	// ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/ajaxCustomerPageCount", method = RequestMethod.POST)
	public String ajaxCustomerPageCount() {
		StringBuilder bl = new StringBuilder();
		Long sayi = Utils.rowCount("Customers");
		for (int i = 1; i <= sayi; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageOpen(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}

	// users Edit
	@RequestMapping(value = "/usersEdit/{id}", method = RequestMethod.GET)
	public String usersEdit(@PathVariable String id, Model model) {

		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Viewcustomercompany> lst = sesi.createQuery("from Viewcustomercompany where customerid='" + id + "'")
				.setMaxResults(10).list();
		// model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("lst", lst);
		sesi.close();

		return "admin/usersEdit";
	}

	// users Edit
	@RequestMapping(value = "/usersEdit/{id}", method = RequestMethod.POST)
	public String usersEdit(@PathVariable Integer id, Model model, @RequestParam String customermail,
			@RequestParam String customername, @RequestParam String customersurname, HttpServletRequest req,
			Customers cst, @RequestParam String customerphone, @RequestParam Integer customercompanyid) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();

		cst.setCustomerid(id);
		cst.setCustomername(customername);
		cst.setCustomersurname(customersurname);
		cst.setCustomermail(customermail);
		cst.setCustomerphone(customerphone);
		cst.setCustomercompanyid(customercompanyid);
		try {
			sesi.update(cst);
			tr.commit();
			req.getSession().setAttribute("updatesucces", "Update basarili oldu");
			req.getSession().removeAttribute("cst");
			req.getSession().setAttribute("cst", cst);

		} catch (Exception e) {
			System.out.println("e hatasi  " + e);
		}
		return "redirect:/" + Utils.loginControl(req, "admin/users");
	}
	// users Add
	@RequestMapping(value = "/usersAddOpen", method = RequestMethod.GET)
	public String usersAddOpen(HttpServletRequest req, Model model) {
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Viewcustomercompany> liste = sesi.createQuery("from Viewcompany").list();

		model.addAttribute("clist", liste);
		sesi.close();
		return Utils.loginControl(req, "admin/usersAdd");

	}
	
	// Users Add
		@ResponseBody
		@RequestMapping(value = "/usersAdd", method = RequestMethod.POST)
		public String usersAdd(Model model, Customers ct, @RequestParam String customerpassword1) {
			String data = "";
		
			if (ct.getCustomername().equals("") || ct.getCustomersurname().equals("") || ct.getCustomermail().equals("")
					|| ct.getCustomerphone().equals("") || ct.getCustomerpassword().equals("")
					|| customerpassword1.equals("")) {
				data = "       	<div class=\"alert alert-danger alert-dismissible\">\n"
						+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n"
						+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Alanlari bos birakmayiniz!\n"
						+ "              </div>";
				return data;

			} else {

				if (ct.getCustomerpassword().equals(customerpassword1)) {
					
					try {
						Session sesi = sf.openSession();
						Transaction tr = sesi.beginTransaction();
						ct.setCustomerid(Integer.MAX_VALUE);
						int i = (Integer) sesi.save(ct);
						
						tr.commit();
						sesi.close();
					} catch (Exception e) {
						System.out.println(e);
					}

					data = "       	<div class=\"alert alert-success alert-dismissible\">\n"
							+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n"
							+ "                <h4>Alert</h4>Islem Basarili!\n" + "              </div>";
					return data;

				} else {
					data = "       	<div class=\"alert alert-danger alert-dismissible\">\n"
							+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\n"
							+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Parolalar eslesmiyor!\n"
							+ "              </div>";
					return data;
				}

			}

		}
		
		
		
	
		// users update Password
		@RequestMapping(value = "/usersPassword/{id}", method = RequestMethod.POST)
		public String usersPassword(@PathVariable Integer id, Model model, @RequestParam String customermail,
				@RequestParam String customername, @RequestParam String customersurname, @RequestParam String npassword,
				@RequestParam String customerphone, @RequestParam Integer customercompanyid,
				@RequestParam String nnpassword, HttpServletRequest req, Customers cst) {

			

			if (npassword.equals(nnpassword)) {
				Session sesi = sf.openSession();
				Transaction tr = sesi.beginTransaction();

				cst.setCustomerid(id);
				cst.setCustomerpassword(npassword);
				cst.setCustomername(customername);
				cst.setCustomersurname(customersurname);
				cst.setCustomermail(customermail);
				cst.setCustomerphone(customerphone);
				cst.setCustomercompanyid(customercompanyid);

				try {
					sesi.update(cst);
					tr.commit();
					req.getSession().setAttribute("updatesucces", "Update basarili oldu");
					req.getSession().removeAttribute("cst");
					req.getSession().setAttribute("cst", cst);

				} catch (Exception e) {
					System.out.println("e hatasi  " + e);
				}

			}

			else {
				req.getSession().setAttribute("updatesucces", "Update ba�ar�s�z oldu");

			}

			return "redirect:/" + Utils.loginControl(req, "admin/users");
		}	
		


	// Search operation
	int boyut1 = 0;

	@ResponseBody
	@RequestMapping(value = "/ajaxCustomerSearchh", method = RequestMethod.POST)
	public String ajaxCustomerSearchh(@RequestParam String ara, @RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Customers> liste = sesi
				.createQuery("from Customer  where customername='" + ara + "' or customersurname ='" + ara + "'")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		boyut1 = liste.size();
		for (Customers item : liste) {
			String rw = "<tr  role=\"sil\" id=\"" + item.getCustomerid() + "\">\r\n"
					+ "													<td>" + item.getCustomerid() + "</td>\r\n"
					+ "													<td>" + item.getCustomername() + "</td>\r\n"
					+ "													<td>" + item.getCustomersurname() + "</td>\r\n"
					+ "													<td>" + item.getCustomermail() + "</td>\r\n"
					+ "													<td>" + item.getCustomercompanyid()
					+ "</td>\r\n" + "													<td>" + item.getCustomerphone()
					+ "</td>\r\n" + "													<td>\r\n"
					+ "														<button onclick=\"fncDelete("
					+ item.getCustomerid()
					+ ", 'customerid' ,'customers')\" type=\"button\" class=\"btn btn-danger btn-sm\">Delete</button>\r\n"
					+ "														<a href='/jsoncloud/admin/usersEdit/"
					+ item.getCustomerid() + "\'>\n"
					+ "														<button type=\"button\" class=\"btn btn-primary btn-sm\">Edit</button></a>"
					+ "													</td>\r\n"
					+ "												</tr>";
			bl.append(rw);

		}

		sesi.close();
		return bl.toString();
	}

	// Search operation ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/ajaxPageCountSearchh", method = RequestMethod.POST)
	public String ajaxPageCountSearchh(@RequestParam String ara) {
		StringBuilder bl = new StringBuilder();
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Sample> liste = sesi
				.createQuery("from Customers  where customername='" + ara + "' or customersurname ='" + ara + "'")
				.list();
		int sayi = liste.size();
		int boyut = 0;
		if (sayi % 10 == 0) {
			boyut = sayi / 10;
			
		} else {
			boyut = (sayi / 10) + 1;
			
		}
		for (int i = 1; i <= boyut; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageSearchh(" + i + ")\">" + i + "</a></li>");
		}
		return bl.toString();
	}


}
