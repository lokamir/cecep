var loginusername = "${loginUser.getCname()}";
var loginuserdept = "${dorado.getDataProvider('el#Deptid').getResult()}";

/** @Bind view.onReady */
!function(self,arg){
	if(loginuserdept == "00111" ){
		view.get("#toolBarButtonSubmit").set("visible",true);
		view.get("#toolBarButtonSubmitUp").set("visible",false);
		view.get("#dataPilotInvoicesPaying").set("itemCodes","pageSize,pages");
		view.get("#dataSetInvoicesPaying").set("readOnly",true);
		view.get("#toolBarButtonEdit").set("visible",true);
	}else{
		view.get("#toolBarButtonSubmit").set("visible",false);
		view.get("#toolBarButtonSubmitUp").set("visible",true);
		view.get("#dataPilotInvoicesPaying").set("itemCodes","pageSize,pages,+,-");
		view.get("#toolBarButtonEdit").set("visible",true);
	}
};

/** @Bind #dataPilotInvoicesPaying.onSubControlAction */
!function(self,arg){
	var datas = view.get("#dataSetInvoicesPaying.data");
	//不让dataSetInvoicesTransport加载数据
	view.get("#dataSetInvoicesTransport").set("parameter", -1).flushAsync();
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
	var bealn = view.get("#dataGridInvoicesPaying").get("selection").slice(0);
	if(typeof(bealn) == "undefined"||bealn.length <= 0){
		var entity = view.get("#dataGridInvoicesPaying").getCurrentEntity("entity");
		if(entity.get("psid")>0){
			flowfront(entity);			
		}else{
			dorado.MessageBox.alert("单据需要先由水厂上报!");
		}
	}else{
		view.get("#dataGridInvoicesPaying").get("selection").slice(0).each(function(entity){
			if(entity.get("psid")>0){
				flowfront(entity);			
			}
		});
	}
	
};

/** @Bind #toolBarButtonSubmitUp.onClick */
!function(self,arg){
	debugger;
	var bealn = view.get("#dataGridInvoicesPaying").get("selection").slice(0);
	if(typeof(bealn) == "undefined"||bealn.length <= 0){
		var entity = view.get("#dataGridInvoicesPaying").getCurrentEntity("entity");
		if(entity.get("psid")==0){
			flowfront(entity);			
		}else{
			dorado.MessageBox.alert("单据已上报!");
		}
	}else{
		view.get("#dataGridInvoicesPaying").get("selection").slice(0).each(function(entity){
			if(entity.get("psid")==0){
				flowfront(entity);			
			}
		});
	}
	
};

/* =======================查询按钮=================== */
/** @Bind #toolBarButtonQuery.onClick */
!function(self,arg){
	var data = view.get("#formCondition.entity");
	with (view.get("#dataSetInvoicesPaying")){
		set("parameter", data);
		flushAsync();
	}
};

/** @Bind #tabControl.onTabChange */
!function(self,arg){
	var data = view.get("#formCondition.entity");
	if(view.get("#tabControl").get("currentTab.caption")=="正在签批"){		
		data.set("valid",0);
		view.get("#dataSetInvoicesPaying").set("parameter", data).flushAsync();
	}else{
		data.set("valid",1);
		view.get("#dataSetInvoicesPaying").set("parameter", data).flushAsync();
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

/* =======================付款按钮=================== */
/** @Bind #dataGridInvoicesPaying.onCreate */
!function(self,arg){
	var OperationCellRenderer = $extend(dorado.widget.grid.SubControlCellRenderer,
			{
			    createSubControl : function(arg) {
			        if (arg.data.rowType){			        	
			        	return null;
			        }
			        // 返回按钮对象并为按钮对象绑定onClick事件
			        return new dorado.widget.Button({
			            onClick : function(self) {
			                // 获取当前对象
			                var entity = arg.data;
			                // 在点击后，执行update，valid改为1，endTime改为当前日期
			            
			                	dorado.MessageBox.confirm("请确认此单据已完成付款\n  此操作不可更改",
			                		function(){
			                		entity.set("endTime", new Date());
					                entity.set("valid", 1);
			                		view.get("#actionUpdate").execute()
			                })
			            }
			        });
			    },
			    refreshSubControl : function(button, arg) {
			    	var psid = arg.data.get("psid");
			        var valid = arg.data.get("valid");
			        if(psid == 7){
			        	button.set({
			        		caption : (valid != "1") ? "未付款" : "已付款",
			        				disabled : (valid == "1")
			        	});			        	
			        }else{
			        	button.set({
			        		caption : "签批中",
			        		disabled : true
			        	});	
			        }
			    }
			});
			self.set("#valid.renderer", new OperationCellRenderer());
}

/* =======================付款按钮2=================== */
/** @Bind #dataGridInvoicesPaying2.onCreate */
!function(self,arg){
	var OperationCellRenderer = $extend(dorado.widget.grid.SubControlCellRenderer,
			{
			    refreshSubControl : function(button, arg) {
			    	var psid = arg.data.get("psid");
			        var valid = arg.data.get("valid");
			        if(psid == 7){
			        	button.set({
			        		caption : (valid != "1") ? "未付款" : "已付款",
			        				disabled : (valid == "1")
			        	});			        	
			        }else{
			        	button.set({
			        		caption : "签批中",
			        		disabled : true
			        	});	
			        }
			    }
			});
			self.set("#valid.renderer", new OperationCellRenderer());
}


/* =======================aorb的key-vlaue=================== */
/** @Bind #autoForm.onReady */
!function(self, arg, text) {
	text.set("mapping", [ {
		key : "A类",
		value : "A类"
	}, {
		key : "B类",
		value : "B类"
	}]);
};

/* =======================流程向后继续=================== */
function flowfront(entity){
	var action=view.get("#actionUpdate");
	var actionInvoicesTransport=view.get("#actionInvoicesTransport");
	var dataSetInvoicesTransport = view.get("#dataSetInvoicesTransport")
	if(entity.get("psid")==7){
		return false;
	}
	var psid = entity.get("psid")+1;
	var pid = entity.get("id");
	entity.set("psid",psid);
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
		"endTime":new Date(),
		"pid":pid,
		"taskname":taskname
		});
	
	action.execute(function(result){ 
		actionInvoicesTransport.execute();
						});
};