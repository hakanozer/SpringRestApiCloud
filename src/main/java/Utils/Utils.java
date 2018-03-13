package Utils;

import java.util.Base64;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Utils {
	
	
	public static Long rowCount(String tableName) {
		Session sesi = HibernateUtil.getSessionFactory().openSession();
		Long  rowCount = (Long) sesi.createQuery("select count(*) from "+tableName+" ").uniqueResult(); 
		System.out.println("rowCount" + rowCount);
		@SuppressWarnings("unused")
		Long pageCount = 0L;
		if (rowCount % 10 == 0) {
			pageCount = rowCount / 10;
		}else {
			pageCount = (rowCount / 10) + 1;
		}
		sesi.close();
		return pageCount;
	}

	
	public static Long rowCount(String tableName,int condition) {
		Session sesi = HibernateUtil.getSessionFactory().openSession();
		Long  rowCount = (Long) sesi.createQuery("select count(*) from "+tableName+" where ordercustomerid=:customerid")
				.setParameter("customerid", condition).uniqueResult(); 
		//System.out.println("rowCount" + rowCount);
		@SuppressWarnings("unused")
		Long pageCount = 0L;
		if (rowCount % 10 == 0) {
			pageCount = rowCount / 10;
		}else {
			pageCount = (rowCount / 10) + 1;
		}
		sesi.close();
		return pageCount;
	}
	public static String loginControl(HttpServletRequest req, String sayfa) {

		// çerez var mý ?
		if (req.getCookies() != null) {
			Cookie[] dizi = req.getCookies();
			for (Cookie item : dizi) {
				if (item.getName().equals("cerez")) {
					String kid = Utils.sifreCoz(item.getValue(), 3);
					req.getSession().setAttribute("kid", kid);
					break;
				}
			}
		}

		boolean oturumDurum = req.getSession().getAttribute("kid") == null;
		if (oturumDurum) {
			return "redirect:/admin/";
		} else {
			return sayfa;
		}
	}

	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

	public static String sifrele(String data, int i) {
		byte[] dizi = null;
		Random rd = new Random();
		int ri = rd.nextInt(899) + 100;
		for (int j = 0; j < i; j++) {
			dizi = Base64.getEncoder().encode(data.getBytes());
			data = new String(dizi);
		}
		String sifrelenmis = new String(dizi) + MD5("" + ri);
		System.out.println("sifrelenmis" + sifrelenmis);
		return sifrelenmis;
	}

	public static String sifreCoz(String data, int i) {
		byte[] dizi = null;
		data = data.substring(0, data.length() - 32);
		for (int j = 0; j < i; j++) {
			dizi = Base64.getDecoder().decode(data.getBytes());
			data = new String(dizi);
		}
		String cozulmus = new String(dizi);
		System.out.println("cozulmus" + cozulmus);
		return cozulmus;
	}

}
