package com.wissen.restapi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import Models.Products;
import Models.jsonproducts;
import Utils.DB;

@RestController
@RequestMapping(value="/api")
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
	
	DB db=new DB("jsoncloud","root","");
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public HashMap<String, Object> allProducts() {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		List<jsonproducts> ls = new ArrayList<jsonproducts>();
		try {
			String q = "{call productsimage()}";
			ResultSet rs = db.baglan().executeQuery(q);
			while (rs.next()) {
				jsonproducts prd = new jsonproducts();
		       
				prd.setCampaigntitle(rs.getString("campaigntitle"));
				prd.setCategorytitle(rs.getString("categorytitle"));
				prd.setCompanyname(rs.getString("companyname"));
				prd.setProductdescription(rs.getString("productdescription"));
				prd.setProductdetail(rs.getString("productdetail"));
				prd.setProductprice(rs.getBigDecimal("productprice"));
				prd.setProducttitle(rs.getString("producttitle"));
				prd.setProducttype(rs.getString("producttype"));
				
				
				if(rs.getString("newFilename")!=null)
				{
				prd.setNewFilename(rs.getString("newFilename"));
				prd.setThumbnailFilename(rs.getString("thumbnailFilename"));
				prd.setImage("true");
				}
				else
				{
					
					prd.setImage("false");
				}
				
				
				ls.add(prd);
			}
			
			String qq = "{call productswithoutimage()}";
			ResultSet rss = db.baglan().executeQuery(qq);
			while (rss.next()) {
				jsonproducts prd = new jsonproducts();
		       
				prd.setCampaigntitle(rss.getString("campaigntitle"));
				prd.setCategorytitle(rss.getString("categorytitle"));
				prd.setCompanyname(rss.getString("companyname"));
				prd.setProductdescription(rss.getString("productdescription"));
				prd.setProductdetail(rss.getString("productdetail"));
				prd.setProductprice(rss.getBigDecimal("productprice"));
				prd.setProducttitle(rss.getString("producttitle"));
				prd.setProducttype(rss.getString("producttype"));
				prd.setImage("false");
				
				
				
				ls.add(prd);
			}
			
			hm.put("durum", true);
			hm.put("mesaj", "products tablosu getirme basarili");
			hm.put("products", ls);
		} catch (Exception e) {
			hm.put("durum", false);
			hm.put("mesaj", "products tablosu getirme basarisiz");
			System.err.println("HATA:" + e);
		
		}
		return hm;

	}
	
}
