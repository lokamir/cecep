package dao.projs;

import java.util.Collection;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;

import entity.Biscompany;

@Component
public class BiscompanyDao extends HibernateDao{
	@DataProvider
	public Collection<Biscompany> loadbiscompany() throws Exception {
			String hql="from " + Biscompany.class.getName();
			return this.query(hql);
	}
	
	@DataResolver
	public void Biscompany(Collection<Biscompany> biscompanys) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(Biscompany biscompany : biscompanys){
				EntityState state = EntityUtils.getState(biscompany);
				if(state.equals(EntityState.NEW)){
					session.save(biscompany);
				}
				if(state.equals(EntityState.MODIFIED)){
					session.update(biscompany);
				}
				if(state.equals(EntityState.DELETED)){
					session.update(biscompany);
				}
			}
		
		} finally{
			session.flush();
			session.close();
		}
	}
}