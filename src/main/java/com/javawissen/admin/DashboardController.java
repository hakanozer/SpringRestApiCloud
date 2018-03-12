package com.javawissen.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class DashboardController {
	
	
	// yonetim ana sayfasý
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String yonetimAc(HttpServletRequest req) {
		return Utils.loginControl(req, "admin/dashboard");
	}
	
	
}
