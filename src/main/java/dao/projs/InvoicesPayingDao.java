package dao.projs;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.hibernate.Session;
import org.springframework.stereotype.Component;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.bstek.bdf2.core.business.IDept;
import com.bstek.bdf2.core.business.IUser;

import entity.InvoicesPaying;
@Component
public class InvoicesPayingDao extends HibernateDao {
	

	
	@DataProvider
	public Collection<InvoicesPaying> loadInvoicesPaying() throws Exception {
			String hql="from " + InvoicesPaying.class.getName();
			return this.query(hql);
	}
	
	@DataProvider
	public void queryPage(Page<InvoicesPaying> page,Map<String, Object> param) throws Exception{
		String sql = "";
		boolean bcontains = false;
		boolean econtains = false;
		boolean deptidcontains = false;
		boolean categoryDetailIdcontains = false;
		boolean contentcontains = false;
		boolean validcontains = false;
		String whereCase = " where 1 = 1 ";
		IUser user = ContextHolder.getLoginUser();
		if(user == null){
			return;
		}
		List<IDept> IDepts = ContextHolder.getLoginUser().getDepts();
		boolean isadmin = ContextHolder.getLoginUser().isAdministrator();
		if(param != null){
			bcontains = param.containsKey("beginDate");
			econtains = param.containsKey("endDate");
			deptidcontains = param.containsKey("deptid");
			categoryDetailIdcontains = param.containsKey("categoryDetailId");
			contentcontains = param.containsKey("content");
			validcontains = param.containsKey("valid");
		}
		if(bcontains && param.get("beginDate")!=null ){
			Date beginDate = (Date)param.get("beginDate");
			String date =new SimpleDateFormat("yyyy-MM-dd").format(beginDate);
			whereCase += " And DATE_FORMAT(Create_Date,'%Y-%m-%d') >= DATE_FORMAT('"
					+ date + "' ,'%Y-%m-%d')";
		}
		if(econtains && param.get("endDate")!=null ){
			Date endDate = (Date)param.get("endDate");
			String date =new SimpleDateFormat("yyyy-M-dd").format(endDate);
			whereCase += " And DATE_FORMAT(Create_Date,'%Y-%m-%d') <= DATE_FORMAT('"
					+ date + "' ,'%Y-%m-%d')";
		}
		if(deptidcontains && !param.get("deptid").toString().equals("")){
			whereCase += " And deptid = " + param.get("deptid");
		}
		if(validcontains && !param.get("valid").toString().equals("2")){
			whereCase += " And VALID = " + param.get("valid");
		}
		if(categoryDetailIdcontains && !param.get("categoryDetailId").toString().equals("2")){
			String sn = param.get("categoryDetailIdcontains").toString();
			/*if(isNumeric(sn)){
				sn = subStrForMath(sn);
			}*/
			whereCase += " And categoryDetailId = " + param.get("categoryDetailId");
			whereCase += " And sn like '%" + sn + "%'";
		}
		if(contentcontains && !param.get("content").toString().equals("")){
			whereCase += " And content like '%" + param.get("content") + "%'";
		}
		if(isadmin){
			sql = " from " + InvoicesPaying.class.getName() + whereCase + " and del = 0 order by id desc";
		}else{
			//String arg = IDepts.get(0).getName();
			/*Collection<Bdf2Group> customers = groupDao.loadCustomerForRank(arg);
			StringBuilder s = new StringBuilder();
			for(Bdf2Group customer:customers){
				if (customer != null && !"".equals(customer)) {
					s.append(",");
	                s.append(customer.getId());
	            }
			}
			s.deleteCharAt(0);*/
			//whereCase += " And deptId = '" + arg.toString()+"'";
			sql = " from " + InvoicesPaying.class.getName() + whereCase + " and del = 0 order by id desc ";
		}
		this.pagingQuery(page, sql , "select count(*) "+sql);
		
	}
	
	@DataResolver
	public void saveInvoicesPaying(Collection<InvoicesPaying> invoicesPayings) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(InvoicesPaying invoicesPaying : invoicesPayings){
				EntityState state = EntityUtils.getState(invoicesPaying);
				if(state.equals(EntityState.NEW)){
					session.save(invoicesPaying);
				}
				if(state.equals(EntityState.MODIFIED)){
					session.update(invoicesPaying);
				}
				if(state.equals(EntityState.DELETED)){
					invoicesPaying.setDel(1);
					session.update(invoicesPaying);
				}
			}
		
		} finally{
			session.flush();
			session.close();
		}
	}
	
	protected String subStrForMath(String str){  
        String string="";  
        for (int i = 0; i < str.length(); i++){  
            String str0="";  
        if (str.substring(i, i + 1).matches("[\u4e00-\u9fa5]+")){  
            }else{  
            str0 = str.substring(i, i + 1) + "";  
             }  
            string +=str0;  
           }  
        return string;  
        } 

	
	protected boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
 }
	
}
