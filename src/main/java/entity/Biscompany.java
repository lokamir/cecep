package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * biscompany:接管企业
 */
@Entity
@Table(name = "biscompany")
public class Biscompany implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	@PropertyDef(label = "ID", description = "ID:")
	private int id;

	/**
	 * 接管企业名称:接管企业名称
	 */
	@PropertyDef(label = "接管企业名称", description = "接管企业名称:接管企业名称")
	private String name;

	/**
	 * 隶属水厂:隶属水厂
	 */
	@PropertyDef(label = "隶属水厂", description = "隶属水厂:隶属水厂")
	private String deptid;

	/**
	 * 地址:地址
	 */
	@PropertyDef(label = "地址", description = "地址:地址")
	private String adr;

	/**
	 * 联系方式:联系方式
	 */
	@PropertyDef(label = "联系方式", description = "联系方式:联系方式")
	private String tel;

	/**
	 * 联系人:联系人
	 */
	@PropertyDef(label = "联系人", description = "联系人:联系人")
	private String cont;

	/**
	 * valid:
	 */
	@PropertyDef(label = "valid", description = "valid:")
	private boolean valid;

	/**
	 * 备注:备注
	 */
	@PropertyDef(label = "备注", description = "备注:备注")
	private String memo;

	/**
	 * timestamp:
	 */
	@PropertyDef(label = "timestamp", description = "timestamp:")
	private Date timestamp;

	/**
	 * analysis_ext:
	 */
	private Set<AnalysisExt> analysisExtSet = new HashSet<AnalysisExt>(0);

	public Biscompany() {
		super();
	}

	public Biscompany(int id, String name, String deptid, String adr,
			String tel, String cont, boolean valid, String memo,
			Date timestamp, Set<AnalysisExt> analysisExtSet) {
		super();
		this.id = id;
		this.name = name;
		this.deptid = deptid;
		this.adr = adr;
		this.tel = tel;
		this.cont = cont;
		this.valid = valid;
		this.memo = memo;
		this.timestamp = timestamp;
		this.analysisExtSet = analysisExtSet;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name", length = 45, nullable = false)
	public String getName() {
		return name;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "deptId", length = 25, nullable = false)
	public String getDeptid() {
		return deptid;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	@Column(name = "adr", length = 45)
	public String getAdr() {
		return adr;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "tel", length = 45)
	public String getTel() {
		return tel;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	@Column(name = "cont", length = 45)
	public String getCont() {
		return cont;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Column(name = "valid")
	public boolean isValid() {
		return valid;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "memo", length = 45)
	public String getMemo() {
		return memo;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", nullable = false)
	public Date getTimestamp() {
		return timestamp;
	}

	public void setAnalysisExtSet(Set<AnalysisExt> analysisExtSet) {
		this.analysisExtSet = analysisExtSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "biscompany")
	public Set<AnalysisExt> getAnalysisExtSet() {
		return analysisExtSet;
	}

	public String toString() {
		return "Biscompany [id=" + id + ",name=" + name + ",deptid=" + deptid
				+ ",adr=" + adr + ",tel=" + tel + ",cont=" + cont + ",valid="
				+ valid + ",memo=" + memo + ",timestamp=" + timestamp
				+ ",analysisExtSet=" + analysisExtSet + "]";
	}

}
