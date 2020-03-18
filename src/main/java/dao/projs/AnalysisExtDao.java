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

import entity.AnalysisExt;
import entity.Biscompany;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;

@Component
public class AnalysisExtDao extends HibernateDao {
	
	@DataProvider
	public Collection<AnalysisExt> loadAnalysisOut(Integer id) throws Exception {
		if(id != null){
			String hql="from " + AnalysisExt.class.getName()+" where operatedId="+id;
			return this.query(hql);
		}else {	
			return null;
		}
	}
	
	@DataProvider
	public void queryPage(Page<AnalysisExt> page,Map<String, Object> param) throws Exception{
		    boolean bcontains = false;
			boolean econtains = false;
			boolean deptidcontains = false;
			boolean biscontains = false;
			String whereCase = " where 1=1 ";
			if (null != param) {
				bcontains = param.containsKey("beginDate");
				econtains = param.containsKey("endDate");
				deptidcontains = param.containsKey("deptid");
				biscontains = param.containsKey("biscompany");
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
			if (biscontains && !param.get("biscompany").toString().equals("")){
				//System.out.println("biscompany");
				Biscompany biscompany = (Biscompany)param.get("biscompany");
				whereCase += " And biscompyId = " + biscompany.getId();
			}
		    
			String sql="from "+AnalysisExt.class.getName()+ whereCase + " order by date desc , biscompyId asc";
		    this.pagingQuery(page, sql,"select count(*) " + sql);
		}
		
	
	@DataResolver
	public void saveAnalysisExt(Collection<AnalysisExt> analysisExts) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(AnalysisExt analysisExt : analysisExts){
				EntityState state = EntityUtils.getState(analysisExt);
				if(state.equals(EntityState.NEW)){
					session.save(analysisExt);
				}
				if(state.equals(EntityState.MODIFIED)){
					//Date now = new Date();
					//analysisIn.setTimestamp(now);
					session.update(analysisExt);
				}
				if(state.equals(EntityState.DELETED)){
					session.delete(analysisExt);
				}
			}
		} finally{
			session.flush();
			session.close();
		}
		}
}
