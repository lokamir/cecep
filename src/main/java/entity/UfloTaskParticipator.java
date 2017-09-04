package entity;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * uflo_task_participator:
 */
@Entity
@Table(name = "uflo_task_participator")
public class UfloTaskParticipator implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private long id;

	/**
	 * USER_:
	 */
	@PropertyDef(label = "USER_", description = "USER_:")
	private String user;

	/**
	 * uflo_task:
	 */
	@PropertyDef(label = "", description = "uflo_task:")
	private UfloTask ufloTask;

	public UfloTaskParticipator() {
		super();
	}

	public UfloTaskParticipator(long id, String user, UfloTask ufloTask) {
		super();
		this.id = id;
		this.user = user;
		this.ufloTask = ufloTask;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", nullable = false)
	public long getId() {
		return id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "USER_", length = 60)
	public String getUser() {
		return user;
	}

	public void setUfloTask(UfloTask ufloTask) {
		this.ufloTask = ufloTask;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_ID_", nullable = false)
	public UfloTask getUfloTask() {
		return ufloTask;
	}

	public String toString() {
		return "UfloTaskParticipator [id=" + id + ",user=" + user
				+ ",ufloTask=" + ufloTask + "]";
	}

}
