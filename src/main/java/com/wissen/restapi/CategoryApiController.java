package com.wissen.restapi;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Models.Admins;
import Models.Category;
import Utils.HibernateUtil;

@RestController
@RequestMapping(value="/admin")
public class CategoryApiController {
	SessionFactory sf=HibernateUtil.getSessionFactory();
	
	
	@RequestMapping(value="/categoryapi", method=RequestMethod.GET)
	public HashMap<String, Object>allCategories(HttpServletRequest req){
		Session sesi = sf.openSession();
		req.getSession().getAttribute("kid");
		Admins admin = (Admins) sesi.createQuery("from Admins a where a.aid = :kid").
				setParameter("kid",req.getSession().getAttribute("kid") ).getSingleResult();
		HashMap<String, Object>hm=new HashMap<String, Object>();
		try {
			List<Category>Cls= sesi.createQuery("from Category where categorycompanyid = :catid").setParameter("catid",Integer.parseInt(admin.getAcompanyid())  )
					.list();
			List<Category> ls = new ArrayList<Category>();
			for (Category item : Cls) {
				if (item.getCategoryparentid() == 0) {
					ls.add(item);
					for (Category itemx : Cls) {
						if(itemx.getCategoryparentid() != 0 && itemx.getCategoryparentid() == item.getCategoryid()) {
							ls.add(itemx);
						}
					}
				}
			}
			System.out.println("cls: "+Cls);
			System.out.println("ls: "+ls);
			hm.put("condition", true);
			hm.put("message", "Category listing succesful!");
			hm.put("Categories", ls);
		} catch (Exception e) {
			hm.put("condition", false);
			hm.put("message", "Category listing failed!");
			System.err.println("Error: "+e);
		}
		return hm;
	}
	
}
