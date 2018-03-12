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

import Models.Customer;
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
		List<Customer> liste = sesi.createQuery("from Customer order by customerid desc").setMaxResults(10).list();
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
		List<Customer> ls = sesi.createQuery("from Customer order by customerid desc")
				.setFirstResult((itemCount - 1) * 10).setMaxResults(10).list();
		for (Customer item : ls) {
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
		Long sayi = Utils.rowCount("Customer");
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
			Customer cst, @RequestParam String customerphone, @RequestParam Integer customercompanyid) {

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

}
