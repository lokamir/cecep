package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * uflo_process:
 */
@Entity
@Table(name = "uflo_process")
public class UfloProcess implements Serializable {

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
	 * DESCRIPTION_:
	 */
	@PropertyDef(label = "DESCRIPTION_", description = "DESCRIPTION_:")
	private String description;

	/**
	 * EFFECT_DATE_:
	 */
	@PropertyDef(label = "EFFECT_DATE_", description = "EFFECT_DATE_:")
	private Date effectDate;

	/**
	 * KEY_:
	 */
	@PropertyDef(label = "KEY_", description = "KEY_:")
	private String key;

	/**
	 * NAME_:
	 */
	@PropertyDef(label = "NAME_", description = "NAME_:")
	private String name;

	/**
	 * START_PROCESS_URL_:
	 */
	@PropertyDef(label = "START_PROCESS_URL_", description = "START_PROCESS_URL_:")
	private String startProcessUrl;

	/**
	 * VERSION_:
	 */
	@PropertyDef(label = "VERSION_", description = "VERSION_:")
	private int version;

	public UfloProcess() {
		super();
	}

	public UfloProcess(long id, String categoryId, Date createDate,
			String description, Date effectDate, String key, String name,
			String startProcessUrl, int version) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.createDate = createDate;
		this.description = description;
		this.effectDate = effectDate;
		this.key = key;
		this.name = name;
		this.startProcessUrl = startProcessUrl;
		this.version = version;
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

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESCRIPTION_", length = 120)
	public String getDescription() {
		return description;
	}

	public void setEffectDate(Date effectDate) {
		this.effectDate = effectDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EFFECT_DATE_")
	public Date getEffectDate() {
		return effectDate;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "KEY_", length = 60)
	public String getKey() {
		return key;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME_", length = 60)
	public String getName() {
		return name;
	}

	public void setStartProcessUrl(String startProcessUrl) {
		this.startProcessUrl = startProcessUrl;
	}

	@Column(name = "START_PROCESS_URL_", length = 120)
	public String getStartProcessUrl() {
		return startProcessUrl;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "VERSION_")
	public int getVersion() {
		return version;
	}

	public String toString() {
		return "UfloProcess [id=" + id + ",categoryId=" + categoryId
				+ ",createDate=" + createDate + ",description=" + description
				+ ",effectDate=" + effectDate + ",key=" + key + ",name=" + name
				+ ",startProcessUrl=" + startProcessUrl + ",version=" + version
				+ "]";
	}

}
