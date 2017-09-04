package entity;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * bdf2_url_component:
 */
@Entity
@Table(name = "bdf2_url_component")
public class Bdf2UrlComponent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;

	/**
	 * AUTHORITY_TYPE_:
	 */
	@PropertyDef(label = "AUTHORITY_TYPE_", description = "AUTHORITY_TYPE_:")
	private String authorityType;

	/**
	 * ROLE_ID_:
	 */
	@PropertyDef(label = "ROLE_ID_", description = "ROLE_ID_:")
	private String roleId;

	/**
	 * URL_ID_:
	 */
	@PropertyDef(label = "URL_ID_", description = "URL_ID_:")
	private String urlId;

	/**
	 * bdf2_component:
	 */
	@PropertyDef(label = "", description = "bdf2_component:")
	private Bdf2Component bdf2Component;

	public Bdf2UrlComponent() {
		super();
	}

	public Bdf2UrlComponent(String id, String authorityType, String roleId,
			String urlId, Bdf2Component bdf2Component) {
		super();
		this.id = id;
		this.authorityType = authorityType;
		this.roleId = roleId;
		this.urlId = urlId;
		this.bdf2Component = bdf2Component;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 60, nullable = false)
	public String getId() {
		return id;
	}

	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}

	@Column(name = "AUTHORITY_TYPE_", length = 10, nullable = false)
	public String getAuthorityType() {
		return authorityType;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "ROLE_ID_", length = 60)
	public String getRoleId() {
		return roleId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	@Column(name = "URL_ID_", length = 60)
	public String getUrlId() {
		return urlId;
	}

	public void setBdf2Component(Bdf2Component bdf2Component) {
		this.bdf2Component = bdf2Component;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPONENT_ID_")
	public Bdf2Component getBdf2Component() {
		return bdf2Component;
	}

	public String toString() {
		return "Bdf2UrlComponent [id=" + id + ",authorityType=" + authorityType
				+ ",roleId=" + roleId + ",urlId=" + urlId + ",bdf2Component="
				+ bdf2Component + "]";
	}

}
