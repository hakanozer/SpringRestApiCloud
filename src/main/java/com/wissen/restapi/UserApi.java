package com.wissen.restapi;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Utils.DB;
import Utils.HibernateUtil;

// Router operation
@Controller
@RequestMapping(value = "/usersapi")
public class UserApi {
DB db=new DB();

SessionFactory sf = HibernateUtil.getSessionFactory();
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Usersapi(Model model) {

		return "usersapi";
	}

	

}