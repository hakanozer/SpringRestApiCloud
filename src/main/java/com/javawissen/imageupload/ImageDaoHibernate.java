
package com.javawissen.imageupload;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Utils.HibernateUtil;


@Repository
@Transactional
public class ImageDaoHibernate implements ImageDao {
    
    private static final Logger log = LoggerFactory.getLogger(ImageDaoHibernate.class);
    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    @Transactional(readOnly = true)
    public List<Image> list(Integer productID) {
    	Session sesi = sf.getCurrentSession();
    	Transaction tr = sesi.beginTransaction();
        log.debug("List of images");
        //Query query = sesi.getNamedQuery("images");
        List<Image> images = sesi.createQuery("from Image where productId = :id").setParameter("id", productID).list();
        tr.commit();
        sesi.close();
        return images;
    }

    @Override
    public Image create(Image image) {
        log.debug("Creating image");
        Session sesi = sf.getCurrentSession();
    	Transaction tr = sesi.beginTransaction();
    	sesi.save(image);
    	tr.commit();
    	sesi.close();
        return image;
    }

    @Override
    @Transactional(readOnly = true)
    public Image get(Long id) {
        log.debug("Getting image {}", id);
        Session sesi = sf.getCurrentSession();
    	Transaction tr = sesi.beginTransaction();
        Image image = (Image) sesi.get(Image.class, id);
        tr.commit();
        sesi.close();
        return image;
    }

    @Override
    public void delete(Image image) {
        log.debug("Deleting image {}", image.getName());
        Session sesi = sf.getCurrentSession();
    	Transaction tr = sesi.beginTransaction();
        sesi.delete(image);
        tr.commit();
        sesi.close();
    }
    
}
