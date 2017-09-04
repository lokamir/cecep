package entity;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * bdf2_excel_model_detail:
 */
@Entity
@Table(name = "bdf2_excel_model_detail")
public class Bdf2ExcelModelDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;

	/**
	 * EXCEL_COLUMN_:
	 */
	@PropertyDef(label = "EXCEL_COLUMN_", description = "EXCEL_COLUMN_:")
	private int excelColumn;

	/**
	 * EXCEL_MODEL_ID_:
	 */
	@PropertyDef(label = "EXCEL_MODEL_ID_", description = "EXCEL_MODEL_ID_:")
	private String excelModelId;

	/**
	 * INTERCEPTOR_:
	 */
	@PropertyDef(label = "INTERCEPTOR_", description = "INTERCEPTOR_:")
	private String interceptor;

	/**
	 * NAME_:
	 */
	@PropertyDef(label = "NAME_", description = "NAME_:")
	private String name;

	/**
	 * TABLE_COLUMN_:
	 */
	@PropertyDef(label = "TABLE_COLUMN_", description = "TABLE_COLUMN_:")
	private String tableColumn;

	public Bdf2ExcelModelDetail() {
		super();
	}

	public Bdf2ExcelModelDetail(String id, int excelColumn,
			String excelModelId, String interceptor, String name,
			String tableColumn) {
		super();
		this.id = id;
		this.excelColumn = excelColumn;
		this.excelModelId = excelModelId;
		this.interceptor = interceptor;
		this.name = name;
		this.tableColumn = tableColumn;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 60, nullable = false)
	public String getId() {
		return id;
	}

	public void setExcelColumn(int excelColumn) {
		this.excelColumn = excelColumn;
	}

	@Column(name = "EXCEL_COLUMN_")
	public int getExcelColumn() {
		return excelColumn;
	}

	public void setExcelModelId(String excelModelId) {
		this.excelModelId = excelModelId;
	}

	@Column(name = "EXCEL_MODEL_ID_", length = 60)
	public String getExcelModelId() {
		return excelModelId;
	}

	public void setInterceptor(String interceptor) {
		this.interceptor = interceptor;
	}

	@Column(name = "INTERCEPTOR_", length = 120)
	public String getInterceptor() {
		return interceptor;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME_", length = 60)
	public String getName() {
		return name;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}

	@Column(name = "TABLE_COLUMN_", length = 60)
	public String getTableColumn() {
		return tableColumn;
	}

	public String toString() {
		return "Bdf2ExcelModelDetail [id=" + id + ",excelColumn=" + excelColumn
				+ ",excelModelId=" + excelModelId + ",interceptor="
				+ interceptor + ",name=" + name + ",tableColumn=" + tableColumn
				+ "]";
	}

}
