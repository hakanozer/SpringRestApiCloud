package com.wissen.restapi;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Models.Companies;
import Models.Products;
import Utils.HibernateUtil;

public class ProductApi {

	/*
	
	Ramazan Iþýk- Hüssam Durak - Enes Taþdemir-Muharrem DÝDÝCÝ
	statu: fail, true,
	message: "",
	1- Tüm ürünleri listele
	2- Kategori id sine göre ürünleri listele
	3- Ürünleri count lü listele : 0 ,10
	4- kampanyalý ürünler
	5- Kampanyaya id'sine dahil olan ürünler
	
	Not: Bütün ürülerin birden fazla resmi olabilir, resmi olmama durumuda var.
	image:false, image:true
	images:[
		{
			normal:
			thun:
		}
	]
	
	*/
	
	SessionFactory sf = HibernateUtil.getSessionFactory();


	@RequestMapping(value = "/{apiKey}/campaignsProducts/{campaignid}", method = RequestMethod.GET)
	public HashMap<String, Object> campaignsProducts(HttpServletRequest req, @PathVariable Integer campaignid,
			@PathVariable String apiKey) {
		Session sesi = sf.openSession();
		HashMap<String, Object> hm = new HashMap<String, Object>();

		List<Companies> lc = sesi.createQuery("from Companies where companyapikey = '" + apiKey + "' ").list();
		if (lc.size() < 1) {
			hm.put("status", false);
			hm.put("message", "Company Apikey Error !");
		} else {
			try {
				List<Products> ls = sesi.createQuery("from Products where productcompanyid = '"+lc.get(0).getCompanyid()+"' and productcampaignid = '"+campaignid+"' ").list();
				hm.put("status", true);
				hm.put("message", "Campaigns Listing Successful");
				hm.put("admins", ls);
			} catch (Exception e) {
				hm.put("status", false);
				hm.put("message", "Campaigns Listing Failed");
				System.err.println("Hata : " + e);

			}
		}

		return hm;
	}
	
}
