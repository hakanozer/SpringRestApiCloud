package com.javawissen.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Models.Admins;
import Models.Adress;
import Models.City;
import Models.Companies;
import Models.ViewCompaniesAdress;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class AdminProfileController {

	SessionFactory sf = HibernateUtil.getSessionFactory();

		@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String adminedit(HttpServletRequest req, Model model) {
		Admins adm = (Admins) req.getSession().getAttribute("adm");
		model.addAttribute("adm", adm);
		model.addAttribute("com", companyGetinformation(req));

		List<City> cityLs = new  UserAdressController().cityFill ();
		model.addAttribute("cityLs", cityLs);
		
		try {
			Session sesi = sf.openSession();
			
			ViewCompaniesAdress vca = (ViewCompaniesAdress) req.getSession().getAttribute("adressvca");
			
			Adress adr = (Adress) sesi.createQuery(" From Adress a where a.adressid = :adressid ")
					.setParameter("adressid", vca.getAdressid() ).getSingleResult();
			model.addAttribute("vca",vca);
			model.addAttribute("adr",adr);
			req.getSession().setAttribute("adressadr", adr);
			sesi.close();
		} catch (Exception e) {
			System.err.println("HATAAAAA:"+e);
		}

		return Utils.loginControl(req, "admin/adminEdit");
	}

	
	public Companies companyGetinformation(HttpServletRequest req) {
		Session sesi = sf.openSession();
		Companies compan = (Companies) sesi.createQuery("from Companies c where c.companyid = :companyid")
				.setParameter("companyid", req.getSession().getAttribute("companyid")).getSingleResult();
		sesi.close();
		return compan;
	}



}
