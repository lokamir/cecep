package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * invoices_detail:单据费用的类别
 */
@Entity
@Table(name = "invoices_detail")
public class InvoicesDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * category_detail_id:
	 */
	@PropertyDef(label = "category_detail_id", description = "category_detail_id:")
	private int categoryDetailId;

	/**
	 * 单据费用类别名称:单据费用类别名称
	 */
	@PropertyDef(label = "单据费用类别名称", description = "单据费用类别名称:单据费用类别名称")
	private String name;

	/**
	 * 隶属水厂:隶属水厂
	 */
	@PropertyDef(label = "隶属水厂", description = "隶属水厂:隶属水厂")
	private String deptid;

	/**
	 * 是否显示在维护页面:是否显示在维护页面
	 */
	@PropertyDef(label = "是否显示在维护页面", description = "是否显示在维护页面:是否显示在维护页面")
	private boolean valid;

	/**
	 * 备注:备注
	 */
	@PropertyDef(label = "备注", description = "备注:备注")
	private String memo;

	/**
	 * timestemp:
	 */
	@PropertyDef(label = "timestemp", description = "timestemp:")
	private Date timestemp;
	
	/**
	 * 删除:删除
	 */
	@PropertyDef(label = "删除", description = "删除:删除")
	private int del;

	public InvoicesDetail() {
		super();
	}

	public InvoicesDetail(int categoryDetailId, String name, String deptid,
			boolean valid, String memo, Date timestemp,int del) {
		super();
		this.categoryDetailId = categoryDetailId;
		this.name = name;
		this.deptid = deptid;
		this.valid = valid;
		this.memo = memo;
		this.timestemp = timestemp;
		this.del = del;
	}

	public void setCategoryDetailId(int categoryDetailId) {
		this.categoryDetailId = categoryDetailId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_detail_id", nullable = false)
	public int getCategoryDetailId() {
		return categoryDetailId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name", length = 45)
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

	public void setDel(int del) {
		this.del = del;
	}

	@Column(name = "del")
	public int getDel() {
		return del;
	}
	
	public void setTimestemp(Date timestemp) {
		this.timestemp = timestemp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestemp", nullable = false)
	public Date getTimestemp() {
		return timestemp;
	}

	public String toString() {
		return "InvoicesDetail [categoryDetailId=" + categoryDetailId
				+ ",name=" + name + ",deptid=" + deptid + ",valid=" + valid
				+ ",memo=" + memo + ",timestemp=" + timestemp + ",del=" + del  + "]";
	}

}
