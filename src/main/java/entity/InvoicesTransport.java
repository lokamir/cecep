package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * invoices_transport:单据报销执行流程记录
 */
@Entity
@Table(name = "invoices_transport")
public class InvoicesTransport implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * transport_id:
	 */
	@PropertyDef(label = "transport_id", description = "transport_id:")
	private int transportId;

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
	 * pid:
	 */
	@PropertyDef(label = "pid", description = "pid:")
	private int pid;

	/**
	 * 流转环节:流转环节
	 */
	@PropertyDef(label = "流转环节", description = "流转环节:流转环节")
	private String taskname;

	public InvoicesTransport() {
		super();
	}

	public InvoicesTransport(int transportId, String keyinid, Date addTime,
			Date endTime, boolean valid, int pid, String taskname) {
		super();
		this.transportId = transportId;
		this.keyinid = keyinid;
		this.addTime = addTime;
		this.endTime = endTime;
		this.valid = valid;
		this.pid = pid;
		this.taskname = taskname;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transport_id", nullable = false)
	public int getTransportId() {
		return transportId;
	}

	public void setKeyinid(String keyinid) {
		this.keyinid = keyinid;
	}

	@Column(name = "keyinId", length = 25, nullable = false)
	public String getKeyinid() {
		return keyinid;
	}

/*	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "add_time", nullable = false)
	public Date getAddTime() {
		return addTime;
	}*/

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

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name = "pid")
	public int getPid() {
		return pid;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	@Column(name = "taskname", length = 25)
	public String getTaskname() {
		return taskname;
	}

	public String toString() {
		return "InvoicesTransport [transportId=" + transportId + ",keyinid="
				+ keyinid + ",addTime=" + addTime + ",endTime=" + endTime
				+ ",valid=" + valid + ",pid=" + pid + ",taskname=" + taskname
				+ "]";
	}

}
