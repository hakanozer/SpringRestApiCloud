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

import Models.Sample;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping(value = "/admin")
public class SampleController {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String ornekAc(HttpServletRequest req, Model model) {
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Sample> ls = sesi.createQuery("from Sample order by sid desc").setMaxResults(10).list();
		//model.addAttribute("pageCount", Utils.rowCount("Sample"));
		model.addAttribute("ls", ls);
		sesi.close();
		return Utils.loginControl(req, "admin/sample");
	}

	// ajaxSamplePage
	@ResponseBody
	@RequestMapping(value = "/ajaxSamplePage", method = RequestMethod.POST)
	public String ajaxSamplePage(@RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Sample> ls = sesi.createQuery("from Sample order by sid desc").setFirstResult((itemCount -1)  * 10)
				.setMaxResults(10).list();
		for (Sample item : ls) {
			String rw = "<tr  role=\"sil\" id=\""+item.getSid()+"\">\r\n" + 
					"													<td>"+item.getSid()+"</td>\r\n" + 
					"													<td>John Doe</td>\r\n" + 
					"													<td>11-7-2014</td>\r\n" + 
					"													<td><span class=\"label label-success\">Approved</span></td>\r\n" + 
					"													<td>\r\n" + 
					"														<button onclick=\"fncDelete("+item.getSid()+", 'sid' ,'sample')\" type=\"button\" class=\"btn btn-danger btn-sm\">Sil</button>\r\n" + 
					"														<button type=\"button\" class=\"btn btn-primary btn-sm\">Düzenle</button>\r\n" + 
					"													</td>\r\n" + 
					"												</tr>";
			bl.append(rw);
		}

		sesi.close();
		return bl.toString();
	}
	
	
	// ajaxPageCount
		@ResponseBody
		@RequestMapping(value = "/ajaxPageCount", method = RequestMethod.POST)
		public String ajaxPageCount() {
			StringBuilder bl = new StringBuilder();
			Long sayi = Utils.rowCount("Sample");
			for(int i = 1; i<=sayi; i++) {
				bl.append("<li><a style=\"cursor: pointer;\" onclick=\"pageOpen("+i+")\">"+i+"</a></li>");
			}
			return bl.toString();
		}

		// Sample Add
		@RequestMapping(value = "/sampleAdd", method = RequestMethod.GET)
		public String sampleAdd() {
			return "admin/sampleAdd";
		}
		
		
}
