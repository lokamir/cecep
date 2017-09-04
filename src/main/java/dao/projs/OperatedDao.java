package dao.projs;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;

import entity.Operated;
@Component
public class OperatedDao extends HibernateDao {
	@DataProvider
	public Collection<Operated> loadbiscompany() throws Exception {
			String hql="from " + Operated.class.getName();
			return this.query(hql);
	}
	
	@DataProvider
	public void queryPage(Page<Operated> page,Map<String, Object> param) throws Exception{
		boolean bcontains = false;
		boolean econtains = false;
		boolean deptidcontains = false;
		String whereCase = " where 1 = 1 ";
		if(param != null){
			bcontains = param.containsKey("beginDate");
			econtains = param.containsKey("endDate");
			deptidcontains = param.containsKey("deptid");
		}
		if(bcontains && !param.get("beginDate").toString().equals("") ){
			Date beginDate = (Date)param.get("beginDate");
			String date =new SimpleDateFormat("YYYY-MM-dd").format(beginDate);
			whereCase += " And DATE_FORMAT(Date,'%Y-%m-%d') >= DATE_FORMAT('"
					+ date + "' ,'%Y-%m-%d')";
		}
		if(econtains && !param.get("endDate").toString().equals("") ){
			Date endDate = (Date)param.get("endDate");
			String date =new SimpleDateFormat("YYYY-MM-dd").format(endDate);
			whereCase += " And DATE_FORMAT(Date,'%Y-%m-%d') <= DATE_FORMAT('"
					+ date + "' ,'%Y-%m-%d')";
		}
		if(deptidcontains && !param.get("deptid").toString().equals("")){
			whereCase += " And deptid = " + param.get("deptid");
		}
		String sql = " from " + Operated.class.getName() + whereCase + " order by date desc ";
		this.pagingQuery(page, sql , "select count(*) "+sql);
		
	}
	
	@DataResolver
	public void saveOperated(Collection<Operated> operateds) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(Operated operated : operateds){
				EntityState state = EntityUtils.getState(operated);
				if(state.equals(EntityState.NEW)){
					session.save(operated);
				}
				if(state.equals(EntityState.MODIFIED)){
					session.update(operated);
				}
				if(state.equals(EntityState.DELETED)){
					session.delete(operated);
				}
			}
		
		} finally{
			session.flush();
			session.close();
		}
	}
}
