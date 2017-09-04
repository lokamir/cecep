package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * operated:
 */
@Entity
@Table(name = "operated")
public class Operated implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID:
	 */
	@PropertyDef(label = "ID", description = "ID:")
	private int id;

	/**
	 * 进水量（吨）:进水量（吨）
	 */
	@PropertyDef(label = "进水量（吨）", description = "进水量（吨）:进水量（吨）")
	private BigDecimal intrflux;

	/**
	 * 出水量（吨）:出水量（吨）
	 */
	@PropertyDef(label = "出水量（吨）", description = "出水量（吨）:出水量（吨）")
	private BigDecimal extflux;

	/**
	 * 进水补位码:进水补位码
	 */
	@PropertyDef(label = "进水补位码", description = "进水补位码:进水补位码")
	private int intrfluxCp;

	/**
	 * 出水补位码:出水补位码
	 */
	@PropertyDef(label = "出水补位码", description = "出水补位码:出水补位码")
	private int extfluxCp;

	/**
	 * 进水流量计示数:进水流量计示数
	 */
	@PropertyDef(label = "进水流量计示数", description = "进水流量计示数:进水流量计示数")
	private BigDecimal intrfluxTotal;

	/**
	 * 出水流量计示数:出水流量计示数
	 */
	@PropertyDef(label = "出水流量计示数", description = "出水流量计示数:出水流量计示数")
	private BigDecimal extfluxTotal;

	/**
	 * 不用:不用
	 */
	@PropertyDef(label = "不用", description = "不用:不用")
	private BigDecimal intrflowBefore;

	/**
	 * 不用:不用
	 */
	@PropertyDef(label = "不用", description = "不用:不用")
	private BigDecimal extfluxBefore;

	/**
	 * PAC用量（kg）:PAC用量（kg）
	 */
	@PropertyDef(label = "PAC用量（kg）", description = "PAC用量（kg）:PAC用量（kg）")
	private BigDecimal pacAmount;

	/**
	 * 阳离子用量（kg）:阳离子用量（kg）
	 */
	@PropertyDef(label = "阳离子用量（kg）", description = "阳离子用量（kg）:阳离子用量（kg）")
	private BigDecimal pamkationAmount;

	/**
	 * 阴离子用量（kg）:阴离子用量（kg）
	 */
	@PropertyDef(label = "阴离子用量（kg）", description = "阴离子用量（kg）:阴离子用量（kg）")
	private BigDecimal pamanionAmount;

	/**
	 * 非离子（kg）:非离子（kg）
	 */
	@PropertyDef(label = "非离子（kg）", description = "非离子（kg）:非离子（kg）")
	private BigDecimal nonionicAmount;

	/**
	 * 外加碳源（吨）:外加碳源（吨）
	 */
	@PropertyDef(label = "外加碳源（吨）", description = "外加碳源（吨）:外加碳源（吨）")
	private BigDecimal nutrient;

	/**
	 * 次氯酸钠（吨）:次氯酸钠（吨）
	 */
	@PropertyDef(label = "次氯酸钠（吨）", description = "次氯酸钠（吨）:次氯酸钠（吨）")
	private BigDecimal naclo;

	/**
	 * 聚合硫酸铁用量（吨）:聚合硫酸铁用量（吨）
	 */
	@PropertyDef(label = "聚合硫酸铁用量（吨）", description = "聚合硫酸铁用量（吨）:聚合硫酸铁用量（吨）")
	private BigDecimal pfs;

	/**
	 * 聚合氯化铁用量（吨）:聚合氯化铁用量（吨）
	 */
	@PropertyDef(label = "聚合氯化铁用量（吨）", description = "聚合氯化铁用量（吨）:聚合氯化铁用量（吨）")
	private BigDecimal pfc;

	/**
	 * 生石灰用量（kg）:生石灰用量（kg）
	 */
	@PropertyDef(label = "生石灰用量（kg）", description = "生石灰用量（kg）:生石灰用量（kg）")
	private BigDecimal lime;

	/**
	 * 压泥时间(小时):压泥时间(小时)
	 */
	@PropertyDef(label = "压泥时间(小时)", description = "压泥时间(小时):压泥时间(小时)")
	private BigDecimal filterpressTime;

	/**
	 * 用电量（kwh）:用电量（kwh）
	 */
	@PropertyDef(label = "用电量（kwh）", description = "用电量（kwh）:用电量（kwh）")
	private BigDecimal power;

	/**
	 * 工业用电（kwh）:工业用电（kwh）
	 */
	@PropertyDef(label = "工业用电（kwh）", description = "工业用电（kwh）:工业用电（kwh）")
	private BigDecimal inapower;

	/**
	 * 生活用电（kwh）:生活用电（kwh）
	 */
	@PropertyDef(label = "生活用电（kwh）", description = "生活用电（kwh）:生活用电（kwh）")
	private BigDecimal resdpower;

	/**
	 * 污泥产量（吨）:污泥产量（吨）
	 */
	@PropertyDef(label = "污泥产量（吨）", description = "污泥产量（吨）:污泥产量（吨）")
	private BigDecimal sludge;

	/**
	 * 日期:日期
	 */
	@PropertyDef(label = "日期", description = "日期:日期")
	private Date date;

	/**
	 * 污水厂名称:污水厂名称
	 */
	@PropertyDef(label = "污水厂名称", description = "污水厂名称:污水厂名称")
	private String deptid;

	/**
	 * 设备维修情况:设备维修情况
	 */
	@PropertyDef(label = "设备维修情况", description = "设备维修情况:设备维修情况")
	private String by1;

	/**
	 * 设备运行情况:设备运行情况
	 */
	@PropertyDef(label = "设备运行情况", description = "设备运行情况:设备运行情况")
	private String by2;

	/**
	 * 备注:备注
	 */
	@PropertyDef(label = "备注", description = "备注:备注")
	private String memo;

	/**
	 * 录入人:录入人
	 */
	@PropertyDef(label = "录入人", description = "录入人:录入人")
	private String keyinid;

	/**
	 * add_time:
	 */
	@PropertyDef(label = "add_time", description = "add_time:")
	private Date addTime;

	/**
	 * last_time:
	 *//*
	@PropertyDef(label = "last_time", description = "last_time:")
	private Date lastTime;*/

	/**
	 * valid:
	 */
	@PropertyDef(label = "valid", description = "valid:")
	private boolean valid;

	public Operated() {
		super();
	}

	public Operated(int id, BigDecimal intrflux, BigDecimal extflux,
			int intrfluxCp, int extfluxCp, BigDecimal intrfluxTotal,
			BigDecimal extfluxTotal, BigDecimal intrflowBefore,
			BigDecimal extfluxBefore, BigDecimal pacAmount,
			BigDecimal pamkationAmount, BigDecimal pamanionAmount,
			BigDecimal nonionicAmount, BigDecimal nutrient, BigDecimal naclo,
			BigDecimal pfs, BigDecimal pfc, BigDecimal lime,
			BigDecimal filterpressTime, BigDecimal power, BigDecimal inapower,
			BigDecimal resdpower, BigDecimal sludge, Date date, String deptid,
			String by1, String by2, String memo, String keyinid, Date addTime,
			//Date lastTime, 
			boolean valid) {
		super();
		this.id = id;
		this.intrflux = intrflux;
		this.extflux = extflux;
		this.intrfluxCp = intrfluxCp;
		this.extfluxCp = extfluxCp;
		this.intrfluxTotal = intrfluxTotal;
		this.extfluxTotal = extfluxTotal;
		this.intrflowBefore = intrflowBefore;
		this.extfluxBefore = extfluxBefore;
		this.pacAmount = pacAmount;
		this.pamkationAmount = pamkationAmount;
		this.pamanionAmount = pamanionAmount;
		this.nonionicAmount = nonionicAmount;
		this.nutrient = nutrient;
		this.naclo = naclo;
		this.pfs = pfs;
		this.pfc = pfc;
		this.lime = lime;
		this.filterpressTime = filterpressTime;
		this.power = power;
		this.inapower = inapower;
		this.resdpower = resdpower;
		this.sludge = sludge;
		this.date = date;
		this.deptid = deptid;
		this.by1 = by1;
		this.by2 = by2;
		this.memo = memo;
		this.keyinid = keyinid;
		this.addTime = addTime;
		//this.lastTime = lastTime;
		this.valid = valid;
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

	public void setIntrflux(BigDecimal intrflux) {
		this.intrflux = intrflux;
	}

	@Column(name = "intrflux")
	public BigDecimal getIntrflux() {
		return intrflux;
	}

	public void setExtflux(BigDecimal extflux) {
		this.extflux = extflux;
	}

	@Column(name = "extflux")
	public BigDecimal getExtflux() {
		return extflux;
	}

	public void setIntrfluxCp(int intrfluxCp) {
		this.intrfluxCp = intrfluxCp;
	}

	@Column(name = "intrflux_cp")
	public int getIntrfluxCp() {
		return intrfluxCp;
	}

	public void setExtfluxCp(int extfluxCp) {
		this.extfluxCp = extfluxCp;
	}

	@Column(name = "extflux_cp")
	public int getExtfluxCp() {
		return extfluxCp;
	}

	public void setIntrfluxTotal(BigDecimal intrfluxTotal) {
		this.intrfluxTotal = intrfluxTotal;
	}

	@Column(name = "intrflux_total")
	public BigDecimal getIntrfluxTotal() {
		return intrfluxTotal;
	}

	public void setExtfluxTotal(BigDecimal extfluxTotal) {
		this.extfluxTotal = extfluxTotal;
	}

	@Column(name = "extflux_total")
	public BigDecimal getExtfluxTotal() {
		return extfluxTotal;
	}

	public void setIntrflowBefore(BigDecimal intrflowBefore) {
		this.intrflowBefore = intrflowBefore;
	}

	@Column(name = "intrflow_before")
	public BigDecimal getIntrflowBefore() {
		return intrflowBefore;
	}

	public void setExtfluxBefore(BigDecimal extfluxBefore) {
		this.extfluxBefore = extfluxBefore;
	}

	@Column(name = "extflux_before")
	public BigDecimal getExtfluxBefore() {
		return extfluxBefore;
	}

	public void setPacAmount(BigDecimal pacAmount) {
		this.pacAmount = pacAmount;
	}

	@Column(name = "pac_amount")
	public BigDecimal getPacAmount() {
		return pacAmount;
	}

	public void setPamkationAmount(BigDecimal pamkationAmount) {
		this.pamkationAmount = pamkationAmount;
	}

	@Column(name = "pamkation_amount")
	public BigDecimal getPamkationAmount() {
		return pamkationAmount;
	}

	public void setPamanionAmount(BigDecimal pamanionAmount) {
		this.pamanionAmount = pamanionAmount;
	}

	@Column(name = "pamanion_amount")
	public BigDecimal getPamanionAmount() {
		return pamanionAmount;
	}

	public void setNonionicAmount(BigDecimal nonionicAmount) {
		this.nonionicAmount = nonionicAmount;
	}

	@Column(name = "nonionic_amount")
	public BigDecimal getNonionicAmount() {
		return nonionicAmount;
	}

	public void setNutrient(BigDecimal nutrient) {
		this.nutrient = nutrient;
	}

	@Column(name = "nutrient")
	public BigDecimal getNutrient() {
		return nutrient;
	}

	public void setNaclo(BigDecimal naclo) {
		this.naclo = naclo;
	}

	@Column(name = "naclo")
	public BigDecimal getNaclo() {
		return naclo;
	}

	public void setPfs(BigDecimal pfs) {
		this.pfs = pfs;
	}

	@Column(name = "pfs")
	public BigDecimal getPfs() {
		return pfs;
	}

	public void setPfc(BigDecimal pfc) {
		this.pfc = pfc;
	}

	@Column(name = "pfc")
	public BigDecimal getPfc() {
		return pfc;
	}

	public void setLime(BigDecimal lime) {
		this.lime = lime;
	}

	@Column(name = "lime")
	public BigDecimal getLime() {
		return lime;
	}

	public void setFilterpressTime(BigDecimal filterpressTime) {
		this.filterpressTime = filterpressTime;
	}

	@Column(name = "filterpress_time")
	public BigDecimal getFilterpressTime() {
		return filterpressTime;
	}

	public void setPower(BigDecimal power) {
		this.power = power;
	}

	@Column(name = "power")
	public BigDecimal getPower() {
		return power;
	}

	public void setInapower(BigDecimal inapower) {
		this.inapower = inapower;
	}

	@Column(name = "inaPower")
	public BigDecimal getInapower() {
		return inapower;
	}

	public void setResdpower(BigDecimal resdpower) {
		this.resdpower = resdpower;
	}

	@Column(name = "resdPower")
	public BigDecimal getResdpower() {
		return resdpower;
	}

	public void setSludge(BigDecimal sludge) {
		this.sludge = sludge;
	}

	@Column(name = "sludge")
	public BigDecimal getSludge() {
		return sludge;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "deptId", length = 25)
	public String getDeptid() {
		return deptid;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}

	@Column(name = "by1", length = 255)
	public String getBy1() {
		return by1;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}

	@Column(name = "by2", length = 255)
	public String getBy2() {
		return by2;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "memo", length = 255)
	public String getMemo() {
		return memo;
	}

	public void setKeyinid(String keyinid) {
		this.keyinid = keyinid;
	}

	@Column(name = "keyinId", length = 25)
	public String getKeyinid() {
		return keyinid;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "add_time")
	public Date getAddTime() {
		return addTime;
	}

	/*public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_time", nullable = false)
	public Date getLastTime() {
		return lastTime;
	}*/

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Column(name = "valid")
	public boolean isValid() {
		return valid;
	}

	public String toString() {
		return "Operated [id=" + id + ",intrflux=" + intrflux + ",extflux="
				+ extflux + ",intrfluxCp=" + intrfluxCp + ",extfluxCp="
				+ extfluxCp + ",intrfluxTotal=" + intrfluxTotal
				+ ",extfluxTotal=" + extfluxTotal + ",intrflowBefore="
				+ intrflowBefore + ",extfluxBefore=" + extfluxBefore
				+ ",pacAmount=" + pacAmount + ",pamkationAmount="
				+ pamkationAmount + ",pamanionAmount=" + pamanionAmount
				+ ",nonionicAmount=" + nonionicAmount + ",nutrient=" + nutrient
				+ ",naclo=" + naclo + ",pfs=" + pfs + ",pfc=" + pfc + ",lime="
				+ lime + ",filterpressTime=" + filterpressTime + ",power="
				+ power + ",inapower=" + inapower + ",resdpower=" + resdpower
				+ ",sludge=" + sludge + ",date=" + date + ",deptid=" + deptid
				+ ",by1=" + by1 + ",by2=" + by2 + ",memo=" + memo + ",keyinid="
				+ keyinid + ",addTime=" + addTime 
				//+ ",lastTime=" + lastTime
				+ ",valid=" + valid + "]";
	}

}
