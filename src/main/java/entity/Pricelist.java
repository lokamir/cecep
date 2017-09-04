package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * pricelist:收费价目表
 */
@Entity
@Table(name = "pricelist")
public class Pricelist implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * 关联:关联
	 */
	@PropertyDef(label = "关联", description = "关联:关联")
	private String deptid;

	/**
	 * category:
	 */
	@PropertyDef(label = "category", description = "category:")
	private String category;

	/**
	 * numvalue:
	 */
	@PropertyDef(label = "numvalue", description = "numvalue:")
	private BigDecimal numvalue;

	/**
	 * price:
	 */
	@PropertyDef(label = "price", description = "price:")
	private BigDecimal price;

	public Pricelist() {
		super();
	}

	public Pricelist(int id, String deptid, String category,
			BigDecimal numvalue, BigDecimal price) {
		super();
		this.id = id;
		this.deptid = deptid;
		this.category = category;
		this.numvalue = numvalue;
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "deptId", length = 25)
	public String getDeptid() {
		return deptid;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "category", length = 45)
	public String getCategory() {
		return category;
	}

	public void setNumvalue(BigDecimal numvalue) {
		this.numvalue = numvalue;
	}

	@Column(name = "numvalue")
	public BigDecimal getNumvalue() {
		return numvalue;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
	}

	public String toString() {
		return "Pricelist [id=" + id + ",deptid=" + deptid + ",category="
				+ category + ",numvalue=" + numvalue + ",price=" + price + "]";
	}

}
