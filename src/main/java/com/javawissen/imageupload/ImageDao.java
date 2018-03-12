
package com.javawissen.imageupload;

import java.util.List;

/**
 *
 * @author jdmr
 */
public interface ImageDao {
    
    public List<Image> list(Integer productID);
    
    public Image create(Image image);
    
    public Image get(Long id);
    
    public void delete(Image image);
}
