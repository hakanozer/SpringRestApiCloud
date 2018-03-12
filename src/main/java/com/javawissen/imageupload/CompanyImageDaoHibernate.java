
package com.javawissen.imageupload;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Models.Companyimage;
import Utils.HibernateUtil;


@Repository
@Transactional
public class CompanyImageDaoHibernate implements CompanyImageDao {
    
    private static final Logger log = LoggerFactory.getLogger(CompanyImageDaoHibernate.class);
    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    @Transactional(readOnly = true)
    public List<Companyimage> list(Integer companyId) {
    	Session sesi = sf.getCurrentSession();
    	Transaction tr = sesi.beginTransaction();
        log.debug("List of images");
        //Query query = sesi.getNamedQuery("images");
        List<Companyimage> images = sesi.createQuery("from Companyimage where companyId = :id").setParameter("id", companyId).list();
        tr.commit();
        sesi.close();
        return images;
    }

    @Override
    public Companyimage create(Companyimage image) {
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
    public Companyimage get(Long id) {
        log.debug("Getting image {}", id);
        Session sesi = sf.getCurrentSession();
    	Transaction tr = sesi.beginTransaction();
    	Companyimage image = (Companyimage) sesi.get(Companyimage.class, id);
        tr.commit();
        sesi.close();
        return image;
    }

    @Override
    public void delete(Companyimage image) {
        log.debug("Deleting image {}", image.getName());
        Session sesi = sf.getCurrentSession();
    	Transaction tr = sesi.beginTransaction();
        sesi.delete(image);
        tr.commit();
        sesi.close();
    }
    
}
