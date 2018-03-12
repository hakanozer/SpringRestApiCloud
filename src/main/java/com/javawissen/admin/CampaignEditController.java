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

import Models.Admins;
import Models.Campaigns;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class CampaignEditController {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	int cid; // selected campaign id

	@RequestMapping(value = "/campaignEdit/{id}", method = RequestMethod.GET)
	public String campaignEdit(@PathVariable Integer id, Model model, HttpServletRequest req) {
		cid = id;
		Admins ad = (Admins) req.getSession().getAttribute("adm");

		Session sesi = sf.openSession();
		List<Campaigns> ls = sesi.createQuery("from Campaigns where campaignid = '" + id + "' ").setMaxResults(1).list();
		if (ls.get(0).getCampaigncompanyid() != ad.getAcompanyid()) {
			model.addAttribute("error", "Company id is not validated !");
		} else {
			model.addAttribute("ls", ls);
			System.out.println("id " + cid);
			sesi.close();
		}

		// return Utils.loginControl(req, "admin/campaigns");
		return Utils.loginControl(req, "admin/campaignEdit");
	}

	@RequestMapping(value = "/campaignEdit", method = RequestMethod.POST)
	public String campaignEditUpdate(Campaigns cp, HttpServletRequest req) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		cp.setCampaignid(cid);
		sesi.update(cp);
		tr.commit();
		sesi.close();

		return "redirect:/" + Utils.loginControl(req, "admin/campaigns");
	}

}
