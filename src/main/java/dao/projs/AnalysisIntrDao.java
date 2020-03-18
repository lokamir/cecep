package dao.projs;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;

import entity.AnalysisIntr;
import entity.Process;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;

@Component
public class AnalysisIntrDao extends HibernateDao {
	@DataProvider
	public Collection<AnalysisIntr> loadAnalysisIn(Integer id) throws Exception {
		if(id != null){
			String hql="from " + AnalysisIntr.class.getName();
			return this.query(hql);
		}else {	
			return null;
		}
	}
	
@DataProvider
public void queryPage(Page<AnalysisIntr> page,Map<String, Object> param) throws Exception{
	    boolean bcontains = false;
		boolean econtains = false;
		boolean deptidcontains = false;
		boolean processcontains = false;
		String whereCase = " where 1=1 ";
		if (null != param) {
			bcontains = param.containsKey("beginDate");
			econtains = param.containsKey("endDate");
			deptidcontains = param.containsKey("deptid");
			processcontains = param.containsKey("process");
		}
		if (bcontains && !param.get("beginDate").toString().equals("")) {
			//System.out.println("beginDate");
			Date beginDate = (Date) param.get("beginDate");
			if (beginDate != null) {
				String date =new SimpleDateFormat("yyyy-MM-dd").format(beginDate);
				whereCase += " And DATE_FORMAT(Date,'%Y-%m-%d') >= DATE_FORMAT('"
						+ date + "' ,'%Y-%m-%d')";
			}	
		}
		if (econtains && !param.get("endDate").toString().equals("")) {
			//System.out.println("endDate");
			Date endDate = (Date) param.get("endDate");
			if (endDate != null) {
				String date =new SimpleDateFormat("yyyy-MM-dd").format(endDate);
				whereCase += " And DATE_FORMAT(Date,'%Y-%m-%d') <= DATE_FORMAT('"
						+ date + "' ,'%Y-%m-%d')";
			}
		}
		if (deptidcontains && !param.get("deptid").toString().equals("")){
			//System.out.println("deptid");
			whereCase += " And deptid = " + param.get("deptid");
		}
		if (processcontains && !param.get("process").toString().equals("")){
			//System.out.println("process");
			Process process = (Process)param.get("process");
			whereCase += " And processid = " + process.getProcessid();
		}
	    
		String sql="from "+AnalysisIntr.class.getName()+ whereCase + " order by date desc , processId asc" ;
	    this.pagingQuery(page, sql,"select count(*) " + sql);
	}
	
	
	@DataResolver
	public void saveAnalysisIns(Collection<AnalysisIntr> analysisIntrs) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(AnalysisIntr analysisIntr : analysisIntrs){
				EntityState state = EntityUtils.getState(analysisIntr);
				if(state.equals(EntityState.NEW)){
					session.save(analysisIntr);
				}
				if(state.equals(EntityState.MODIFIED)){
					//Date now = new Date();
					//analysisIn.setTimestamp(now);
					session.update(analysisIntr);
				}
				if(state.equals(EntityState.DELETED)){
					session.delete(analysisIntr);
				}
			}
		} finally{
			session.flush();
			session.close();
		}
		}
}
