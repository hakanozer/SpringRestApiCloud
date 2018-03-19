package com.javawissen.admin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Models.Basket;
import Models.Orders;
import Models.Viewbasketlist;
import Utils.HibernateUtil;

@Controller
@RequestMapping(value = "/admin")
public class ShoppingCartController {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	int cid = 0;
	int total = 0;
	Date date = new Date();

	@RequestMapping(value = "/shoppingCart/{cid}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String shoppingCart(@PathVariable int cid, Model model) {
		this.cid = cid;
		System.out.println(cid);

		total = 0;
		Date date = new Date();
		try {
			Session sesi = sf.openSession();
			@SuppressWarnings("unchecked")
			List<Viewbasketlist> basketLs = sesi.createQuery("from Viewbasketlist where basketcustomerid =:cid ")
					.setParameter("cid", cid).getResultList();
			sesi.close();

			if (basketLs.size() > 0) {
				for (Viewbasketlist item : basketLs) {
					total += Integer.valueOf(item.getBasketproductcount());
					System.out.println("product: " + item.getProducttitle());
					if (item.getCampaignstartdate() == null && item.getCampaignenddate() == null) {
						item.setCampaigntitle(null);

					} else {
						if (date.after(item.getCampaignstartdate()) && date.before(item.getCampaignenddate())) {
							continue;
						} else {

							item.setCampaigntitle(null);

						}
					}
				}
				for (Viewbasketlist item : basketLs) {
					System.out.println(item.getCampaigntitle());
					System.out.println("getCampaignstatu : " + item.getCampaignstatu());
				}
				model.addAttribute("custid", cid);
				model.addAttribute("total", total);
				model.addAttribute("basketLs", basketLs);
			}
		} catch (Exception e) {
			System.err.println("Sepet Getirme Hatasi:" + e);
		}
		return "admin/shoppingCart";
	}

	// Remove Product from Cart
	@ResponseBody
	@RequestMapping(value = "/productRemove", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String orderProductRemove(HttpServletRequest req, Model model, @RequestParam int bid) {
		String result = "";
		System.out.println("ben geldim");
		try {
			Session sesi = sf.openSession();
			Transaction tr = sesi.beginTransaction();
			Basket b = new Basket();
			b.setBasketid(bid);
			sesi.delete(b);
			tr.commit();
			sesi.close();

			shoppingCart(this.cid, model);
			int newTotal = this.total;
			result = "Your Basket Has " + newTotal + " in Count";
			System.out.println("total: " + newTotal);
		} catch (Exception e) {
			System.err.println("Ürün silme Hatasi: " + e);
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/productRemoveFromBasket", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String orderProductRemoveFromBasket(HttpServletRequest req, Model model, @RequestParam int bid,
			@RequestParam int count) {
		Date date = new Date();
		String result = "";
		try {
			Session sesi1 = sf.openSession();
			@SuppressWarnings("unchecked")
			List<Basket> basketLs = sesi1.createQuery("from Basket where basketid  =:basketid")
					.setParameter("basketid", bid).getResultList();
			sesi1.close();
			if (basketLs.size() > 0) {
				Session sesi = sf.openSession();
				Transaction tr = sesi.beginTransaction();
				Basket b = new Basket();
				b.setBasketid(bid);
				b.setBasketcustomerid(basketLs.get(0).getBasketcustomerid());
				b.setBasketproductid(basketLs.get(0).getBasketproductid());
				b.setBasketproductcount(basketLs.get(0).getBasketproductcount() + (count));
				b.setBasketdate(basketLs.get(0).getBasketdate());
				sesi.update(b);
				tr.commit();
				sesi.close();
			}
			Session sesi3 = sf.openSession();
			StringBuilder bl = new StringBuilder();
			@SuppressWarnings("unchecked")
			List<Viewbasketlist> bLs = sesi3.createQuery("from Viewbasketlist where basketcustomerid =:cid ")
					.setParameter("cid", this.cid).getResultList();
			double price = 0;
			System.out.println("view basket boyut :" + bLs.size());
			for (Viewbasketlist item : bLs) {
				price = item.getProductprice().doubleValue();
				if (item.getCampaignstartdate() == null && item.getCampaignenddate() == null) {
					item.setCampaigntitle(null);

				} else {
					if (date.after(item.getCampaignstartdate()) && date.before(item.getCampaignenddate())) {
						if (item.getCampaignstatu() == 0) {
							price = item.getProductprice().doubleValue();
							price = price - (price * (item.getCampaigntolerance() / 100));
							System.out.println("price: " + price);
						} else {

							price = price - (price - item.getCampaigntolerance());
							System.out.println("price: " + price);
						}
					} else {
						System.out.println(item.getCampaigntitle());
						item.setCampaigntitle(null);
						System.out.println(item.getCampaigntitle());
					}
				}
				String rw = "<tr  role=\"set\" id=\"" + item.getBasketid() + "\">\r\n"
						+ "													<td>" + item.getBasketid() + "</td>\r\n"
						+ "													<td>" + item.getProducttitle() + "</td>\r\n"
						+ "													<td>" + item.getProductdetail()
						+ "</td>\r\n" + "													<td>"
						+ item.getCategorytitle() + "</td>\r\n"
						+ "													<td>" + price + "</td>\r\n"
						+ "													<td>" + item.getBasketproductcount()
						+ "</td>\r\n" + "													<td>"
						+ item.getBasketproductcount() * price + "</td>\r\n"
						+ "													<td>\r\n "
						+ "														<button onclick=\"azalt("
						+ item.getBasketid() + "," + item.getBasketproductcount()
						+ ")\" type=\"button\"  style=\"color:black;\"  class=\"glyphicon glyphicon-minus\"></button>\r\n"
						+ "														<button onclick=\"arttir("
						+ item.getBasketid()
						+ ")\" type=\"button\"  style=\"color:black;\"  class=\"glyphicon glyphicon-plus\"></button>\r\n"
						+ "													</td>\r\n" +

						"													<td>\r\n"
						+ "														<button onclick=\"ProductCartRemove("
						+ item.getBasketid()
						+ ")\" type=\"button\"  style=\"color:red;\"  class=\"fa fa-trash-o\"></button>\r\n"
						+ "												</td>\r\n"
						+ "												</tr>";

				bl.append(rw);

			}
			sesi3.close();
			return bl.toString();

		} catch (Exception e) {
			System.err.println("Ürün silme Hatasi: " + e);
		}
		return result;
	}

	@RequestMapping(value = "/shoppingCartOrder/{id}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String ordersSave(HttpServletRequest req, Model model, @PathVariable int id) {
		int companyid = (Integer) req.getSession().getAttribute("companyid");
		try {
			Session sesi = sf.openSession();
			@SuppressWarnings("unchecked")
			List<Viewbasketlist> basketLs = sesi
					.createQuery("from Viewbasketlist where basketcustomerid  =:basketcustomerid")
					.setParameter("basketcustomerid", id).getResultList();
			sesi.close();

			for (Viewbasketlist item : basketLs) {
				Session sesi1 = sf.openSession();
				Transaction tr = sesi1.beginTransaction();
				Orders or = new Orders();
				or.setOrdercompanyid(companyid);
				or.setOrdercustomerid(id);
				or.setOrderproductids(String.valueOf(item.getProductid()));
				or.setOrdercounts(String.valueOf(item.getBasketproductcount()));
				if (item.getCampaignstartdate() == null && item.getCampaignenddate() == null) {
					BigDecimal b = new BigDecimal(item.getBasketproductcount() * item.getProductprice().doubleValue());
					or.setOrdertotalprice(b);
				} else {
					if (date.after(item.getCampaignstartdate()) && date.before(item.getCampaignenddate())) {
						if (item.getCampaignstatu() == 1) {
							BigDecimal b = new BigDecimal(item.getBasketproductcount()
									* (item.getProductprice().doubleValue() - item.getCampaigntolerance()));
							or.setOrdertotalprice(b);
						} else if (item.getCampaignstatu() == 0) {
							BigDecimal b = new BigDecimal(item.getBasketproductcount() * (item.getProductprice()
									.doubleValue()
									- (item.getProductprice().doubleValue() * (item.getCampaigntolerance() / 100))));
							or.setOrdertotalprice(b);
						}
					} else {
						BigDecimal b = new BigDecimal(
								item.getBasketproductcount() * item.getProductprice().doubleValue());
						or.setOrdertotalprice(b);
					}
					or.setOrderstatus((byte) 0);
					or.setOrderdate(date);

					sesi1.save(or);
					tr.commit();
					sesi1.close();
				}

			}
			// Clear Basket

			Session sesi2 = sf.openSession();
			Transaction tr = sesi2.beginTransaction();
			for (Viewbasketlist item : basketLs) {
				Basket b = new Basket();
				b.setBasketid(item.getBasketid());
				sesi2.delete(b);
				tr.commit();
				sesi2.close();

			}

		} catch (Exception e) {
			System.err.println("Sipariş kaydetme hatası:" + e.getMessage());
		}
		return "admin/order";
	}
}
