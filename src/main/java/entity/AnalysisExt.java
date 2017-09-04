package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * analysis_ext:
 */
@Entity
@Table(name = "analysis_ext")
public class AnalysisExt implements Serializable {

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
	 * 接受水量:接受水量
	 */
	@PropertyDef(label = "接受水量", description = "接受水量:接受水量")
	private BigDecimal intflux;

	/**
	 * 计量表示数:计量表示数
	 */
	@PropertyDef(label = "计量表示数", description = "计量表示数:计量表示数")
	private BigDecimal influxtotal;

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
	 * Cod_price:
	 */
	@PropertyDef(label = "Cod_price", description = "Cod_price:")
	private BigDecimal codPrice;

	/**
	 * Nh_price:
	 */
	@PropertyDef(label = "Nh_price", description = "Nh_price:")
	private BigDecimal nhPrice;

	/**
	 * Ph_price:
	 */
	@PropertyDef(label = "Ph_price", description = "Ph_price:")
	private BigDecimal phPrice;

	/**
	 * Tn_price:
	 */
	@PropertyDef(label = "Tn_price", description = "Tn_price:")
	private BigDecimal tnPrice;

	/**
	 * Ss_price:
	 */
	@PropertyDef(label = "Ss_price", description = "Ss_price:")
	private BigDecimal ssPrice;

	/**
	 * Tp_price:
	 */
	@PropertyDef(label = "Tp_price", description = "Tp_price:")
	private BigDecimal tpPrice;

	/**
	 * valid:
	 */
	@PropertyDef(label = "valid", description = "valid:")
	private boolean valid;

	/**
	 * biscompany:接管企业
	 */
	@PropertyDef(label = "", description = "biscompany:接管企业")
	private Biscompany biscompany;

	public AnalysisExt() {
		super();
	}

	public AnalysisExt(int id, String deptid, Date date, BigDecimal cod,
			BigDecimal ph, BigDecimal ss, BigDecimal nh, BigDecimal tn,
			BigDecimal tp, BigDecimal bod, BigDecimal intflux,
			BigDecimal influxtotal, BigDecimal temperature,
			BigDecimal salinity, String keyinid, BigDecimal codPrice,
			BigDecimal nhPrice, BigDecimal phPrice, BigDecimal tnPrice,
			BigDecimal ssPrice, BigDecimal tpPrice, boolean valid,
			Biscompany biscompany) {
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
		this.intflux = intflux;
		this.influxtotal = influxtotal;
		this.temperature = temperature;
		this.salinity = salinity;
		this.keyinid = keyinid;
		this.codPrice = codPrice;
		this.nhPrice = nhPrice;
		this.phPrice = phPrice;
		this.tnPrice = tnPrice;
		this.ssPrice = ssPrice;
		this.tpPrice = tpPrice;
		this.valid = valid;
		this.biscompany = biscompany;
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

	public void setIntflux(BigDecimal intflux) {
		this.intflux = intflux;
	}

	@Column(name = "intflux")
	public BigDecimal getIntflux() {
		return intflux;
	}

	public void setInfluxtotal(BigDecimal influxtotal) {
		this.influxtotal = influxtotal;
	}

	@Column(name = "influxtotal")
	public BigDecimal getInfluxtotal() {
		return influxtotal;
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

	@Column(name = "salinity", unique = true)
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

	public void setCodPrice(BigDecimal codPrice) {
		this.codPrice = codPrice;
	}

	@Column(name = "Cod_price")
	public BigDecimal getCodPrice() {
		return codPrice;
	}

	public void setNhPrice(BigDecimal nhPrice) {
		this.nhPrice = nhPrice;
	}

	@Column(name = "Nh_price")
	public BigDecimal getNhPrice() {
		return nhPrice;
	}

	public void setPhPrice(BigDecimal phPrice) {
		this.phPrice = phPrice;
	}

	@Column(name = "Ph_price")
	public BigDecimal getPhPrice() {
		return phPrice;
	}

	public void setTnPrice(BigDecimal tnPrice) {
		this.tnPrice = tnPrice;
	}

	@Column(name = "Tn_price")
	public BigDecimal getTnPrice() {
		return tnPrice;
	}

	public void setSsPrice(BigDecimal ssPrice) {
		this.ssPrice = ssPrice;
	}

	@Column(name = "Ss_price")
	public BigDecimal getSsPrice() {
		return ssPrice;
	}

	public void setTpPrice(BigDecimal tpPrice) {
		this.tpPrice = tpPrice;
	}

	@Column(name = "Tp_price")
	public BigDecimal getTpPrice() {
		return tpPrice;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Column(name = "valid")
	public boolean isValid() {
		return valid;
	}

	public void setBiscompany(Biscompany biscompany) {
		this.biscompany = biscompany;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "biscompyId", nullable = false)
	public Biscompany getBiscompany() {
		return biscompany;
	}

	public String toString() {
		return "AnalysisExt [id=" + id + ",deptid=" + deptid + ",date=" + date
				+ ",cod=" + cod + ",ph=" + ph + ",ss=" + ss + ",nh=" + nh
				+ ",tn=" + tn + ",tp=" + tp + ",bod=" + bod + ",intflux="
				+ intflux + ",influxtotal=" + influxtotal + ",temperature="
				+ temperature + ",salinity=" + salinity + ",keyinid=" + keyinid
				+ ",codPrice=" + codPrice + ",nhPrice=" + nhPrice + ",phPrice="
				+ phPrice + ",tnPrice=" + tnPrice + ",ssPrice=" + ssPrice
				+ ",tpPrice=" + tpPrice + ",valid=" + valid + ",biscompany="
				+ biscompany + "]";
	}

}
