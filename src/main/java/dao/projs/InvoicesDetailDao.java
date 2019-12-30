package dao.projs;

import java.util.Collection;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;

import entity.InvoicesTransport;

@Component
public class InvoicesDetailDao extends HibernateDao{
	@DataProvider
	public Collection<InvoicesTransport> loadinvoicesTransport() throws Exception {
			String hql="from " + InvoicesTransport.class.getName();
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