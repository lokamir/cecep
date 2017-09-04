package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * analysis_intr:系统样
 */
@Entity
@Table(name = "analysis_intr")
public class AnalysisIntr implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	@PropertyDef(label = "ID", description = "ID:")
	private int id;

	/**
	 * deptId:
	 */
	@PropertyDef(label = "deptId", description = "deptId:")
	private String deptid;

	/**
	 * Date:
	 */
	@PropertyDef(label = "Date", description = "Date:")
	private Date date;

	/**
	 * COD:COD
	 */
	@PropertyDef(label = "COD", description = "COD:COD")
	private BigDecimal cod;

	/**
	 * PH:PH
	 */
	@PropertyDef(label = "PH", description = "PH:PH")
	private BigDecimal ph;

	/**
	 * SS:SS
	 */
	@PropertyDef(label = "SS", description = "SS:SS")
	private BigDecimal ss;

	/**
	 * NH3-N:NH3-N
	 */
	@PropertyDef(label = "NH3-N", description = "NH3-N:NH3-N")
	private BigDecimal nh;

	/**
	 * TN:TN
	 */
	@PropertyDef(label = "TN", description = "TN:TN")
	private BigDecimal tn;

	/**
	 * TP:TP
	 */
	@PropertyDef(label = "TP", description = "TP:TP")
	private BigDecimal tp;

	/**
	 * BOD:BOD
	 */
	@PropertyDef(label = "BOD", description = "BOD:BOD")
	private BigDecimal bod;

	/**
	 * DO:DO
	 */
	@PropertyDef(label = "DO", description = "DO:DO")
	private BigDecimal oxygen;

	/**
	 * MLSS:MLSS
	 */
	@PropertyDef(label = "MLSS", description = "MLSS:MLSS")
	private BigDecimal mlss;

	/**
	 * SV:SV
	 */
	@PropertyDef(label = "SV", description = "SV:SV")
	private BigDecimal sv;

	/**
	 * MLVSS:MLVSS
	 */
	@PropertyDef(label = "MLVSS", description = "MLVSS:MLVSS")
	private BigDecimal mlvss;

	/**
	 * SVI:SVI
	 */
	@PropertyDef(label = "SVI", description = "SVI:SVI")
	private BigDecimal svi;

	/**
	 * 水温:水温
	 */
	@PropertyDef(label = "水温", description = "水温:水温")
	private BigDecimal temperature;

	/**
	 * 盐度:盐度
	 */
	@PropertyDef(label = "盐度", description = "盐度:盐度")
	private BigDecimal salinity;

	/**
	 * 录入人:录入人
	 */
	@PropertyDef(label = "录入人", description = "录入人:录入人")
	private String keyinid;

	/**
	 * valid:
	 */
	@PropertyDef(label = "valid", description = "valid:")
	private boolean valid;

	/**
	 * process:
	 */
	@PropertyDef(label = "", description = "process:")
	private Process process;

	public AnalysisIntr() {
		super();
	}

	public AnalysisIntr(int id, String deptid, Date date, BigDecimal cod,
			BigDecimal ph, BigDecimal ss, BigDecimal nh, BigDecimal tn,
			BigDecimal tp, BigDecimal bod, BigDecimal oxygen, BigDecimal mlss,
			BigDecimal sv, BigDecimal mlvss, BigDecimal svi,
			BigDecimal temperature, BigDecimal salinity, String keyinid,
			boolean valid, Process process) {
		super();
		this.id = id;
		this.deptid = deptid;
		this.date = date;
		this.cod = cod;
		this.ph = ph;
		this.ss = ss;
		this.nh = nh;
		this.tn = tn;
		this.tp = tp;
		this.bod = bod;
		this.oxygen = oxygen;
		this.mlss = mlss;
		this.sv = sv;
		this.mlvss = mlvss;
		this.svi = svi;
		this.temperature = temperature;
		this.salinity = salinity;
		this.keyinid = keyinid;
		this.valid = valid;
		this.process = process;
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

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "deptId", length = 25)
	public String getDeptid() {
		return deptid;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setCod(BigDecimal cod) {
		this.cod = cod;
	}

	@Column(name = "Cod")
	public BigDecimal getCod() {
		return cod;
	}

	public void setPh(BigDecimal ph) {
		this.ph = ph;
	}

	@Column(name = "Ph")
	public BigDecimal getPh() {
		return ph;
	}

	public void setSs(BigDecimal ss) {
		this.ss = ss;
	}

	@Column(name = "Ss")
	public BigDecimal getSs() {
		return ss;
	}

	public void setNh(BigDecimal nh) {
		this.nh = nh;
	}

	@Column(name = "Nh")
	public BigDecimal getNh() {
		return nh;
	}

	public void setTn(BigDecimal tn) {
		this.tn = tn;
	}

	@Column(name = "Tn")
	public BigDecimal getTn() {
		return tn;
	}

	public void setTp(BigDecimal tp) {
		this.tp = tp;
	}

	@Column(name = "Tp")
	public BigDecimal getTp() {
		return tp;
	}

	public void setBod(BigDecimal bod) {
		this.bod = bod;
	}

	@Column(name = "Bod")
	public BigDecimal getBod() {
		return bod;
	}

	public void setOxygen(BigDecimal oxygen) {
		this.oxygen = oxygen;
	}

	@Column(name = "oxygen")
	public BigDecimal getOxygen() {
		return oxygen;
	}

	public void setMlss(BigDecimal mlss) {
		this.mlss = mlss;
	}

	@Column(name = "Mlss")
	public BigDecimal getMlss() {
		return mlss;
	}

	public void setSv(BigDecimal sv) {
		this.sv = sv;
	}

	@Column(name = "Sv")
	public BigDecimal getSv() {
		return sv;
	}

	public void setMlvss(BigDecimal mlvss) {
		this.mlvss = mlvss;
	}

	@Column(name = "Mlvss")
	public BigDecimal getMlvss() {
		return mlvss;
	}

	public void setSvi(BigDecimal svi) {
		this.svi = svi;
	}

	@Column(name = "Svi")
	public BigDecimal getSvi() {
		return svi;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	@Column(name = "temperature")
	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setSalinity(BigDecimal salinity) {
		this.salinity = salinity;
	}

	@Column(name = "salinity")
	public BigDecimal getSalinity() {
		return salinity;
	}

	public void setKeyinid(String keyinid) {
		this.keyinid = keyinid;
	}

	@Column(name = "keyinId", length = 25)
	public String getKeyinid() {
		return keyinid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Column(name = "valid")
	public boolean isValid() {
		return valid;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "processId", nullable = false)
	public Process getProcess() {
		return process;
	}

	public String toString() {
		return "AnalysisIntr [id=" + id + ",deptid=" + deptid + ",date=" + date
				+ ",cod=" + cod + ",ph=" + ph + ",ss=" + ss + ",nh=" + nh
				+ ",tn=" + tn + ",tp=" + tp + ",bod=" + bod + ",oxygen="
				+ oxygen + ",mlss=" + mlss + ",sv=" + sv + ",mlvss=" + mlvss
				+ ",svi=" + svi + ",temperature=" + temperature + ",salinity="
				+ salinity + ",keyinid=" + keyinid + ",valid=" + valid
				+ ",process=" + process + "]";
	}

}
