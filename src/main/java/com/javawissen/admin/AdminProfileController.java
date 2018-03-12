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

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String login(HttpServletRequest req, Model model) {
		boolean admDurum = req.getSession().getAttribute("adm") != null;
		if (admDurum) {
			Admins adm = (Admins) req.getSession().getAttribute("adm");
			model.addAttribute("adm", adm);
		}
		boolean giris = req.getSession().getAttribute("companyid") != null;
		String companyadress = "";

		if (giris) {
			model.addAttribute("com", companyGetinformation(req));

			try {
				Session sesi = sf.openSession();
				ViewCompaniesAdress vca = (ViewCompaniesAdress) sesi
						.createQuery("From ViewCompaniesAdress v where v.companyid = :companyid")
						.setParameter("companyid", req.getSession().getAttribute("companyid")).getSingleResult();
				req.getSession().setAttribute("adressvca", vca);
				System.out.println(vca.getAdressid());
				companyadress = vca.getAdresstitle() + " " + vca.getCitytitle() + " " + vca.getTowntitle() + " "
						+ vca.getNeighborhoodtitle() + " " + vca.getStreettitle();

				model.addAttribute("companyadress", companyadress);
				sesi.close();
			} catch (Exception e) {
				System.out.println("HATA:" + e);
			}

		}

		if (req.getSession().getAttribute("updatesuccess") != null) {
			model.addAttribute("success", req.getSession().getAttribute("updatesuccess"));
		}
		if (req.getSession().getAttribute("updateerror") != null) {
			model.addAttribute("error", req.getSession().getAttribute("updateerror"));
		}

		return "admin/profile";
	}

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

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String adminUpdate(HttpServletRequest req, Companies com,Adress adr, Admins adm, Model model) {
		System.out.println(adr.getAdresscityid());
		System.out.println(adr.getAdresstownid());
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		Admins admin = (Admins) req.getSession().getAttribute("adm");
		Adress adress = (Adress) req.getSession().getAttribute("adressadr");
		adr.setAdressid(adress.getAdressid());
		adr.setAdresscompaniesid(adress.getAdresscompaniesid());
		adm.setAid(admin.getAid());
		adm.setApassword(admin.getApassword());
		adm.setAcompanyid(admin.getAcompanyid());
		com.setCompanyid((Integer) req.getSession().getAttribute("companyid"));

		try {
			sesi.update(adm);
			sesi.update(com);
			sesi.update(adr);
			tr.commit();
			sesi.close();
			req.getSession().setAttribute("updatesuccess", "duzenleme islemi basarilidir");
			req.getSession().removeAttribute("adm");
			req.getSession().setAttribute("adm", adm);
			req.getSession().setAttribute("adressadr", adr);
		} catch (Exception e) {
			req.getSession().setAttribute("updateerror", "duzenleme islemi basarisiz");
		}
		return Utils.loginControl(req, "redirect:/admin/profile");

	}

	public Companies companyGetinformation(HttpServletRequest req) {
		Session sesi = sf.openSession();
		Companies compan = (Companies) sesi.createQuery("from Companies c where c.companyid = :companyid")
				.setParameter("companyid", req.getSession().getAttribute("companyid")).getSingleResult();
		sesi.close();
		return compan;
	}



}
