package com.wissen.restapi;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Models.Basket;
import Models.Viewbasketlist;
import Models.Vieworderlist;
import Models.Viewproductlist;
import Utils.HibernateUtil;



@Controller
@RestController
@RequestMapping(value = "/admin")
public class ordersApi {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/orderManagement/2", method = RequestMethod.GET)
	public HashMap<String, Object> allBasket() {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		try {
			Session sesi=sf.openSession();
			@SuppressWarnings("unchecked")
			List<Viewbasketlist> basketLs=sesi.createQuery("from Viewbasketlist").getResultList();
	
			sesi.close();
			hm.put("durum", true);
			hm.put("mesaj", "basket tablosu getirme basarili");
			hm.put("basketlist", basketLs);
		} catch (Exception e) {
			hm.put("durum", false);
			hm.put("mesaj", "basket tablosu getirme basarisiz");
			System.err.println("HATA:" + e);
		}
		return hm;
}
	
	@RequestMapping(value = "/productRemove/{basketid}", method = RequestMethod.GET)
	public HashMap<String, Object> productRemove(@PathVariable int basketid) {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		try {
			Session sesi1=sf.openSession();
			Transaction tr=sesi1.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Basket> removeLs=sesi1.createQuery("from Basket where basketid=:basketid").setParameter("basketid", basketid).getResultList();
			Basket bL=new Basket();
			bL.setBasketid(basketid);
			sesi1.flush ();
			sesi1.clear ();
			sesi1.delete(bL);
			
			
			tr.commit();
			sesi1.close();
			if(removeLs.size() > 0) {
				System.out.println("remove un içindeyim1");
				hm.put("durum", true);
				hm.put("mesaj", "silme basarili");
				hm.put("orderlist", removeLs);
			}
			System.out.println("remove un içindeyim2");
		} catch (Exception e) {
			hm.put("durum", false);
			hm.put("mesaj", "silme basarisiz");
			System.err.println("HATA:" + e);
		}
		return hm;
}
	
}