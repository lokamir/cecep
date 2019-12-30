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
import com.bstek.bdf2.core.model.Group;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
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
		boolean sncontains = false;
		boolean validcontains = false;
		String whereCase = " where 1 = 1 ";
		IUser user = ContextHolder.getLoginUser();
		if(user == null){
			return;
		}
		List<Group> bdf2Groups = ContextHolder.getLoginUser().getGroups();
		boolean isadmin = ContextHolder.getLoginUser().isAdministrator();
		if(param != null){
			bcontains = param.containsKey("beginDate");
			econtains = param.containsKey("endDate");
			deptidcontains = param.containsKey("deptid");
			sncontains = param.containsKey("sn");
			validcontains = param.containsKey("valid");
		}
		if(bcontains && param.get("beginDate")!=null ){
			Date beginDate = (Date)param.get("beginDate");
			String date =new SimpleDateFormat("YYYY-MM-dd").format(beginDate);
			whereCase += " And DATE_FORMAT(ORDERDATE,'%Y-%m-%d') >= DATE_FORMAT('"
					+ date + "' ,'%Y-%m-%d')";
		}
		if(econtains && param.get("endDate")!=null ){
			Date endDate = (Date)param.get("endDate");
			String date =new SimpleDateFormat("YYYY-MM-dd").format(endDate);
			whereCase += " And DATE_FORMAT(ORDERDATE,'%Y-%m-%d') <= DATE_FORMAT('"
					+ date + "' ,'%Y-%m-%d')";
		}
		if(deptidcontains && !param.get("deptid").toString().equals("")){
			whereCase += " And CUS_ID = " + param.get("deptid");
		}
		if(validcontains && !param.get("valid").toString().equals("")){
			whereCase += " And VALID = " + param.get("valid");
		}
		if(sncontains && !param.get("sn").toString().equals("")){
			String sn = param.get("sn").toString();
			if(isNumeric(sn)){
				sn = subStrForMath(sn);
			}
			whereCase += " And sn like '%" + sn + "%'";
		}
		if(isadmin){
			sql = " from " + InvoicesPaying.class.getName() + whereCase + " and del = 0 order by id desc";
		}else{
			String arg = bdf2Groups.get(0).getName();
			/*Collection<Bdf2Group> customers = groupDao.loadCustomerForRank(arg);
			StringBuilder s = new StringBuilder();
			for(Bdf2Group customer:customers){
				if (customer != null && !"".equals(customer)) {
					s.append(",");
	                s.append(customer.getId());
	            }
			}
			s.deleteCharAt(0);*/
			whereCase += " And CUS_ID = '" + arg.toString()+"'";
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
