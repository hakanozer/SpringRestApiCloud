package com.wissen.restapi;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Models.Admins;
import Models.Adress;
import Utils.HibernateUtil;

public class UserAddressApi {
	/* 
	Görev Alan Kiþiler: Sinem Çekiç - Elif Kirazcý
	statu: fail, true,
	message: "",
	 1- Adres Ekle: 
	 Veritabanýnda istenen bütün bilgiler
	 2- Adres Düzenle:
	  Veritabanýnda istenen bütün bilgiler
	 3- Kullanýcý adresleri listeleme:
	 istenen parametre : kullanýcý id'si
	 Kullanýcýya ait bütün adresler listelenecek
	 */
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	//UserAddress Add

@RequestMapping(value="/useraddressapi" ,method=RequestMethod.GET)
	public HashMap<String,Object> userAddressAdd(Adress adr) {
	HashMap<String, Object> hm1 = new HashMap<String, Object>();
	try {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		
		sesi.save(adr);
		tr.commit();
		sesi.close();
		
		 hm1.put("status", true);
		 hm1.put("message", "Add successfull");
		 hm1.put("Adress" , adr);
	} catch (Exception e) {
		 hm1.put("status", false);
		 hm1.put("message", "Add failed");
		 System.err.println("Error : " +e);
	}
		return hm1;
	}

	//UserAddress Listing 

	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/useraddressapilist" , method = RequestMethod.GET)
	public HashMap<String, Object> userAddressList(HttpServletRequest req) {
		Session sesi = sf.openSession();
		req.getSession().getAttribute("kid");
		Admins admin = (Admins) sesi.createQuery("from Admins a where a.aid = :kid").
				setParameter("kid",req.getSession().getAttribute("kid") ).getSingleResult();
		HashMap<String, Object> hm = new HashMap<String, Object>();
		try {
			//List<Adress>als= sesi.createQuery("from Adress where adresscompaniesid = :acomid").setParameter("acomid",Integer.parseInt(admin.getAcompanyid())).list();
			List<Adress>als= (List<Adress>) sesi.createQuery("from Adress where adresscompaniesid = 20");
			sesi.close();
			 hm.put("status", true);
			 hm.put("message", "Listing successfull");
			 hm.put("Adress" , als);
		}  catch (Exception e) {
			 hm.put("status", false);
			 hm.put("message", "Listing failed");
			 System.err.println("Error : " +e); 
		}
		return hm;
	} 

}
