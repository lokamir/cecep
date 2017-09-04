//author by lokamir


/** @Bind #beginDate.onPost */
/** @Bind #endDate.onPost */
!function(self, arg) {
	var entity = view.get("#criteria").get("entity");
	var beginDate = entity.get("beginDate");
	var endDate = entity.get("endDate");
	var params = {beginDate:beginDate,endDate:endDate};
	view.get("#dataSetOperated").set("parameter",params).flushAsync();
};

/** @Bind #toolBarButtonExport.onClick */
!function(self, arg) {
	var operatedcompany = view.get("#dataSetOperated").getData("#").get("operatedcompany");
	var date =new Date();
	date = view.get("#dataSetOperated").getData("#").get("operateddate");
	var dateyear = date.getFullYear();
	var datemonth = date.getMonth()+1;
	var d =dateyear+"-"+datemonth+"-"+date.getDate();
	switch(operatedcompany)
	{
	case 1:
		var filename = dateyear+"年"+datemonth+"月份惠山水务洛社污水厂运营日志";
		break;
	case 2:
		var filename = dateyear+"年"+datemonth+"月份惠山水务前洲污水厂运营日志";
		break;
	case 3:
		var filename = dateyear+"年"+datemonth+"月份惠山水务杨市污水厂运营日志";
		break;
	case 4:
		var filename = dateyear+"年"+datemonth+"月份惠山水务祝塘污水厂运营日志";
		break;
	}
    view.get("#uReport").set({
		exportFileName:filename,
		reportFile:"views/ureport/sheetmonthly.ureport.xml",
		parameter:{
			operateddate:d
		}
	}).execute();
};