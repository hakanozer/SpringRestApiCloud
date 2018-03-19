package com.wissen.restapi;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Models.Customers;
import Utils.HibernateUtil;

@RestController
public class UserRestApiList {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "usersapi/listele", method = RequestMethod.POST)

	public HashMap<String, Object> listele(@RequestParam String cmail, @RequestParam String cpassword, Model model) {
		HashMap<String, Object> hm = new HashMap<String, Object>();

		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Customers> cls = sesi
				.createQuery("from Customer where customermail='" + cmail + "'and customerpassword='" + cpassword + "'")
				.list();
		if (!cls.isEmpty()) {

			hm.put("Customer", cls);

		}

		else {

			hm.put("mesaj", "Customer  Listeleme Basarisiz");
		}

		sesi.close();
		return hm;

	}

}
