package entity;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * uflo_d_process_attribute:
 */
@Entity
@Table(name = "uflo_d_process_attribute")
public class UfloDProcessAttribute implements Serializable {

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
	 * LABEL_:
	 */
	@PropertyDef(label = "LABEL_", description = "LABEL_:")
	private String label;

	/**
	 * NAME_:
	 */
	@PropertyDef(label = "NAME_", description = "NAME_:")
	private String name;

	/**
	 * PROCESS_ENTRY_ID_:
	 */
	@PropertyDef(label = "PROCESS_ENTRY_ID_", description = "PROCESS_ENTRY_ID_:")
	private String processEntryId;

	public UfloDProcessAttribute() {
		super();
	}

	public UfloDProcessAttribute(String id, String authorityType, String label,
			String name, String processEntryId) {
		super();
		this.id = id;
		this.authorityType = authorityType;
		this.label = label;
		this.name = name;
		this.processEntryId = processEntryId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 36, nullable = false)
	public String getId() {
		return id;
	}

	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}

	@Column(name = "AUTHORITY_TYPE_", length = 10)
	public String getAuthorityType() {
		return authorityType;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "LABEL_", length = 64)
	public String getLabel() {
		return label;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME_", length = 64)
	public String getName() {
		return name;
	}

	public void setProcessEntryId(String processEntryId) {
		this.processEntryId = processEntryId;
	}

	@Column(name = "PROCESS_ENTRY_ID_", length = 64)
	public String getProcessEntryId() {
		return processEntryId;
	}

	public String toString() {
		return "UfloDProcessAttribute [id=" + id + ",authorityType="
				+ authorityType + ",label=" + label + ",name=" + name
				+ ",processEntryId=" + processEntryId + "]";
	}

}
