package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * bdf2_excel_model:
 */
@Entity
@Table(name = "bdf2_excel_model")
public class Bdf2ExcelModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;

	/**
	 * COMMENT_:
	 */
	@PropertyDef(label = "COMMENT_", description = "COMMENT_:")
	private String comment;

	/**
	 * COMPANYID_:
	 */
	@PropertyDef(label = "COMPANYID_", description = "COMPANYID_:")
	private String companyid;

	/**
	 * CREATE_DATE_:
	 */
	@PropertyDef(label = "CREATE_DATE_", description = "CREATE_DATE_:")
	private Date createDate;

	/**
	 * DATASOURCE_NAME_:
	 */
	@PropertyDef(label = "DATASOURCE_NAME_", description = "DATASOURCE_NAME_:")
	private String datasourceName;

	/**
	 * DB_TYPE_:
	 */
	@PropertyDef(label = "DB_TYPE_", description = "DB_TYPE_:")
	private String dbType;

	/**
	 * END_COLUMN_:
	 */
	@PropertyDef(label = "END_COLUMN_", description = "END_COLUMN_:")
	private int endColumn;

	/**
	 * END_ROW_:
	 */
	@PropertyDef(label = "END_ROW_", description = "END_ROW_:")
	private int endRow;

	/**
	 * EXCEL_SHEET_NAME_:
	 */
	@PropertyDef(label = "EXCEL_SHEET_NAME_", description = "EXCEL_SHEET_NAME_:")
	private String excelSheetName;

	/**
	 * HELP_DOC_:
	 */
	@PropertyDef(label = "HELP_DOC_", description = "HELP_DOC_:")
	private String helpDoc;

	/**
	 * NAME_:
	 */
	@PropertyDef(label = "NAME_", description = "NAME_:")
	private String name;

	/**
	 * PRIMARYKEY_:
	 */
	@PropertyDef(label = "PRIMARYKEY_", description = "PRIMARYKEY_:")
	private String primarykey;

	/**
	 * PRIMARYKEY_TYPE_:
	 */
	@PropertyDef(label = "PRIMARYKEY_TYPE_", description = "PRIMARYKEY_TYPE_:")
	private String primarykeyType;

	/**
	 * PROCESSOR_:
	 */
	@PropertyDef(label = "PROCESSOR_", description = "PROCESSOR_:")
	private String processor;

	/**
	 * SEQUENCE_NAME_:
	 */
	@PropertyDef(label = "SEQUENCE_NAME_", description = "SEQUENCE_NAME_:")
	private String sequenceName;

	/**
	 * START_COLUMN_:
	 */
	@PropertyDef(label = "START_COLUMN_", description = "START_COLUMN_:")
	private int startColumn;

	/**
	 * START_ROW_:
	 */
	@PropertyDef(label = "START_ROW_", description = "START_ROW_:")
	private int startRow;

	/**
	 * TABLE_LABEL_:
	 */
	@PropertyDef(label = "TABLE_LABEL_", description = "TABLE_LABEL_:")
	private String tableLabel;

	/**
	 * TABEL_NAME_:
	 */
	@PropertyDef(label = "TABEL_NAME_", description = "TABEL_NAME_:")
	private String tabelName;

	public Bdf2ExcelModel() {
		super();
	}

	public Bdf2ExcelModel(String id, String comment, String companyid,
			Date createDate, String datasourceName, String dbType,
			int endColumn, int endRow, String excelSheetName, String helpDoc,
			String name, String primarykey, String primarykeyType,
			String processor, String sequenceName, int startColumn,
			int startRow, String tableLabel, String tabelName) {
		super();
		this.id = id;
		this.comment = comment;
		this.companyid = companyid;
		this.createDate = createDate;
		this.datasourceName = datasourceName;
		this.dbType = dbType;
		this.endColumn = endColumn;
		this.endRow = endRow;
		this.excelSheetName = excelSheetName;
		this.helpDoc = helpDoc;
		this.name = name;
		this.primarykey = primarykey;
		this.primarykeyType = primarykeyType;
		this.processor = processor;
		this.sequenceName = sequenceName;
		this.startColumn = startColumn;
		this.startRow = startRow;
		this.tableLabel = tableLabel;
		this.tabelName = tabelName;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 60, nullable = false)
	public String getId() {
		return id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "COMMENT_", length = 120)
	public String getComment() {
		return comment;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	@Column(name = "COMPANYID_", length = 60)
	public String getCompanyid() {
		return companyid;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE_")
	public Date getCreateDate() {
		return createDate;
	}

	public void setDatasourceName(String datasourceName) {
		this.datasourceName = datasourceName;
	}

	@Column(name = "DATASOURCE_NAME_", length = 60)
	public String getDatasourceName() {
		return datasourceName;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	@Column(name = "DB_TYPE_", length = 60)
	public String getDbType() {
		return dbType;
	}

	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}

	@Column(name = "END_COLUMN_")
	public int getEndColumn() {
		return endColumn;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Column(name = "END_ROW_")
	public int getEndRow() {
		return endRow;
	}

	public void setExcelSheetName(String excelSheetName) {
		this.excelSheetName = excelSheetName;
	}

	@Column(name = "EXCEL_SHEET_NAME_", length = 60)
	public String getExcelSheetName() {
		return excelSheetName;
	}

	public void setHelpDoc(String helpDoc) {
		this.helpDoc = helpDoc;
	}

	@Column(name = "HELP_DOC_", length = 60)
	public String getHelpDoc() {
		return helpDoc;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME_", length = 60)
	public String getName() {
		return name;
	}

	public void setPrimarykey(String primarykey) {
		this.primarykey = primarykey;
	}

	@Column(name = "PRIMARYKEY_", length = 60)
	public String getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykeyType(String primarykeyType) {
		this.primarykeyType = primarykeyType;
	}

	@Column(name = "PRIMARYKEY_TYPE_", length = 60)
	public String getPrimarykeyType() {
		return primarykeyType;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Column(name = "PROCESSOR_", length = 120)
	public String getProcessor() {
		return processor;
	}

	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	@Column(name = "SEQUENCE_NAME_", length = 120)
	public String getSequenceName() {
		return sequenceName;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	@Column(name = "START_COLUMN_")
	public int getStartColumn() {
		return startColumn;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	@Column(name = "START_ROW_")
	public int getStartRow() {
		return startRow;
	}

	public void setTableLabel(String tableLabel) {
		this.tableLabel = tableLabel;
	}

	@Column(name = "TABLE_LABEL_", length = 120)
	public String getTableLabel() {
		return tableLabel;
	}

	public void setTabelName(String tabelName) {
		this.tabelName = tabelName;
	}

	@Column(name = "TABEL_NAME_", length = 120)
	public String getTabelName() {
		return tabelName;
	}

	public String toString() {
		return "Bdf2ExcelModel [id=" + id + ",comment=" + comment
				+ ",companyid=" + companyid + ",createDate=" + createDate
				+ ",datasourceName=" + datasourceName + ",dbType=" + dbType
				+ ",endColumn=" + endColumn + ",endRow=" + endRow
				+ ",excelSheetName=" + excelSheetName + ",helpDoc=" + helpDoc
				+ ",name=" + name + ",primarykey=" + primarykey
				+ ",primarykeyType=" + primarykeyType + ",processor="
				+ processor + ",sequenceName=" + sequenceName + ",startColumn="
				+ startColumn + ",startRow=" + startRow + ",tableLabel="
				+ tableLabel + ",tabelName=" + tabelName + "]";
	}

}
