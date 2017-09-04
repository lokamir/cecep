/*
 * 
 * author by lokamir
 * 
 * */


var insertNum;

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
		reportFile:"views/ureport/sheetdaily.ureport.xml",
		parameter:{
			operateddate:d
		}
	}).execute();
};



/** @Bind #toolBarButtonEditor.onClick */
!function(self, arg) {
	//window.open("views.projs.everyday.d");
	view.get("#dialogDetail").show();
};

/** @Bind #toolBarButtonNew.onClick */
!function(self, arg) {
	insertNum = 1;
	var dataset = view.get("#dataSetOperated");
	var operatedInflow_before = dataset.getData().getFirst().get("operatedinflowTotal");
	var operatedOutflow_before = dataset.getData().getFirst().get("operatedoutflowTotal");
	var operatedinflowCp_before = dataset.getData().getFirst().get("operatedinflowCp");
	var operatedoutflowCp_before = dataset.getData().getFirst().get("operatedoutflowCp");
	var ld = dataset.getData().getFirst().get("operateddate");
	var booleanIn = dataset.getData().getFirst().get("operatedinflowTotal");
	var booleanOut = dataset.getData().getFirst().get("operatedoutflowTotal");
	var nd = new Date(ld.setDate(ld.getDate()+1));
	var temp = new Date();
	if(booleanIn&&booleanOut){
		view.get("#dataSetOperated").insert({
			operatedcompany:1,
			operateddate:nd,
			operatedinflowBefore:operatedInflow_before,
			operatedoutflowBefore:operatedOutflow_before,
			operatedinflowCp:operatedinflowCp_before,
			operatedoutflowCp:operatedoutflowCp_before,
			timestamp:temp
		});
		var updateActionSaveOperateds = view.get("#updateActionSaveOperateds");
		view.get("#updateActionSaveOperateds").execute();
		view.get("#dataSetOperated").flushAsync();
		//view.get("#dialogDetail").show();
	}else{
		var rq =ld.getFullYear()+"年"+(ld.getMonth()+1)+"月"+(ld.getDate()-1)+"日";
		dorado.MessageBox.alert("先填写【"+rq+"】的报表")
	}
};

/** @Bind #updateActionSaveOperateds.beforeExecute */
!function(self,arg){
     //var dataSetOperated = view.get("#dataSetOperated").getData("#");
   
     
};

/** @Bind #buttonSave.onClick */
!function(self, arg) {
	var updateActionSaveOperateds = view.get("#updateActionSaveOperateds");
	view.get("#updateActionSaveOperateds").execute(function(){
		view.get("#dataSetOperated").flushAsync();
		view.get("#dialogDetail").hide();
	});
};

/** @Bind #buttonClose.onClick */
!function(self, arg) {
	if(view.get("#dataSetOperated").getData("#").isCascadeDirty()){
		dorado.MessageBox.confirm("报表还未保存，现在就退出吗？", function() {
			view.get("#dataSetOperated").getData("#").cancel();
			view.get("#dataSetOperated").flushAsync();
			view.get("#dialogDetail").hide();
		});
	}else{
		//view.get("#dataSetOperated").flushAsync();
		view.get("#dialogDetail").hide();
	}

};

/** @Bind #textEditorInflow.onPost */
/** @Bind #textEditorOutflow.onPost */
!function(self, arg) {
	var entity = view.get("#dataSetOperated").getData("#");
	var incurrent = entity.get("operatedinflowTotal");
	var outcurrent = entity.get("operatedoutflowTotal");
	var inflowbefore =  entity.get("operatedinflowBefore");
	var outflowbefore =  entity.get("operatedoutflowBefore");
	var inflow = incurrent-inflowbefore;
	var outflow = outcurrent-outflowbefore;
	if(inflow<0){
		var len = inflowbefore.toString().length;
		var mi = Math.pow(10,len);
		inflow = incurrent-inflowbefore + mi
		var operatedinflowCp = entity.get("operatedinflowCp");
		entity.set("operatedinflowCp",operatedinflowCp+1)
	}
	if(outflow<0){
		var len = outflowbefore.toString().length;
		var mi = Math.pow(10,len);
		outflow = outcurrent-outflowbefore + mi
		var operatedoutflowCp = entity.get("operatedoutflowCp");
		entity.set("operatedoutflowCp",operatedoutflowCp+1)
	}
	entity.set("operatedinflow",inflow );
	entity.set("operatedoutflow",outflow);
};

/** @Bind #dataPilotAnalysisIn.onSubControlAction */
!function(self, arg) {
	switch (arg.code){
	case "-":{
		arg.processDefault = false;
		view.get("#dataSetOperated").getData("#.#analysisInSet").remove();
		break;
	}
	}
};

/** @Bind #dataPilotAnalysisOut.onSubControlAction */
!function(self, arg) {
	switch (arg.code){
	case "-":{
		arg.processDefault = false;
		view.get("#dataSetOperated").getData("#.#analysisOutSet").remove();
		break;
	}
	}
};

/** @Bind #dataPilotAnalysisElse.onSubControlAction */
!function(self, arg) {
	switch (arg.code){
		case "-":{
			arg.processDefault = false;
			view.get("#dataSetOperated").getData("#.#analysisElseSet").remove();
			break;
		}
	}
};