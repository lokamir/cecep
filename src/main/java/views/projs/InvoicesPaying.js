var loginusername = "${loginUsername}";

/** @Bind #dataPilotInvoicesPaying.onSubControlAction */
!function(self,arg){
	var datas = view.get("#dataSetInvoicesPaying.data");
	var action = view.get("#actionUpdate");
	switch(arg.code){
		case "+":{
			datas.insert();
			view.get("#dialogInvoicesPaying").show();
			arg.processDefault=false;
			break;
		}
		case "-":{
			dorado.MessageBox.confirm("您真的想删除当前数据吗?",function(){
				datas.remove();
				action.execute();
			});
			arg.processDefault=false;
			break;
		}
	}
};

/** @Bind #toolBarButtonEdit.onClick */
!function(self,arg){
	var data=view.get("#dataSetInvoicesPaying.data");
	debugger;
	var pid = view.get("#dataSetInvoicesPaying").getData("#.id");
	if(data.current){
		view.get("#dataSetInvoicesTransport").set("parameter", pid).flushAsync();
		view.get("#dialogInvoicesPaying").show();
	}else{
		dorado.MessageBox.alert("当前表没有信息可供编辑!");
	}
};

/** @Bind #toolBarButtonSubmit.onClick */
!function(self,arg){
	debugger;
	var action=view.get("#actionUpdate");
	var actionInvoicesTransport=view.get("#actionInvoicesTransport");
	var dataSetInvoicesTransport = view.get("#dataSetInvoicesTransport")
	if(typeof(view.get("#dataGridInvoicesPaying").get("selection")) == "undefined"){
		dorado.MessageBox.alert("当前没有选中需要提交的信息!");
	}
	view.get("#dataGridInvoicesPaying").get("selection").slice(0).each(function(entity){
		var psid = entity.get("psid")+1;
		var pid = entity.get("id");
		entity.set("psid",psid)
		switch(psid) {
			case 1:
				taskname = "已报送";
				break;
			case 2:
				taskname = "运管部已签";
				break;
			case 3:
				taskname = "财务部已签";
				break;
			case 4:
				taskname = "副总经理已签";
				break;
			case 5:
				taskname = "财务总监已签";
				break;
			case 6:
				taskname = "总经理已签";
				break;
			case 7:
				taskname = "签单结束";
				break;
		} 
		dataSetInvoicesTransport.insert({
			"keyinid":loginusername,
			"endTime":"${util.getDate()}",
			"pid":pid,
			"taskname":taskname
			});
		});
	action.execute(function(result){ 
		actionInvoicesTransport.execute();
							});
};


/** @Bind #toolBarButtonQuery.onClick */
!function(self,arg){
	var data = view.get("#formCondition.entity");
	with (view.get("#dataSetInvoicesPaying")){
		set("parameter", data);
		flushAsync();
	}
};

/** @Bind #buttonSubmit.onClick */
!function(self,arg){
	var dialog=view.get("#dialogInvoicesPaying");
	var action=view.get("#actionUpdate");
	dorado.MessageBox.confirm("您真的要保存吗?",function(){
		action.execute(function(){
			dialog.hide();
		});
	})
};

/** @Bind #buttonCancel.onClick */
!function(self,arg){
var data=view.get("#dataSetInvoicesPaying").getData();
var dialog=view.get("#dialogInvoicesPaying");
dorado.MessageBox.confirm("您真的要取消当前操作吗？",function(){
	data.cancel();
	dialog.hide();
	})
};
