package dao.funs;

import java.util.Date;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import entity.Bdf2Dept;
import entity.Biscompany;
import entity.InvoicesDetail;
import entity.Operated;
import entity.Process;

import com.bstek.bdf2.core.business.IDept;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;

@Component
public class El extends HibernateDao {
	
	//  获取当前时间  可以用dorado提供的 ${util.getToday()}
	//  ${dorado.getDataProvider("el#GetDate").getResult()}
	@DataProvider
	public Date GetDate() {
		Date now =new Date();
		return now;
	}
	
	//  
	//  ${dorado.getDataProvider("el#Uid").getResult()}
	@DataProvider
	public int Uid(){
		Session session =this.getSessionFactory().openSession();
		try{
		int uid; String str_uid;
		String UserName=ContextHolder.getLoginUser().getCname();
		String sql="select id from bdf2_user where cname_='"+UserName+"'";
		SQLQuery query=session.createSQLQuery(sql);		
		str_uid = query.uniqueResult().toString();
		uid=Integer.parseInt(str_uid);
		return uid;
		}finally{
		session.clear();
		session.close();
		}
	}

/*//  获取部门id
	//  ${dorado.getDataProvider("el#Deptid").getResult()}
	@DataProvider
	public int Deptid(){
		List<Integer> uid=new ArrayList<Integer>();
		List<IDept> listDepts = new ArrayList<IDept>();
		listDepts=ContextHolder.getLoginUser().getDepts();
		for(IDept listDept : listDepts){
			if (listDept.getName().contains("椋庨櫓")||listDept.getName().contains("娉曞姟") ){
				uid.add(Integer.parseInt(listDept.getId()));
			}
		}
		
		return uid.get(0);
	}*/
	//获取部门id
	//  ${dorado.getDataProvider("el#Deptid").getResult()}
		@DataProvider
		public String Deptid(){
			List<IDept> depts = ContextHolder.getLoginUser().getDepts();
			List<String> deptId = new ArrayList<String>();
			for (IDept dept : depts ){
				deptId.add(dept.getId());
			}
			return deptId.get(0);
		}
	
	//  
	//  ${dorado.getDataProvider("el#mapBdf2Depts").getResult()}
	@DataProvider
	public Map<String, String> mapBdf2Depts() {
		List<Bdf2Dept> bdf2Depts = this.query("from " + Bdf2Dept.class.getName());
		Map<String, String> mapValue = new LinkedHashMap<String, String>();
		//mapValue.put(null, "");
		for (Bdf2Dept bdf2Dept : bdf2Depts) {
			mapValue.put(bdf2Dept.getId(), bdf2Dept.getName());
		}
		return mapValue;
	}
	
//  ${dorado.getDataProvider("el#mapCategoryDetailId").getResult()}
	@DataProvider
	public Map<Integer, String> mapCategoryDetailId() {
		List<InvoicesDetail> invoicesDetails = this.query("from " + InvoicesDetail.class.getName());
		Map<Integer, String> mapValue = new LinkedHashMap<Integer, String>();
		//mapValue.put(null, "");
		for (InvoicesDetail invoicesDetail : invoicesDetails) {
			mapValue.put(invoicesDetail.getCategoryDetailId(), invoicesDetail.getName());
		}
		return mapValue;
	}
	
	
	//是否有效
	//  ${dorado.getDataProvider("el#mapValid").getResult()}
	@DataProvider
	public Map<String, String> mapValid() {
		Map<String, String> mapValue = new LinkedHashMap<String, String>();
		mapValue.put("2","全部");
		mapValue.put("1","是");
		mapValue.put("0","否");
		return mapValue;
	}
	
	//是否有效
		//  ${dorado.getDataProvider("el#mapBooleanValid").getResult()}
		@DataProvider
		public Map<Boolean, String> mapBooleanValid() {
			Map<Boolean, String> mapValue = new LinkedHashMap<Boolean, String>();
			mapValue.put(null,"全部");
			mapValue.put(Boolean.TRUE,"是");
			mapValue.put(Boolean.FALSE,"否");
			return mapValue;
		}
	
		//  单据报销执行记录流程
		//  ${dorado.getDataProvider("el#mapInvoicesPsid").getResult()}
		@DataProvider
		public Map<Integer, String> mapInvoicesPsid() {
			Map<Integer, String> mapValue = new LinkedHashMap<Integer, String>();
			mapValue.put(0,"未报送");
			mapValue.put(1,"已报送");
			mapValue.put(2,"运管部已签");
			mapValue.put(3,"财务部已签");
			mapValue.put(4,"副总经理已签");
			mapValue.put(5,"财务总监已签");
			mapValue.put(6,"总经理已签");
			mapValue.put(7,"签单结束");
			return mapValue;
		}
		

	
	//  接管企业
	//  ${dorado.getDataProvider("el#mapBiscompany").getResult()}
	@DataProvider
	public Map<Integer, String> mapBiscompany() {
		List<Biscompany> biscompanys = this.query("from " + Biscompany.class.getName());
		Map<Integer, String> mapValue = new LinkedHashMap<Integer, String>();
		mapValue.put(null, "");
		for (Biscompany biscompany : biscompanys) {
			mapValue.put(biscompany.getId(), biscompany.getName());
		}
		return mapValue;
	}
	
	//  import拦截
	@DataProvider
	public Map<Date,Integer> mapOperated() {
		List<Operated> operateds = this.query("from " + Operated.class.getName() + " where operatedCompany = 1");
		Map<Date,Integer> mapValue = new LinkedHashMap<Date,Integer>();
		for (Operated operated : operateds) {
			mapValue.put(operated.getDate(),operated.getId());
		}
		return mapValue;
	}
	@DataProvider
	public Map<String, Integer> mapProcess() {
		List<Process> processs = this.query("from " + Process.class.getName());
		Map<String, Integer> mapValue = new LinkedHashMap<String, Integer>();
		for (Process process : processs) {
			mapValue.put(process.getName(), process.getProcessid());
		}
		return mapValue;
	}
	
}
