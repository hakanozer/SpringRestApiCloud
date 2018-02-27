package Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int categoryid;

	private int categorycompanyid;

	private String categorydescription;

	private String categorylink;

	private int categoryparentid;

	private String categorysort;

	private String categorytitle;

	public Category() {
	}

	public int getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getCategorycompanyid() {
		return this.categorycompanyid;
	}

	public void setCategorycompanyid(int categorycompanyid) {
		this.categorycompanyid = categorycompanyid;
	}

	public String getCategorydescription() {
		return this.categorydescription;
	}

	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}

	public String getCategorylink() {
		return this.categorylink;
	}

	public void setCategorylink(String categorylink) {
		this.categorylink = categorylink;
	}

	public int getCategoryparentid() {
		return this.categoryparentid;
	}

	public void setCategoryparentid(int categoryparentid) {
		this.categoryparentid = categoryparentid;
	}

	public String getCategorysort() {
		return this.categorysort;
	}

	public void setCategorysort(String categorysort) {
		this.categorysort = categorysort;
	}

	public String getCategorytitle() {
		return this.categorytitle;
	}

	public void setCategorytitle(String categorytitle) {
		this.categorytitle = categorytitle;
	}

}