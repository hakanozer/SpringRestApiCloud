package Models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the companyimages database table.
 * 
 */
@Entity
@Table(name="companyimages")
@NamedQuery(name="Companyimage.findAll", query="SELECT c FROM Companyimage c")
public class Companyimage implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String thumbnailFilename;
	    private String newFilename;
	    private String contentType;
	    @Column(name = "size_")
	    private Long size;
	    private Long thumbnailSize;
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date dateCreated;
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date lastUpdated;
	    @Transient
	    private String url;
	    @Transient
	    private String thumbnailUrl;
	    @Transient
	    private String deleteUrl;
	    @Transient
	    private String deleteType;
	    private int companyId;
	    


	

		public int getCompanyId() {
			return companyId;
		}

		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}

		public Companyimage() {}

	    /**
	     * @return the id
	     */
	    public Long getId() {
	        return id;
	    }

	    /**
	     * @param id the id to set
	     */
	    public void setId(Long id) {
	        this.id = id;
	    }

	    /**
	     * @return the name
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * @param name the name to set
	     */
	    public void setName(String name) {
	        this.name = name;
	    }

	    /**
	     * @return the thumbnailFilename
	     */
	    public String getThumbnailFilename() {
	        return thumbnailFilename;
	    }

	    /**
	     * @param thumbnailFilename the thumbnailFilename to set
	     */
	    public void setThumbnailFilename(String thumbnailFilename) {
	        this.thumbnailFilename = thumbnailFilename;
	    }

	    /**
	     * @return the newFilename
	     */
	    public String getNewFilename() {
	        return newFilename;
	    }

	    /**
	     * @param newFilename the newFilename to set
	     */
	    public void setNewFilename(String newFilename) {
	        this.newFilename = newFilename;
	    }

	    /**
	     * @return the contentType
	     */
	    public String getContentType() {
	        return contentType;
	    }

	    /**
	     * @param contentType the contentType to set
	     */
	    public void setContentType(String contentType) {
	        this.contentType = contentType;
	    }

	    /**
	     * @return the size
	     */
	    public Long getSize() {
	        return size;
	    }

	    /**
	     * @param size the size to set
	     */
	    public void setSize(Long size) {
	        this.size = size;
	    }

	    /**
	     * @return the thumbnailSize
	     */
	    public Long getThumbnailSize() {
	        return thumbnailSize;
	    }

	    /**
	     * @param thumbnailSize the thumbnailSize to set
	     */
	    public void setThumbnailSize(Long thumbnailSize) {
	        this.thumbnailSize = thumbnailSize;
	    }

	    /**
	     * @return the dateCreated
	     */
	    public Date getDateCreated() {
	        return dateCreated;
	    }

	    /**
	     * @param dateCreated the dateCreated to set
	     */
	    public void setDateCreated(Date dateCreated) {
	        this.dateCreated = dateCreated;
	    }

	    /**
	     * @return the lastUpdated
	     */
	    public Date getLastUpdated() {
	        return lastUpdated;
	    }

	    /**
	     * @param lastUpdated the lastUpdated to set
	     */
	    public void setLastUpdated(Date lastUpdated) {
	        this.lastUpdated = lastUpdated;
	    }

	    /**
	     * @return the url
	     */
	    public String getUrl() {
	        return url;
	    }

	    /**
	     * @param url the url to set
	     */
	    public void setUrl(String url) {
	        this.url = url;
	    }

	    /**
	     * @return the thumbnailUrl
	     */
	    public String getThumbnailUrl() {
	        return thumbnailUrl;
	    }

	    /**
	     * @param thumbnailUrl the thumbnailUrl to set
	     */
	    public void setThumbnailUrl(String thumbnailUrl) {
	        this.thumbnailUrl = thumbnailUrl;
	    }

	    /**
	     * @return the deleteUrl
	     */
	    public String getDeleteUrl() {
	        return deleteUrl;
	    }

	    /**
	     * @param deleteUrl the deleteUrl to set
	     */
	    public void setDeleteUrl(String deleteUrl) {
	        this.deleteUrl = deleteUrl;
	    }

	    /**
	     * @return the deleteType
	     */
	    public String getDeleteType() {
	        return deleteType;
	    }

	    /**
	     * @param deleteType the deleteType to set
	     */
	    public void setDeleteType(String deleteType) {
	        this.deleteType = deleteType;
	    }

	    @Override
	    public String toString() {
	        return "Image{" + "name=" + name + ", thumbnailFilename=" + thumbnailFilename + ", newFilename=" + newFilename + ", contentType=" + contentType + ", url=" + url + ", thumbnailUrl=" + thumbnailUrl + ", deleteUrl=" + deleteUrl + ", deleteType=" + deleteType + '}';
	    }

}