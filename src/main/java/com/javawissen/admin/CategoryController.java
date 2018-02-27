package com.javawissen.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import Models.Category;
import Utils.HibernateUtil;

@Controller
@RequestMapping (value="/admin")
public class CategoryController {
	
	// yeni kategori ekle, düzenle, listei, silme
	// Zeki, Sema
	
	SessionFactory sf=HibernateUtil.getSessionFactory();
	@RequestMapping (value="/category",method = RequestMethod.GET)
	public String category() {
		
		
		return "admin/category";
	}
	
	//ajax ile kategori ekleme
	@ResponseBody
	@RequestMapping (value="/addCategory",method = RequestMethod.POST)
	public String addCategory(Category ct) {
		Session sesi=sf.openSession();
		Transaction tr=sesi.beginTransaction();
		ct.setCategoryid(Integer.MAX_VALUE);
		int categoryID=(Integer) sesi.save(ct);
		ct.setCategoryid(categoryID);
		tr.commit();
		sesi.close();
		
		
		
		
		return "admin/addCategory";
	}
}
