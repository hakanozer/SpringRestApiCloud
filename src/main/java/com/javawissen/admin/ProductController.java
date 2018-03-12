package com.javawissen.admin;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class ProductController {
	
	// ürün ekleme düzenleme silme listeleme
	// Ramazan, Hüssam, Muharrem, Enes
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String ornekAc(HttpServletRequest req, Model model) {
		
		return Utils.loginControl(req, "admin/product");
	}

}
