/*=======================新增和删除===================*/
/** @Bind #pilot.onSubControlAction */
!function(self,arg){
	var datas = view.get("#dataSetInvoicesDetail.data");
	var action = view.get("#actionUpdate");
	switch(arg.code){
/*		case "+":{
			datas.insert({"dataSetInvoicesDetail":""});
			var action=view.get("#actionUpdate");
			action.execute();
			arg.processDefault=false;
			break;
		}*/
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

/*=======================保存前校验空值===================*/
/** @Bind #actionUpdate.beforeExecute *//*
!function(self,arg){
	var data = view.get("#dataSetInvoicesDetail").getData();
	data.each(function(entity){
		if (entity.get("category") == null) {
			entity.cancel();
		}
	})
};*/