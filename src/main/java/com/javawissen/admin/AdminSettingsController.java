package com.javawissen.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import Models.Companies;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class AdminSettingsController {

	// admin ayarlar bölümü
	// admin yeni kayýt
	// Fatma, Mehmetali, Ýlyas
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String login(HttpServletRequest req, Model model) {
		boolean giris = req.getSession().getAttribute("kid") != null;
		if (giris) {
			return "redirect:/admin/dashboard";
		}
		
		return "admin/register";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String adminsave(Companies com, HttpServletRequest req) {
		String answer = "";
		if (!com.getCompanyname().equals("") && !com.getCompanyphone().equals("") && !com.getCompanymail().equals("") && !com.getCompanyfax().equals("")) {

			try {

				com.setCompanyid(Integer.MAX_VALUE);
				Session sesi = sf.openSession();
				Transaction tr = sesi.beginTransaction();
				int id = (Integer) sesi.save(com);
				
				String apiKey=createApiKey(id);
				com.setCompanyid(id);
				com.setCompanyapikey(apiKey);
				sesi.update(com);
				
				answer = apiKey;
				if (id != 0) {
					Admins admin = (Admins) req.getSession().getAttribute("adminInfo");
					admin.setAcompanyid(id);
					sesi.save(admin);
					
				}
				tr.commit();
				sesi.close();

			} catch (Exception e) {
				answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
						+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
						+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Ayni mail hatasi\r\n"
						+ "              </div>";
			}
		} else {
			answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
					+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
					+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Alanlar bos olamaz\r\n"
					+ "              </div>";
		}
		System.out.println(answer);
		return answer;
	}

	@ResponseBody
	@RequestMapping(value = "/next", method = RequestMethod.POST)
	public String adminnext(Admins adm, @RequestParam String apassword1, HttpServletRequest req) {
		String answer = "";

		if (!adm.getAname().equals("") && !adm.getAsurname().equals("") && !adm.getAphone().equals("")
				&& !adm.getAmail().equals("") && !adm.getApassword().equals("")) {

			if (adm.getApassword().equals(apassword1)) {

				Session sesi = sf.openSession();
				try {
					Admins admin = (Admins) sesi.createQuery("from Admins a where a.amail = :mail")
							.setParameter("mail", adm.getAmail()).getSingleResult();
					answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
							+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
							+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Mail Hatasi\r\n"
							+ "              </div>";
					sesi.close();
				} catch (Exception e) {
					req.getSession().setAttribute("adminInfo", adm);
					answer = "success";
				}

			} else {
				answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
						+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
						+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Parolalar Uyusmuyor\r\n"
						+ "              </div>";
			}
		} else {
			answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
					+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
					+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Alanlar bos olamaz\r\n"
					+ "              </div>";
			System.out.println(answer);
		}

		return answer;
	}
	
	public String createApiKey(int id) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhss");
		String apiKey = sdf.format(new Date()) + id;
		apiKey =Utils.MD5(apiKey);
		
		return apiKey;
	}
	
	
	
	
	
	
	

}
