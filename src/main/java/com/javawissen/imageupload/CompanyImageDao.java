
package com.javawissen.imageupload;

import java.util.List;

import Models.Companyimage;

/**
 *
 * @author jdmr
 */
public interface CompanyImageDao {
    
    public List<Companyimage> list(Integer companyId);
    
    public Companyimage create(Companyimage image);
    
    public Companyimage get(Long id);
    
    public void delete(Companyimage image);
}
