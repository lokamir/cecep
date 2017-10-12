package dao.funs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bstek.bdf2.core.controller.IController;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;

import entity.Operated;

public class OperateDataAPI extends HibernateDao implements IController {

	public String getUrl() {
		String url = "/operate.getData";
		return url;
	}

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String queryString = request.getQueryString();
		System.out.print(queryString);
		String username = request.getParameter("username");
		String deptId = request.getParameter("deptId");
		String date = request.getParameter("date");
		
		String hql = "from " + Operated.class.getName()+" where 1=1 and deptId = " +deptId +" and date = "+date;
		this.query(hql);

	}

	public boolean anonymousAccess() {
		// 是否允许用户在未登录的情况下访问，为true表示允许未登录访问
		return true;
	}

	public boolean isDisabled() {
		// 是否禁用这个Controller，为false表示可以正常访问
		return false;
	}

}
