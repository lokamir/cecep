package dao.funs;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.bstek.bdf2.importexcel.interceptor.impl.RequiredInterceptor;

@Component
public class CellDeptId extends RequiredInterceptor {
	@Resource El el;
	    public Object execute(Object cellValue) throws Exception {
	        Map<String,String> fk = el.mapBdf2Depts();
	        Map<String,String> nfk = new HashMap<String, String>();
	        for (String key : fk.keySet()) {
	            nfk.put(fk.get(key), key);
	        }
	        if (nfk.containsKey(cellValue)) {
	            return nfk.get(cellValue);
	        } else {
	            return "0";
	        }
	    }
	    public String getName() {
	        return "水厂名称";
	    }
	}

