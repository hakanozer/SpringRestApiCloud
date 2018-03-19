package com.javawissen.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Models.Admins;
import Models.Adress;
import Models.City;
import Models.Companies;
import Models.Customers;
import Models.FileMeta;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class AdminSettingsController {

	// admin ayarlar bölümü
	// admin yeni kayýt
	// Fatma, Mehmetali, Ýlyas
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String login(HttpServletRequest req, Model model) {
		boolean giris = req.getSession().getAttribute("kid") != null;
		if (giris) {
			return "redirect:/admin/dashboard";
		}

		List<City> cityLs = new  UserAdressController().cityFill ();
		model.addAttribute("cityLs", cityLs);
		
		return "admin/register";
	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String adminSettings(HttpServletRequest req,Model model) {
		if (req.getSession().getAttribute("passwordSettingError") != null ) {
			model.addAttribute("passwordSettingError",req.getSession().getAttribute("passwordSettingError"));
		}else if (req.getSession().getAttribute("passwordSettingSuccess") != null) {
			model.addAttribute("passwordSettingSuccess",req.getSession().getAttribute("passwordSettingSuccess"));
		}
		req.getSession().removeAttribute("passwordSettingSuccess");
		req.getSession().removeAttribute("passwordSettingError");
		return "admin/adminSettings";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String adminsave(Companies com, HttpServletRequest req, Adress adr) {
		String answer = "";
		if (!com.getCompanyname().equals("") && !com.getCompanyphone().equals("") && !com.getCompanymail().equals("")
				&& !com.getCompanyfax().equals("")) {

			try {

				com.setCompanyid(Integer.MAX_VALUE);
				Session sesi = sf.openSession();
				Transaction tr = sesi.beginTransaction();
				int id = (Integer) sesi.save(com);

				String apiKey = createApiKey(id);
				com.setCompanyid(id);
				com.setCompanyapikey(Utils.MD5(apiKey));
				sesi.update(com);

				answer = apiKey;
				if (id != 0) {
					FileMeta filemeta = (FileMeta) req.getSession().getAttribute("fileMeta");
					Admins admin = (Admins) req.getSession().getAttribute("adminInfo");
					admin.setAcompanyid(id);
					admin.setApassword(Utils.MD5(admin.getApassword()));
					int adminid = (Integer) sesi.save(admin);
					if (filemeta != null) {
						File file = new File("C:\\xampp\\htdocs\\Profilimages\\" + filemeta.getFileName());
						String uzanti = filemeta.getFileName()
								.substring(filemeta.getFileName().length() - 4, filemeta.getFileName().length());
						file.renameTo(new File("C:\\xampp\\htdocs\\Profilimages\\" + adminid + uzanti ));
						admin.setApicpath(adminid + uzanti);
					} else {
						admin.setApicpath(null);
					}
					sesi.update(admin);
					adr.setAdressid(Integer.MAX_VALUE);
					adr.setAdresscompaniesid(id);

					sesi.save(adr);

				}
				tr.commit();
				sesi.close();

			} catch (Exception e) {
				System.err.println("hata:" + e);
				answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
						+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">Ã—</button>\r\n"
						+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Ayni mail hatasi\r\n"
						+ "              </div>";
			}
		} else {
			answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
					+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">Ã—</button>\r\n"
					+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Alanlar bos olamaz\r\n"
					+ "              </div>";
		}
		// System.out.println(answer);
		return answer;
	}


	@ResponseBody
	@RequestMapping(value = "/next", method = RequestMethod.POST)
	public String adminnext(Admins adm, @RequestParam String apassword1, HttpServletRequest req) {
		String answer = "";

		if (!adm.getAname().equals("") && !adm.getAsurname().equals("") && !adm.getAphone().equals("")
				&& !adm.getAmail().equals("") && !adm.getApassword().equals("")) {

			if (adm.getApassword().equals(apassword1)) {

				Session sesi = sf.openSession();
				try {
					Admins admin = (Admins) sesi.createQuery("from Admins a where a.amail = :mail")
							.setParameter("mail", adm.getAmail()).getSingleResult();
					answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
							+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
							+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Mail Hatasi\r\n"
							+ "              </div>";
					sesi.close();
				} catch (Exception e) {
					adm.setApicpath(""+req.getSession().getAttribute("Apicpath"));
					req.getSession().setAttribute("adminInfo", adm);
					answer = "success";
				}

			} else {
				answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
						+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
						+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Parolalar Uyusmuyor\r\n"
						+ "              </div>";
			}
		} else {
			answer = "       	<div class=\"alert alert-danger alert-dismissible\">\r\n"
					+ "                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n"
					+ "                <h4><i class=\"icon fa fa-ban\"></i>Alert</h4>Alanlar bos olamaz\r\n"
					+ "              </div>";
			System.out.println(answer);
		}

		return answer;
	}

	@ResponseBody
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String adminFileUpload(@RequestParam String filename, HttpServletRequest req , @RequestParam File file) {
		
		try {
			if(file.getPath().length() > 0) {
				System.out.println("path" + file.getAbsolutePath());
			}else {
				System.out.println("dosya gelmedi");
			}
		} catch (Exception e) {
			System.err.println("dosya gelme hatasi"+e);
		}
		
		
		
		String answer = "";
		if (filename.contains("\\")) {
			String name[] = filename.split("\\\\");
			for (String s : name) {
				filename = s;
			}
		}
		
		req.getSession().setAttribute("Apicpath", filename);
		
		return answer;
	}

	public String createApiKey(int id) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhss");
		String apiKey = sdf.format(new Date()) + id;
		apiKey = Utils.MD5(apiKey).substring(0,8);

		return apiKey;
	}
	
	
	@RequestMapping(value = "/newApi", method = RequestMethod.GET)
	public String adminUpdate(HttpServletRequest req, Model model) {
		Session sesi = sf.openSession();
		Transaction tr=sesi.beginTransaction();
		
		Companies compan=(Companies)sesi.createQuery("from  Companies c where c.companyid = :companyid").
				setParameter("companyid", req.getSession().getAttribute("companyid")).getSingleResult();
		
		req.getSession().setAttribute("companyid",compan.getCompanyid());
        String apiKey;
		apiKey = createApiKey(compan.getCompanyid());
		compan.setCompanyapikey(Utils.MD5(apiKey));
		try {
			sesi.update(compan);
			tr.commit();

		    model.addAttribute("newapisuccess",apiKey);

		} catch (Exception e) {

			 model.addAttribute("newapierror","yeni api basarisiz");
		}
		sesi.close();

		return "admin/adminSettings";

	}
	
	
	// Admin password change  prossess
	
	@RequestMapping(value = "/passwordSetting", method = RequestMethod.POST)
	public String adminPasswordSetting(HttpServletRequest req, @RequestParam String apassword, @RequestParam String apassword1, @RequestParam String apassword2 ) {
		//old password check
		Admins adm = (Admins) req.getSession().getAttribute("adm");
		boolean check = adm.getApassword().equals(Utils.MD5(apassword));
		boolean newPasswordCheck = apassword1.equals(apassword2);
		
	
		
		if (check) {
			if (newPasswordCheck) {
				try {
					Session sesi = sf.openSession();
					Transaction tr = sesi.beginTransaction();
					adm.setApassword(Utils.MD5(apassword1));
					sesi.update(adm);
					tr.commit();
					sesi.close();
					req.getSession().setAttribute("adm",adm);
					req.getSession().setAttribute("passwordSettingSuccess", "Sifre degistirme basarili!");
				} catch (Exception e) {
					System.out.println("HATAA:"+e);
				}
				
			} else {
				req.getSession().setAttribute("passwordSettingError", "Lutfen yeni sifre tekrarinizi dogru giriniz");
			}
		} else {
			req.getSession().setAttribute("passwordSettingError", "Lutfen eski sifrenizi dogru giriniz");
		}
		
		return "redirect:/admin/settings";
	}
	
	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	FileMeta fileMeta = null;

	@RequestMapping(value = "/profilimgupload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request) {
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		if (request.getSession().getAttribute("fileMeta") != null) {
			
			FileMeta oldfilemeta = (FileMeta) request.getSession().getAttribute("fileMeta");
			System.out.println(new File("C:\\xampp\\htdocs\\Profilimages\\" + oldfilemeta.getFileName()).delete());
			System.out.println("old file meta:"+oldfilemeta.getFileName());
		}
		
			
		while (itr.hasNext()) {

			mpf = request.getFile(itr.next());
			String tur = ".jpg";

			if (mpf.getContentType() == "image/jpeg") {
				tur = ".jpg";
			}

			String dosyaAdi = getDateTime() + tur;
			if (files.size() >= 10)
				files.pop();

			fileMeta = new FileMeta();
			fileMeta.setFileName(dosyaAdi);
			fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
			fileMeta.setFileType(mpf.getContentType());

			try {
				fileMeta.setBytes(mpf.getBytes());
				request.getSession().setAttribute("fileMeta", fileMeta);
				FileCopyUtils.copy(fileMeta.getBytes(),
						new FileOutputStream("C:\\xampp\\htdocs\\Profilimages\\" + fileMeta.getFileName()));

			} catch (Exception e) {
				System.err.println("Ekleme HatasÃ½ " + e);
			}
			files.add(fileMeta);
		}
		return files;

	}

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
