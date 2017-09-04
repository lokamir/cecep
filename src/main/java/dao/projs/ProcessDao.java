package dao.projs;

import java.util.Collection;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import entity.Process;
@Component
public class ProcessDao extends HibernateDao{
	@DataProvider
	public Collection<Process> loadProcess() throws Exception {
			String hql="from " + Process.class.getName();
			return this.query(hql);
	}
	
	@DataResolver
	public void saveProcess(Collection<Process> processz) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(Process process : processz){
				EntityState state = EntityUtils.getState(process);
				if(state.equals(EntityState.NEW)){
					session.save(process);
				}
				if(state.equals(EntityState.MODIFIED)){
					session.update(process);
				}
				if(state.equals(EntityState.DELETED)){
					session.update(process);
				}
			}
		
		} finally{
			session.flush();
			session.close();
		}
	}
}