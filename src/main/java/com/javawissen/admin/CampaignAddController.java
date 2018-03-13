package com.javawissen.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Models.Admins;
import Models.Campaigns;
import Models.Companies;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class CampaignAddController {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/campaignAdd", method = RequestMethod.GET)
	public String campaignAddOpen(HttpServletRequest req, Model model) {
		Admins ad = (Admins) req.getSession().getAttribute("adm");
		Session sesi = sf.openSession();
		List<Companies> ls = sesi.createQuery("from Companies where companyid = '" + ad.getAcompanyid() + "' ").list();
		model.addAttribute("ls", ls);
		sesi.close();
		return Utils.loginControl(req, "admin/campaignAdd");
	}

	@RequestMapping(value = "/campaignAdd", method = RequestMethod.POST)
	public String campaignAdd(HttpServletRequest req, Campaigns cp,Model model) {

		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		cp.setCampaignid(Integer.MAX_VALUE);
		sesi.save(cp);
		tr.commit();
		sesi.close();

		return "redirect:/" + Utils.loginControl(req, "admin/campaignAdd");
	}

}
