package com.wissen.restapi;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Models.Companies;
import Models.Products;
import Utils.HibernateUtil;

@RestController
public class ProductApi {


	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/{apiKey}/campaignsProducts/{campaignid}", method = RequestMethod.GET)
	public HashMap<String, Object> campaignsProducts(HttpServletRequest req, @PathVariable Integer campaignid,
			@PathVariable String apiKey) {
		Session sesi = sf.openSession();
		HashMap<String, Object> hm = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		List<Companies> lc = sesi.createQuery("from Companies where companyapikey = '" + apiKey + "' ").list();
		if (lc.size() < 1) {
			hm.put("status", false);
			hm.put("message", "Company Apikey Error !");
		} else {
			try {
				@SuppressWarnings("unchecked")
				List<Products> ls = sesi.createQuery("from Products where productcompanyid = '"
						+ lc.get(0).getCompanyid() + "' and productcampaignid = '" + campaignid + "' ").list();
				if(ls.size()<1) {
					hm.put("status", false);
					hm.put("message", "Products Listing Failed");
				}else {
					hm.put("status", true);
					hm.put("message", "Products Listing Successful");
					hm.put("admins", ls);
				}
				
			} catch (Exception e) {
				hm.put("status", false);
				hm.put("message", "Products Listing Failed");
				System.err.println("Hata : " + e);

			}
		}

		return hm;
	}
	

}
