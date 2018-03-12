package com.javawissen.admin;

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

import Models.Admins;
import Models.Sample;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
public class IncluderController {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	// admin üst bölümü çaðýran inc fonksiyonu
	@RequestMapping(value = "/admin/header", method = RequestMethod.GET)
	public String header(Model model, HttpServletRequest req) {
		boolean admDurum = req.getSession().getAttribute("adm") != null;
		if (admDurum) {
			Admins adm = (Admins) req.getSession().getAttribute("adm");
			model.addAttribute("adm", adm);
		}
		return "admin/inc/header";
	}

	// admin CSS bölümü çaðýran inc fonksiyonu
	@RequestMapping(value = "/admin/css", method = RequestMethod.GET)
	public String css() {
		return "admin/inc/css";
	}

	// admin menü bölümü çaðýran inc fonksiyonu
	@RequestMapping(value = "/admin/menu", method = RequestMethod.GET)
	public String menu(Model model, HttpServletRequest req) {
		boolean admDurum = req.getSession().getAttribute("adm") != null;
		if (admDurum) {
			Admins adm = (Admins) req.getSession().getAttribute("adm");
			model.addAttribute("adm", adm);
		}
		
		String syf = req.getRequestURI();
		String ekleSyf = "";
		for(String item : syf.split("/")) {
			ekleSyf = item;
		}
		ekleSyf = ekleSyf.substring(0, ekleSyf.length() - 4);		
		model.addAttribute("sayfa", ekleSyf);
		return "admin/inc/menu";
	}

	// admin js bölümü çaðýran inc fonksiyonu
	@RequestMapping(value = "/admin/js", method = RequestMethod.GET)
	public String js() {
		return "admin/inc/js";
	}

	// admin footer bölümü çaðýran inc fonksiyonu
	@RequestMapping(value = "/admin/footer", method = RequestMethod.GET)
	public String footer() {
		return "admin/inc/footer";
	}

	// admin sidebar bölümü çaðýran inc fonksiyonu
	@RequestMapping(value = "/admin/sidebar", method = RequestMethod.GET)
	public String sidebar() {
		return "admin/inc/sidebar";
	}
	
	// ajaxDeleteRow
	@ResponseBody
	@RequestMapping(value = "/ajaxDeleteRow", method = RequestMethod.POST)
	public String ajaxDeleteRow(@RequestParam String id,
			@RequestParam String idName,
			@RequestParam String tableName) {
		try {
			Session sesi = sf.openSession();
			Transaction tr = sesi.beginTransaction();
			String q = "delete from " +tableName + " where " +idName + " = " + id;
			sesi.createNativeQuery(q).executeUpdate();
			tr.commit();
			sesi.close();
			return id;
		} catch (Exception e) {
			return "";
		}
	}

}
