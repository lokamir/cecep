package test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;

import dao.projs.AnalysisElseDao;
import dao.projs.AnalysisExtDao;
import dao.projs.AnalysisIntrDao;
import dao.projs.ProcessDao;
import entity.Operated;



@Component
public class OperatedDao extends HibernateDao {
	
	@Resource
    private AnalysisIntrDao analysisIntr;
	@Resource
	private AnalysisExtDao analysisExt;
	@Resource
	private AnalysisElseDao analysisElse;
	@Resource
	private ProcessDao process;
	
	
	
	@DataProvider
	public void loadOperatedForPage(Page<Operated> page,Map<String, Object> params) throws Exception {
		/*String whereCase = "";
		boolean bcontains = false;
		boolean econtains = false;
		if (null != params) {
			bcontains = params.containsKey("beginDate");
			econtains = params.containsKey("endDate");
		}
		if (bcontains) {
			Date beginDate = (Date) params.get("beginDate");
			if (beginDate != null) {
				String date =new SimpleDateFormat("YYYY-MM-dd").format(beginDate);
				whereCase += " And DATE_FORMAT(operatedDate,'%Y-%m-%d') >= DATE_FORMAT('"
						+ date + "' ,'%Y-%m-%d')";
			}	
		}
		if (econtains) {
			Date endDate = (Date) params.get("endDate");
			if (endDate != null) {
				String date =new SimpleDateFormat("YYYY-MM-dd").format(endDate);
				whereCase += " And DATE_FORMAT(operatedDate,'%Y-%m-%d') <= DATE_FORMAT('"
						+ date + "' ,'%Y-%m-%d')";
			}
		}
		String hql = "from " + Operated.class.getName()+" where 1=1 "+whereCase+ " order by operatedId desc";
		this.pagingQuery(page, hql, "select count(*) "+hql);*/
		
		
		//以下为虚拟属性，可以整段注销，取消该属性
		/*List<Operated> results = new ArrayList<Operated>();
		Collection<Operated> operateds = page.getEntities();
		Collection<Process> processAll = process.loadProcess();
		for(Operated  operated : operateds){
			Map<Integer,AnalysisIntr> analysisMap = new HashMap<Integer, AnalysisIntr>();
			for(Process process: processAll){
				List<AnalysisIntr> analysisValue = analysisIn.query("from " + AnalysisIntr.class.getName()+" where operatedId="+operated. + "and processId = "+process.getProcessid());
				for (AnalysisIntr analysis : analysisValue){
				analysisMap.put(process.getProcessid(), analysis);
				}
			}
			Operated targetOperated = EntityUtils.toEntity(operated);
			for(Integer key : analysisMap.keySet()){
			EntityUtils.setValue(
					targetOperated,
					key.toString(),
					analysisMap.get(key));
			}
			results.add(targetOperated);
		}
		page.setEntities(results);*/ //虚拟属性结束


	}
	@DataResolver
	public void saveOperateds(Collection<Operated> operateds) throws Exception {
		Session session = this.getSessionFactory().openSession();
		/*try{
			for(Operated operated : operateds){
				EntityState state = EntityUtils.getState(operated);
				if(state.equals(EntityState.NEW)){
					session.save(operated);
				}
				if(state.equals(EntityState.MODIFIED)){
					Date now = new Date();
					//operated.setTimestamp(now);
					session.update(operated);
				}
				if(state.equals(EntityState.DELETED)){
					session.update(operated);
				}
				Collection<AnalysisIn> analysisIns = operated.getAnalysisInSet();
				if (analysisIns != null){
					for (AnalysisIn analysisIn:analysisIns){
						analysisIn.setOperated(operated);   
					}
					analysisIn.saveAnalysisIns(analysisIns);
				}
				Collection<AnalysisOut> analysisOuts = operated.getAnalysisOutSet();
				if (analysisOuts != null){
					for (AnalysisOut analysisOut:analysisOuts){
						analysisOut.setOperated(operated);   
					}
					analysisOut.saveAnalysisOuts(analysisOuts);
				}
				Collection<AnalysisElse> analysisElses = operated.getAnalysisElseSet();
				if (analysisElses != null){
					for (AnalysisElse analysisElse:analysisElses){
						analysisElse.setOperated(operated);   
					}
					analysisElse.saveAnalysisElses(analysisElses);
				}
			}
		} finally{
			session.flush();
			session.close();
		}
		}*/
}
	}
