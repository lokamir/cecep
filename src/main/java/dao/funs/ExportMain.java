package dao.funs;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.Expose;
import com.bstek.ureport.Utils;
import com.bstek.ureport.export.ExportManager;
import com.bstek.ureport.export.html.HtmlReport;
@Component
public class ExportMain {
	@Expose
	public void exportHtml (Map<String, Object> parameters,HttpServletRequest request)throws Exception{
	ExportManager  exportManager=(ExportManager)Utils.getApplicationContext().getBean(ExportManager.BEAN_ID);
	HtmlReport htmlReport = exportManager.exportHtml("file:Daily.ureport.xml",request.getContextPath(),parameters);
	System.out.println("<style type=\"text/css\">");
	System.out.println(htmlReport.getStyle());
	System.out.println("</style>");
	System.out.println(htmlReport.getContent());
	}
}
