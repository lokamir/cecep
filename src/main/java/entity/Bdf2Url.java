package entity;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * bdf2_url:
 */
@Entity
@Table(name = "bdf2_url")
public class Bdf2Url implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;

	/**
	 * COMPANY_ID_:
	 */
	@PropertyDef(label = "COMPANY_ID_", description = "COMPANY_ID_:")
	private String companyId;

	/**
	 * DESC_:
	 */
	@PropertyDef(label = "DESC_", description = "DESC_:")
	private String desc;

	/**
	 * FOR_NAVIGATION_:
	 */
	@PropertyDef(label = "FOR_NAVIGATION_", description = "FOR_NAVIGATION_:")
	private boolean forNavigation;

	/**
	 * ICON_:
	 */
	@PropertyDef(label = "ICON_", description = "ICON_:")
	private String icon;

	/**
	 * NAME_:
	 */
	@PropertyDef(label = "NAME_", description = "NAME_:")
	private String name;

	/**
	 * ORDER_:
	 */
	@PropertyDef(label = "ORDER_", description = "ORDER_:")
	private int order;

	/**
	 * PARENT_ID_:
	 */
	@PropertyDef(label = "PARENT_ID_", description = "PARENT_ID_:")
	private String parentId;

	/**
	 * SYSTEM_ID_:
	 */
	@PropertyDef(label = "SYSTEM_ID_", description = "SYSTEM_ID_:")
	private String systemId;

	/**
	 * URL_:
	 */
	@PropertyDef(label = "URL_", description = "URL_:")
	private String url;

	public Bdf2Url() {
		super();
	}

	public Bdf2Url(String id, String companyId, String desc,
			boolean forNavigation, String icon, String name, int order,
			String parentId, String systemId, String url) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.desc = desc;
		this.forNavigation = forNavigation;
		this.icon = icon;
		this.name = name;
		this.order = order;
		this.parentId = parentId;
		this.systemId = systemId;
		this.url = url;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 60, nullable = false)
	public String getId() {
		return id;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMPANY_ID_", length = 60, nullable = false)
	public String getCompanyId() {
		return companyId;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "DESC_", length = 120)
	public String getDesc() {
		return desc;
	}

	public void setForNavigation(boolean forNavigation) {
		this.forNavigation = forNavigation;
	}

	@Column(name = "FOR_NAVIGATION_", nullable = false)
	public boolean isForNavigation() {
		return forNavigation;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "ICON_", length = 120)
	public String getIcon() {
		return icon;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME_", length = 60, nullable = false)
	public String getName() {
		return name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Column(name = "ORDER_")
	public int getOrder() {
		return order;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "PARENT_ID_", length = 60)
	public String getParentId() {
		return parentId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	@Column(name = "SYSTEM_ID_", length = 60)
	public String getSystemId() {
		return systemId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "URL_", length = 120)
	public String getUrl() {
		return url;
	}

	public String toString() {
		return "Bdf2Url [id=" + id + ",companyId=" + companyId + ",desc="
				+ desc + ",forNavigation=" + forNavigation + ",icon=" + icon
				+ ",name=" + name + ",order=" + order + ",parentId=" + parentId
				+ ",systemId=" + systemId + ",url=" + url + "]";
	}

}
