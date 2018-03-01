package com.javawissen.admin;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import Models.Category;
import Utils.HibernateUtil;
import Utils.Utils;

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
	
	@RequestMapping (value="/addCategory",method = RequestMethod.GET)
	public String categoryadd(Model model) {
		
		List<Category>showCategory=fillCategoryDropdown();
		model.addAttribute("showCategory", showCategory);
		System.out.println("kategoriler doldu");
		return "admin/addCategory";
	}
	
	//kategori ekleme
	@ResponseBody
	@RequestMapping (value="/addingCategory",method = RequestMethod.POST)
	public String addingCategory(Category ct,HttpServletRequest req ) {
		System.out.println("addingCategory");
		try {
			Session sesi = sf.openSession();
			
			Transaction tr = sesi.beginTransaction();
			ct.setCategorycompanyid(12);//session dan alýnacak.req.getsession.getattribute bu kodla
			ct.setCategorylink(categoryLinkEdit(ct.getCategorytitle()));
			if (ct.getCategoryparentid() == 0) {
				ct.setCategoryparentid(0);
			}
			sesi.save(ct);
			tr.commit();
			sesi.close();
			String data = "<option value=\""+ct.getCategoryid()+"\">"+ct.getCategorytitle()+"</option>";
			return data;
		} catch (Exception e) {
			System.err.println(e);
		}
		return "";
		//return  Utils.loginControl(req, "redirect:/admin/addCategory");
	}
	
	public String categoryLinkEdit(String data) {
		
		String categoryLink = data.replace(" ", "-");
		System.out.println("link " +categoryLink);
		return categoryLink;
	}
	//dropdown menü doldurma
	@SuppressWarnings("unchecked")
	public List<Category>fillCategoryDropdown(){
		List<Category>ls=new ArrayList<Category>();
		Session sesi=sf.openSession();
		ls=sesi.createQuery("from Category").list();
		System.out.println("ls doldu");
		sesi.close();
		return ls;
	}
	
}
