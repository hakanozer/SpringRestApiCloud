package com.javawissen.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Models.Admins;
import Utils.DB;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	DB db = new DB();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(HttpServletRequest req, Model model) {
		boolean giris = req.getSession().getAttribute("kid") != null;
		if (giris) {
			return "redirect:/admin/dashboard";
		}
		boolean hata = req.getSession().getAttribute("hata") != null;
		if(hata) {
			String ht =""+req.getSession().getAttribute("hata");
			model.addAttribute("hata", ht);
			req.getSession().removeAttribute("hata");
		}
		return "admin/login";
	}

	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminGiris(Admins admins, Model model, HttpServletRequest req,
			HttpServletResponse res) {
		
		if (admins.getAmail().equals("") || admins.getApassword().equals("")) {
			req.getSession().setAttribute("hata", "Kullanýcý adý yada þifre boþ olamaz !");
			return "redirect:/admin/";
		}
		
		Admins admin = null;
		Session sesi = sf.openSession();
		try {
			admins.setApassword((Utils.MD5(admins.getApassword()))); // þifreleme yap
			admin = (Admins) sesi.createQuery("from Admins a where a.amail = :amail and a.apassword = :apassword")
					.setParameter("amail", admins.getAmail()).setParameter("apassword", admins.getApassword()).getSingleResult();
			
		} catch (Exception e) {
			System.err.println("Giris Hatasi : " + e);
		}
		sesi.close();
		
		if (admin != null) {
			// entry admin
			req.getSession().setAttribute("kid", admin.getAid());
			req.getSession().setAttribute("adm", admin);
			if (admins.getRememberMe() != null && admins.getRememberMe().equals("on")) {
				// beni hatýrla seçilmiþ
				Cookie cerez = new Cookie("cerez", Utils.sifrele(""+admin.getAid(), 3));
				cerez.setMaxAge(60 * 60); // 1 saat boyunca beni hatýrla
				res.addCookie(cerez);
			}
			return "redirect:/admin/dashboard";
		} else {
			req.getSession().setAttribute("hata", "Kullanýcý adý yada þifre hatalý");
			return "redirect:/admin/";
		}
	}

	
	
	// çýkýþ yap
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String cikisYap(HttpServletRequest req, HttpServletResponse res) {

		// tekil oturum kapatma
		req.getSession().removeAttribute("kid"); // sadece kid sessioný siler
		req.getSession().invalidate(); // tüm oturularý sil

		// beni hatýrla varsa çerezi öldür.
		if (req.getCookies() != null) {
			Cookie[] dizi = req.getCookies();
			for (Cookie item : dizi) {
				if (item.getName().equals("cerez")) {
					Cookie cerez = new Cookie("cerez", "");
					cerez.setMaxAge(0);
					res.addCookie(cerez);
				}
			}
		}
		return "redirect:/admin/";
	}

}
