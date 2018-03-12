package com.javawissen.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Models.Admins;
import Models.Campaigns;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class CampaignsController {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/campaigns", method = RequestMethod.GET)
	public String ornekAc(HttpServletRequest req, Model model) {
		Admins ad =  (Admins) req.getSession().getAttribute("adm");
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")	
		// session get company id 
		List<Campaigns> ls = sesi.createQuery("from Campaigns where campaigncompanyid = '"+ad.getAcompanyid()+"' order by campaignid desc").setMaxResults(10).list();
		// model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("ls", ls);
		sesi.close();
		return Utils.loginControl(req, "admin/campaigns");
	}
	
	// ajaxCampaignsPage
		@ResponseBody
		@RequestMapping(value = "/ajaxCampaignPage", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
		public String ajaxCampaignPage(@RequestParam int itemCount,HttpServletRequest req) {
			Admins ad =  (Admins) req.getSession().getAttribute("adm");
			Session sesi = sf.openSession();
			StringBuilder bl = new StringBuilder();
			@SuppressWarnings("unchecked")
			List<Campaigns> ls = sesi.createQuery("from Campaigns where campaigncompanyid = '"+ad.getAcompanyid()+"' order by campaignid desc").setFirstResult((itemCount -1)  * 10)
					.setMaxResults(10).list();
			for (Campaigns item : ls) {
				String rw = "<tr  role=\"sil\" id=\""+item.getCampaignid()+"\">\r\n" + 
						"													<td>"+item.getCampaignid()+"</td>\r\n" + 
						"													<td>"+item.getCampaigntitle()+"</td>\r\n" + 
						"													<td>"+item.getCampaigndetail() +"</td>\r\n" + 
						"													<td>"+item.getCampaignstartdate() +"</td>\r\n" +
						"													<td>"+item.getCampaignenddate() +"</td>\r\n" +
						"													<td>"+item.getCampaignstatu() +"</td>\r\n" +
						"													<td>"+item.getCampaigntolerance() +"</td>\r\n" +
						"													<td>\r\n" + 
						"														<button onclick=\"fncDelete("+item.getCampaignid()+", 'campaignid' ,'campaigns')\" type=\"button\" class=\"btn btn-danger btn-sm\">Delete</button>\r\n" + 
						"														<a class=\"btn btn-primary btn-sm\" href=\"../admin/campaignEdit/"+item.getCampaignid()+"\" role=\"button\">Edit</a>\r\n" + 
						"													</td>\r\n" + 
						"												</tr>";
				bl.append(rw);
			}

			sesi.close();
			return bl.toString();
		}

	// ajaxPageCount
	@ResponseBody
	@RequestMapping(value = "/campaignPageCount", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String campaignPageCount(HttpServletRequest req) {
		Admins ad =  (Admins) req.getSession().getAttribute("adm");
		StringBuilder bl = new StringBuilder();
		Session sesi = sf.openSession();
		//Long sayi = Utils.rowCount("Campaigns");
		List<Campaigns> ls = sesi.createQuery("from Campaigns where campaigncompanyid = '"+ad.getAcompanyid()+"'").list();
		int sayi = ls.size();
		int boyut=0;
		if(sayi%10==0)
		{
			boyut=sayi/10;
			System.out.println(boyut);
		}
		else
		{
			boyut=(sayi/10)+1;
			System.out.println(boyut);
		}
		for(int i = 1; i<=boyut; i++) {
			bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageOpen("+i+")\">"+i+"</a></li>");
		}
		return bl.toString();
	}
	
	// Search
			int boyut1=0;
			@ResponseBody
			@RequestMapping(value = "/ajaxCampaignSearch", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
			public String ajaxCampaignSearch(@RequestParam String ara,@RequestParam int itemCount,HttpServletRequest req) {
				Admins ad =  (Admins) req.getSession().getAttribute("adm");
				Session sesi = sf.openSession();
				StringBuilder bl = new StringBuilder();
				@SuppressWarnings("unchecked")
				List<Campaigns> ls = sesi.createQuery("from Campaigns where campaigncompanyid = '"+ad.getAcompanyid()+"' and campaigntitle='"+ara+"' or campaigndetail ='"+ara+"'").setFirstResult((itemCount -1)  * 10).setMaxResults(10).list();
				boyut1=ls.size();
				for (Campaigns item : ls) {
					String rw = "<tr  role=\"sil\" id=\""+item.getCampaignid()+"\">\r\n" + 
							"													<td>"+item.getCampaignid()+"</td>\r\n" + 
							"													<td>"+item.getCampaigntitle()+"</td>\r\n" + 
							"													<td>"+item.getCampaigndetail() +"</td>\r\n" + 
							"													<td>"+item.getCampaignstartdate() +"</td>\r\n" +
							"													<td>"+item.getCampaignenddate() +"</td>\r\n" +
							"													<td>"+item.getCampaignstatu() +"</td>\r\n" +
							"													<td>"+item.getCampaigntolerance() +"</td>\r\n" +
							"													<td>\r\n" + 
							"														<button onclick=\"fncDelete("+item.getCampaignid()+", 'campaignid' ,'campaigns')\" type=\"button\" class=\"btn btn-danger btn-sm\">Delete</button>\r\n" + 
							"														<a class=\"btn btn-primary btn-sm\" href=\"../admin/campaignEdit/"+item.getCampaignid()+"\" role=\"button\">Edit</a>\r\n" + 
							"													</td>\r\n" + 
							"												</tr>";
					bl.append(rw);
					
				}
				
	         
				sesi.close();
				return bl.toString();
			}
			
			
			// Search ajaxPageCount
				@ResponseBody
				@RequestMapping(value = "/ajaxCampaignPageCountSearch", method = RequestMethod.POST)
				public String ajaxCampaignPageCountSearch(@RequestParam String ara,HttpServletRequest req) {
					Admins ad =  (Admins) req.getSession().getAttribute("adm");
					StringBuilder bl = new StringBuilder();
					Session sesi = sf.openSession();
					@SuppressWarnings("unchecked")
					List<Campaigns> ls = sesi.createQuery("from Campaigns where campaigncompanyid = '"+ad.getAcompanyid()+"' and campaigntitle='"+ara+"' or campaigndetail ='"+ara+"'").list();
					int sayi = ls.size();
					int boyut=0;
					if(sayi%10==0)
					{
						boyut=sayi/10;
						System.out.println(boyut);
					}
					else
					{
						boyut=(sayi/10)+1;
						System.out.println(boyut);
					}
					for(int i = 1; i<=boyut; i++) {
						bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageSearch("+i+")\">"+i+"</a></li>");
					}
					return bl.toString();
				}
	
	

}
