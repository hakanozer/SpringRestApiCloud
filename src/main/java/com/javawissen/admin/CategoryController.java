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

import Models.Category;
import Models.Sample;
import Utils.HibernateUtil;
import Utils.Utils;

@Controller
@RequestMapping (value="/admin")
public class CategoryController {
	
	// yeni kategori ekle, düzenle, listei, silme
	// Zeki, Sema
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@RequestMapping (value="/category",method = RequestMethod.GET)
	public String category(HttpServletRequest req, Model model) {
		Session sesi = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Category> ls = sesi.createQuery("from Category order by categorysort desc").setMaxResults(10).list();
		model.addAttribute("ls", ls);
		sesi.close();
		return Utils.loginControl(req, "admin/category");
	}
	// ajaxCategoryPage
	@ResponseBody
	@RequestMapping(value = "/ajaxCategoryPage", method = RequestMethod.POST)
	public String ajaxCategoryPage(@RequestParam int itemCount) {
		Session sesi = sf.openSession();
		StringBuilder bl = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<Category> ls = sesi.createQuery("from Category order by sid desc").setFirstResult((itemCount -1)  * 10)
				.setMaxResults(10).list();
		for (Category item : ls) {
			String rw = "<tr  role=\"sil\" id=\""+item.getCategoryid()+"\">\r\n" + 
					"													<td>"+item.getCategoryid()+"</td>\r\n" + 
					"													<td>"+item.getCategorytitle()+"</td>\r\n" + 
					"													<td>"+item.getCategorydescription() +"</td>\r\n" + 
					"													<td><span class=\"label label-success\">Approved</span></td>\r\n" + 
					"													<td>\r\n" + 
					"														<button onclick=\"fncDelete("+item.getCategoryid()+", 'Categoryid' ,'Category')\" type=\"button\" class=\"btn btn-danger btn-sm\">Sil</button>\r\n" + 
					"														<button type=\"button\" class=\"btn btn-primary btn-sm\">Düzenle</button>\r\n" + 
					"													</td>\r\n" + 
					"												</tr>";
			bl.append(rw);
		}

		sesi.close();
		return bl.toString();
	}
	
	
	@RequestMapping (value="/addCategory",method = RequestMethod.GET)
	public String addCategory() {
		
		return "admin/addCategory";
	}
}
