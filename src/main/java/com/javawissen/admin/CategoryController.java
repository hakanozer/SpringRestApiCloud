package com.javawissen.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value="/admin")
public class CategoryController {
	
	// yeni kategori ekle, düzenle, listei, silme
	// Zeki, Sema
	@RequestMapping (value="/category",method = RequestMethod.GET)
	public String category() {
		
		
		return "admin/category";
	}
	@RequestMapping (value="/addCategory",method = RequestMethod.GET)
	public String addCategory() {
		
		return "admin/addCategory";
	}
}
