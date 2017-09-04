package test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.Expose;
import com.bstek.ureport.Utils;
import com.bstek.ureport.export.ExportManager;
import com.bstek.ureport.export.html.HtmlReport;

@Component
public class ajax {
	@Expose
	
	public void exportHtml (Map<String, Object> parameters,HttpServletRequest request)throws Exception{
	/*ExportManager  exportManager=(ExportManager)Utils.getApplicationContext().getBean(ExportManager.BEAN_ID);
    HtmlReport htmlReport = exportManager.exportHtml("file:test.level.ureport.xml",request.getContextPath(),parameters);

    //组内容
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("table", htmlReport.getContent());
    map.put("css", htmlReport.getStyle());

    //内容输出流
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
    mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.writeValue(out, map);

    //内容编码
    String html = out.toString("utf-8");

    //内容输出到response
    ServletOutputStream servletOutputStream = resp.getOutputStream();
    try {
        IOUtils.write(html, servletOutputStream, "utf-8");
    } finally {
        servletOutputStream.flush();
        servletOutputStream.close();
    }*/
	}
}
