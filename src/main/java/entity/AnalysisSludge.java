package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * analysis_sludge:
 */
@Entity
@Table(name = "analysis_sludge")
public class AnalysisSludge implements Serializable { 

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
@PropertyDef(label="ID",description="ID:")
	private int id;

	/**
	 * 水厂名称:水厂名称
	 */
@PropertyDef(label="水厂名称",description="水厂名称:水厂名称")
	private String deptid;

	/**
	 * 日期:日期
	 */
@PropertyDef(label="日期",description="日期:日期")
	private Date date;

	/**
	 * PH:PH
	 */
@PropertyDef(label="PH",description="PH:PH")
	private BigDecimal ph;

	/**
	 * DO:DO
	 */
@PropertyDef(label="DO",description="DO:DO")
	private BigDecimal oxygen;

	/**
	 * MLSS:MLSS
	 */
@PropertyDef(label="MLSS",description="MLSS:MLSS")
	private BigDecimal mlss;

	/**
	 * SV:SV
	 */
@PropertyDef(label="SV",description="SV:SV")
	private BigDecimal sv;

	/**
	 * MLVSS:MLVSS
	 */
@PropertyDef(label="MLVSS",description="MLVSS:MLVSS")
	private BigDecimal mlvss;

	/**
	 * SVI:SVI
	 */
@PropertyDef(label="SVI",description="SVI:SVI")
	private BigDecimal svi;

	/**
	 * SS:SS
	 */
@PropertyDef(label="SS",description="SS:SS")
	private BigDecimal ss;

	/**
	 * waratio:
	 */
@PropertyDef(label="waratio",description="waratio:")
	private BigDecimal waratio;

	/**
	 * 录入人:录入人
	 */
@PropertyDef(label="录入人",description="录入人:录入人")
	private String keyinid;

	/**
	 * process:
	 */
@PropertyDef(label="",description="process:")
	private Process process;

public AnalysisSludge(){super();}
public AnalysisSludge(int id,String deptid,Date date,BigDecimal ph,BigDecimal oxygen,BigDecimal mlss,BigDecimal sv,BigDecimal mlvss,BigDecimal svi,BigDecimal ss,BigDecimal waratio,String keyinid,Process process){ super();this.id=id;this.deptid=deptid;this.date=date;this.ph=ph;this.oxygen=oxygen;this.mlss=mlss;this.sv=sv;this.mlvss=mlvss;this.svi=svi;this.ss=ss;this.waratio=waratio;this.keyinid=keyinid;this.process=process;}
	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID",nullable=false)
	public int getId() {
		return id;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name="deptId",length=25)
	public String getDeptid() {
		return deptid;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	public Date getDate() {
		return date;
	}

	public void setPh(BigDecimal ph) {
		this.ph = ph;
	}

	@Column(name="Ph")
	public BigDecimal getPh() {
		return ph;
	}

	public void setOxygen(BigDecimal oxygen) {
		this.oxygen = oxygen;
	}

	@Column(name="oxygen")
	public BigDecimal getOxygen() {
		return oxygen;
	}

	public void setMlss(BigDecimal mlss) {
		this.mlss = mlss;
	}

	@Column(name="Mlss")
	public BigDecimal getMlss() {
		return mlss;
	}

	public void setSv(BigDecimal sv) {
		this.sv = sv;
	}

	@Column(name="Sv")
	public BigDecimal getSv() {
		return sv;
	}

	public void setMlvss(BigDecimal mlvss) {
		this.mlvss = mlvss;
	}

	@Column(name="Mlvss")
	public BigDecimal getMlvss() {
		return mlvss;
	}

	public void setSvi(BigDecimal svi) {
		this.svi = svi;
	}

	@Column(name="Svi")
	public BigDecimal getSvi() {
		return svi;
	}

	public void setSs(BigDecimal ss) {
		this.ss = ss;
	}

	@Column(name="Ss")
	public BigDecimal getSs() {
		return ss;
	}

	public void setWaratio(BigDecimal waratio) {
		this.waratio = waratio;
	}

	@Column(name="waratio")
	public BigDecimal getWaratio() {
		return waratio;
	}

	public void setKeyinid(String keyinid) {
		this.keyinid = keyinid;
	}

	@Column(name="keyinId",length=25)
	public String getKeyinid() {
		return keyinid;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="processId",nullable=false)
	public Process getProcess() {
		return process;
	}

	public String toString() {
		return "AnalysisSludge [id=" + id + ",deptid=" + deptid + ",date=" + date + ",ph=" + ph + ",oxygen=" + oxygen + ",mlss=" + mlss + ",sv=" + sv + ",mlvss=" + mlvss + ",svi=" + svi + ",ss=" + ss + ",waratio=" + waratio + ",keyinid=" + keyinid + ",process=" + process + "]";
	}

}
