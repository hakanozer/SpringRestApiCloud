package com.javawissen.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Models.Admins;
import Models.Adress;
import Models.City;
import Models.Companies;
import Models.Customer;
import Models.FileMeta;
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

		List<City> cityLs = new  UserAdressController().cityFill ();
		model.addAttribute("cityLs", cityLs);
		
		return "admin/register";
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
					adm.setApicpath(""+req.getSession().getAttribute("Apicpath"));
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

	
		
	
		
	
	
}
