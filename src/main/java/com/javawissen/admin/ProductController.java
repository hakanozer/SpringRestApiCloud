package com.javawissen.admin;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Models.Campaigns;
import Models.Category;
import Models.Products;
import Models.Productsview;
import Models.Sample;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class ProductController {

	// ürün ekleme düzenleme silme listeleme
	// Ramazan, Hüssam, Muharrem, Enes
	SessionFactory sf = HibernateUtil.getSessionFactory();

	
	@ResponseBody
	@RequestMapping(value = "/productInsert", method = RequestMethod.POST)
	public String productInsert(Products prd) {
		
	
		System.out.println("insert iþlemi");
		System.out.println("kampanya id"+prd.getProductcampaignid());
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		// int yaz=(Integer) sesi.save(prd);
		int readStatu = (Integer) sesi.save(prd);
		tr.commit();
		sesi.close();

		if (readStatu > 0) {
			return "true";
		}else {
			return "";
		}
	}
	
	int urunid;
	@RequestMapping(value = "/productUpdate/{proid}", method = RequestMethod.GET)
	public String productUpdateGET(@PathVariable Integer proid, Model model ) {
		Session sesi = sf.openSession();
		List<Products> ls = sesi.createQuery("from Products where productid= "+proid+" ").list();
        sesi.close();
        String dd=ls.get(0).getProductcategoryid().replaceAll(",", "");
        urunid=proid;
		Session sesii = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Category> lc = sesii.createQuery("from Category where categorycompanyid=1").list();
		// model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("lc", lc);
        sesii.close();
        
        Session sesiii = sf.openSession();
		
		@SuppressWarnings("unchecked")
		List<Campaigns> lcampaign = sesiii.createQuery("from Campaigns where campaigncompanyid=1").list();
		// model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("lcampaign", lcampaign);

		sesiii.close();
		
        model.addAttribute("ls", ls);
		model.addAttribute("lcat", dd.toCharArray());
	  
		
		return "admin/productUpdate";
	}
	
	@ResponseBody
	@RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
	public String productUpdate(Products p) {
		try {
			p.setProductid(urunid);
		
			Session sesi = sf.openSession();
			Transaction tr = sesi.beginTransaction();
			// int yaz=(Integer) sesi.save(prd);
		    sesi.update(p);
			tr.commit();
			sesi.close();
			return "basarili";
		} catch (Exception e) {
			return "";
		}

	}
	
	
}
