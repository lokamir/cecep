package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * uflo_table_definition:
 */
@Entity
@Table(name = "uflo_table_definition")
public class UfloTableDefinition implements Serializable {

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
	 * CREATE_DATE_:
	 */
	@PropertyDef(label = "CREATE_DATE_", description = "CREATE_DATE_:")
	private Date createDate;

	/**
	 * MEMO_:
	 */
	@PropertyDef(label = "MEMO_", description = "MEMO_:")
	private String memo;

	/**
	 * NAME_:
	 */
	@PropertyDef(label = "NAME_", description = "NAME_:")
	private String name;

	/**
	 * PARENT_ID_:
	 */
	@PropertyDef(label = "PARENT_ID_", description = "PARENT_ID_:")
	private long parentId;

	public UfloTableDefinition() {
		super();
	}

	public UfloTableDefinition(long id, String categoryId, Date createDate,
			String memo, String name, long parentId) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.createDate = createDate;
		this.memo = memo;
		this.name = name;
		this.parentId = parentId;
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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE_")
	public Date getCreateDate() {
		return createDate;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "MEMO_", length = 120)
	public String getMemo() {
		return memo;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME_", length = 60, nullable = false)
	public String getName() {
		return name;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "PARENT_ID_")
	public long getParentId() {
		return parentId;
	}

	public String toString() {
		return "UfloTableDefinition [id=" + id + ",categoryId=" + categoryId
				+ ",createDate=" + createDate + ",memo=" + memo + ",name="
				+ name + ",parentId=" + parentId + "]";
	}

}
