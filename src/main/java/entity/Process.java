package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * process:
 */
@Entity
@Table(name = "process")
public class Process implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * processId:
	 */
	@PropertyDef(label = "processId", description = "processId:")
	private int processid;

	/**
	 * 工艺段名称:工艺段名称
	 */
	@PropertyDef(label = "工艺段名称", description = "工艺段名称:工艺段名称")
	private String name;

	/**
	 * 隶属水厂:隶属水厂
	 */
	@PropertyDef(label = "隶属水厂", description = "隶属水厂:隶属水厂")
	private String deptid;

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
	 * timestemp:
	 */
	@PropertyDef(label = "timestemp", description = "timestemp:")
	private Date timestemp;

	/**
	 * analysis_intr:系统样
	 */
	private Set<AnalysisIntr> analysisIntrSet = new HashSet<AnalysisIntr>(0);

	/**
	 * analysis_sludge:
	 */
	private Set<AnalysisSludge> analysisSludgeSet = new HashSet<AnalysisSludge>(
			0);

	public Process() {
		super();
	}

	public Process(int processid, String name, String deptid, boolean valid,
			String memo, Date timestemp, Set<AnalysisIntr> analysisIntrSet,
			Set<AnalysisSludge> analysisSludgeSet) {
		super();
		this.processid = processid;
		this.name = name;
		this.deptid = deptid;
		this.valid = valid;
		this.memo = memo;
		this.timestemp = timestemp;
		this.analysisIntrSet = analysisIntrSet;
		this.analysisSludgeSet = analysisSludgeSet;
	}

	public void setProcessid(int processid) {
		this.processid = processid;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "processId", nullable = false)
	public int getProcessid() {
		return processid;
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

	public void setTimestemp(Date timestemp) {
		this.timestemp = timestemp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestemp", nullable = false)
	public Date getTimestemp() {
		return timestemp;
	}

	public void setAnalysisIntrSet(Set<AnalysisIntr> analysisIntrSet) {
		this.analysisIntrSet = analysisIntrSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "process")
	public Set<AnalysisIntr> getAnalysisIntrSet() {
		return analysisIntrSet;
	}

	public void setAnalysisSludgeSet(Set<AnalysisSludge> analysisSludgeSet) {
		this.analysisSludgeSet = analysisSludgeSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "process")
	public Set<AnalysisSludge> getAnalysisSludgeSet() {
		return analysisSludgeSet;
	}

	public String toString() {
		return "Process [processid=" + processid + ",name=" + name + ",deptid="
				+ deptid + ",valid=" + valid + ",memo=" + memo + ",timestemp="
				+ timestemp + ",analysisIntrSet=" + analysisIntrSet
				+ ",analysisSludgeSet=" + analysisSludgeSet + "]";
	}

}
