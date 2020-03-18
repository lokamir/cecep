package entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * equipment:设备管理
 */
@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private int id;

	/**
	 * 设备名称:设备名称
	 */
	@PropertyDef(label = "设备名称", description = "设备名称:设备名称")
	private String name;

	/**
	 * 维修时间:维修时间
	 */
	@PropertyDef(label = "维修时间", description = "维修时间:维修时间")
	private Date rtime;

	/**
	 * 故障原因:故障原因
	 */
	@PropertyDef(label = "故障原因", description = "故障原因:故障原因")
	private String rereason;

	/**
	 * 维修详情:维修详情
	 */
	@PropertyDef(label = "维修详情", description = "维修详情:维修详情")
	private String redetail;

	/**
	 * 备注:备注
	 */
	@PropertyDef(label = "备注", description = "备注:备注")
	private String memo;
	
	/**
	 * 隶属水厂
	 */
	@PropertyDef(label = "隶属水厂", description = "隶属水厂:隶属水厂")
	private String deptid;

	public Equipment() {
		super();
	}

	public Equipment(int id, String name, Date rtime, String rereason,
			String redetail, String memo,String deptid) {
		super();
		this.id = id;
		this.name = name;
		this.rtime = rtime;
		this.rereason = rereason;
		this.redetail = redetail;
		this.memo = memo;
		this.deptid = deptid;
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

	@Column(name = "name", length = 45)
	public String getName() {
		return name;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "rtime")
	public Date getRtime() {
		return rtime;
	}

	public void setRereason(String rereason) {
		this.rereason = rereason;
	}

	@Column(name = "rereason", length = 200)
	public String getRereason() {
		return rereason;
	}

	public void setRedetail(String redetail) {
		this.redetail = redetail;
	}

	@Column(name = "redetail", length = 1000)
	public String getRedetail() {
		return redetail;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "memo", length = 400)
	public String getMemo() {
		return memo;
	}
	
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@Column(name = "deptId", length = 25)
	public String getDeptid() {
		return deptid;
	}

	public String toString() {
		return "Equipment [id=" + id + ",name=" + name + ",rtime=" + rtime
				+ ",rereason=" + rereason + ",redetail=" + redetail + ",memo="
				+ memo + ",deptid="+ deptid + "]";
	}

}
