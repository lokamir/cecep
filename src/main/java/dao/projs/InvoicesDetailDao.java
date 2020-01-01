package dao.projs;

import java.util.Collection;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;

import entity.InvoicesDetail;

@Component
public class InvoicesDetailDao extends HibernateDao{
	@DataProvider
	public Collection<InvoicesDetail> loadinvoicesDetail() throws Exception {
			String hql="from " + InvoicesDetail.class.getName()+" where del = 0 ";
			return this.query(hql);
	}
	
	@DataResolver
	public void InvoicesDetail(Collection<InvoicesDetail> invoicesDetails) throws Exception {
		Session session = this.getSessionFactory().openSession();
		try{
			for(InvoicesDetail invoicesDetail : invoicesDetails){
				EntityState state = EntityUtils.getState(invoicesDetail);
				if(state.equals(EntityState.NEW)){
					session.save(invoicesDetail);
				}
				if(state.equals(EntityState.MODIFIED)){
					session.update(invoicesDetail);
				}
				if(state.equals(EntityState.DELETED)){
					invoicesDetail.setDel(1);
					session.update(invoicesDetail);
				}
			}
		
		} finally{
			session.flush();
			session.close();
		}
	}
}