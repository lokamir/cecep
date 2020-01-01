package dao.projs;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;

import entity.InvoicesTransport;

@Component
public class InvoicesTransportDao extends HibernateDao{
	@DataProvider
	public Collection<InvoicesTransport> loadinvoicesTransport(int pid) throws Exception {
			String hql="from " + InvoicesTransport.class.getName()+ " where pid = " + pid;
			return this.query(hql);
	}
	
	@DataResolver
	public void InvoicesTransport(Collection<InvoicesTransport> invoicesTransports) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(InvoicesTransport invoicesTransport : invoicesTransports){
				EntityState state = EntityUtils.getState(invoicesTransport);
				if(state.equals(EntityState.NEW)){
					session.save(invoicesTransport);
				}
				if(state.equals(EntityState.MODIFIED)){
					Date now = new Date();
					invoicesTransport.setEndTime(now);
					session.update(invoicesTransport);
				}
				if(state.equals(EntityState.DELETED)){
					session.update(invoicesTransport);
				}
			}
		
		} finally{
			session.flush();
			session.close();
		}
	}
}