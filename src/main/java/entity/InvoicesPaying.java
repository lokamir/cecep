package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * invoices_paying:单据报销执行记录
 */
@Entity
@Table(name = "invoices_paying")
public class InvoicesPaying implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * 单据编号:单据编号
	 */
	@PropertyDef(label = "单据编号", description = "单据编号:单据编号")
	private String sn;

	/**
	 * 送单部门:送单部门
	 */
	@PropertyDef(label = "送单部门", description = "送单部门:送单部门")
	private String deptid;

	/**
	 * Create_Date:
	 */
	@PropertyDef(label = "Create_Date", description = "Create_Date:")
	private Date createDate;

	/**
	 * 流转环节:流转环节
	 */
	@PropertyDef(label = "流转环节", description = "流转环节:流转环节")
	private Integer psid;

	/**
	 * 付款类别（付款申请，报销申请）:付款类别（付款申请，报销申请）
	 */
	@PropertyDef(label = "付款类别（付款申请，报销申请）", description = "付款类别（付款申请，报销申请）:付款类别（付款申请，报销申请）")
	private String categoryPaying;

	/**
	 * 费用类别:费用类别
	 */
	@PropertyDef(label = "费用类别", description = "费用类别:费用类别")
	private int categoryDetailId;

	/**
	 * 费用类别:费用类别
	 */
	@PropertyDef(label = " ", description = " ")
	private int transportId;

	/**
	 * 录入人:录入人
	 */
	@PropertyDef(label = "录入人", description = "录入人:录入人")
	private String keyinid;

	/**
	 * 内容:内容
	 */
	@PropertyDef(label = "内容", description = "内容:内容")
	private String content;

	/**
	 * 金额:金额
	 */
	@PropertyDef(label = "金额", description = "金额:金额")
	private BigDecimal billing;

	/**
	 * A类或B类:A类或B类
	 */
	@PropertyDef(label = "A类或B类", description = "A类或B类:A类或B类")
	private String aorb;

	/**
	 * add_time:
	 */
	@PropertyDef(label = "add_time", description = "add_time:")
	private Date addTime;

	/**
	 * end_time:
	 */
	@PropertyDef(label = "end_time", description = "end_time:")
	private Date endTime;

	/**
	 * 已付或未付:已付或未付
	 */
	@PropertyDef(label = "已付或未付", description = "已付或未付:已付或未付")
	private boolean valid;
	
	/**
	 * 删除:删除
	 */
	@PropertyDef(label = "删除", description = "删除:删除")
	private int del;

	public InvoicesPaying() {
		super();
	}

	public InvoicesPaying(int id, String sn, String deptid, Date createDate,
			Integer psid, String categoryPaying, int categoryDetailId,
			int transportId, String keyinid, String content,
			BigDecimal billing, String aorb, Date addTime, Date endTime,
			boolean valid,int del) {
		super();
		this.id = id;
		this.sn = sn;
		this.deptid = deptid;
		this.createDate = createDate;
		this.psid = psid;
		this.categoryPaying = categoryPaying;
		this.categoryDetailId = categoryDetailId;
		this.transportId = transportId;
		this.keyinid = keyinid;
		this.content = content;
		this.billing = billing;
		this.aorb = aorb;
		this.addTime = addTime;
		this.endTime = endTime;
		this.valid = valid;
		this.del = del;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@Column(name = "sn", length = 45)
	public String getSn() {
		return sn;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "deptId", length = 25)
	public String getDeptid() {
		return deptid;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Create_Date", nullable = false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setPsid(Integer psid) {
		this.psid = psid;
	}

	@Column(name = "psid", nullable = false)
	public Integer getPsid() {
		return psid;
	}

	public void setCategoryPaying(String categoryPaying) {
		this.categoryPaying = categoryPaying;
	}

	@Column(name = "category_paying", length = 45)
	public String getCategoryPaying() {
		return categoryPaying;
	}

	public void setCategoryDetailId(int categoryDetailId) {
		this.categoryDetailId = categoryDetailId;
	}

	@Column(name = "category_detail_id", nullable = false)
	public int getCategoryDetailId() {
		return categoryDetailId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	@Column(name = "transport_id")
	public int getTransportId() {
		return transportId;
	}

	public void setKeyinid(String keyinid) {
		this.keyinid = keyinid;
	}

	@Column(name = "keyinId", length = 25)
	public String getKeyinid() {
		return keyinid;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "content", length = 450)
	public String getContent() {
		return content;
	}

	public void setBilling(BigDecimal billing) {
		this.billing = billing;
	}

	@Column(name = "billing")
	public BigDecimal getBilling() {
		return billing;
	}

	public void setAorb(String aorb) {
		this.aorb = aorb;
	}

	@Column(name = "aorb", length = 4)
	public String getAorb() {
		return aorb;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "add_time")
	public Date getAddTime() {
		return addTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	public Date getEndTime() {
		return endTime;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Column(name = "valid")
	public boolean isValid() {
		return valid;
	}
	
	public void setDel(int del) {
		this.del = del;
	}

	@Column(name = "del")
	public int getDel() {
		return del;
	}

	public String toString() {
		return "InvoicesPaying [id=" + id + ",sn=" + sn + ",deptid=" + deptid
				+ ",createDate=" + createDate + ",psid=" + psid
				+ ",categoryPaying=" + categoryPaying + ",categoryDetailId="
				+ categoryDetailId + ",transportId=" + transportId
				+ ",keyinid=" + keyinid + ",content=" + content + ",billing="
				+ billing + ",aorb=" + aorb + ",addTime=" + addTime
				+ ",endTime=" + endTime + ",valid=" + valid + ",del=" + del + "]";
	}

}
