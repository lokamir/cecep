package entity;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * uflo_calendar:
 */
@Entity
@Table(name = "uflo_calendar")
public class UfloCalendar implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private long id;

	/**
	 * CATEGORY_ID_:
	 */
	@PropertyDef(label = "CATEGORY_ID_", description = "CATEGORY_ID_:")
	private String categoryId;

	/**
	 * DESC_:
	 */
	@PropertyDef(label = "DESC_", description = "DESC_:")
	private String desc;

	/**
	 * NAME_:
	 */
	@PropertyDef(label = "NAME_", description = "NAME_:")
	private String name;

	/**
	 * TYPE_:
	 */
	@PropertyDef(label = "TYPE_", description = "TYPE_:")
	private String type;

	public UfloCalendar() {
		super();
	}

	public UfloCalendar(long id, String categoryId, String desc, String name,
			String type) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.desc = desc;
		this.name = name;
		this.type = type;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", nullable = false)
	public long getId() {
		return id;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CATEGORY_ID_", length = 60)
	public String getCategoryId() {
		return categoryId;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "DESC_", length = 120)
	public String getDesc() {
		return desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME_", length = 60)
	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "TYPE_", length = 12)
	public String getType() {
		return type;
	}

	public String toString() {
		return "UfloCalendar [id=" + id + ",categoryId=" + categoryId
				+ ",desc=" + desc + ",name=" + name + ",type=" + type + "]";
	}

}
