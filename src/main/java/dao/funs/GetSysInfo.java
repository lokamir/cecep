package dao.funs;

import java.util.Collection;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import entity.AnalysisIntr;
import entity.Bdf2User;
import entity.Process;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;


@Component
public class GetSysInfo extends HibernateDao {
	
	public int getUserID(String UserName,Session ses) throws Exception{  //”√ªßID
		int uid; String str_uid;
		String sql="select id from bdf2_user where username_='"+UserName+"'";
		SQLQuery query=ses.createSQLQuery(sql);		
		str_uid = query.uniqueResult().toString();
		uid=Integer.parseInt(str_uid);
		return uid;
	}

	public Collection<Bdf2User> getCnameById(int keyin_id) { //–Èƒ‚ Ù–‘
		List<Bdf2User> bdf2Users = this.query("from Bdf2User where id =" + keyin_id);
		return bdf2Users;
	}
	
	
	public Collection<AnalysisIntr> getAnalysisIn(Integer id,Integer processId) throws Exception {
		if(id != null){
			String hql="from " + AnalysisIntr.class.getName()+" where operatedId="+id + "and processId = " + processId;
			List<AnalysisIntr> data = this.query(hql);
			return data;
		}else {	
			return null;
		}
	}
	
	public Collection<AnalysisIntr> getProcessId(Integer deptid) throws Exception {
		if(deptid != null){
			String hql="from " + Process.class.getName()+" where deptId="+deptid;
			List<AnalysisIntr> data = this.query(hql);
			return data;
		}else {	
			return null;
		}
	}
}