package dao.funs;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import com.bstek.bdf2.importexcel.interceptor.impl.RequiredInterceptor;

@Component
public class ICellBiscompany extends RequiredInterceptor {
	@Resource El el;
	    public Object execute(Object cellValue) throws Exception {
	        Map<Integer,String> fk = el.mapBiscompany();
	        Map<String,Integer> nfk = new HashMap<String, Integer>();
	        for (Integer key : fk.keySet()) {
	            nfk.put(fk.get(key), key);
	        }
	        if (nfk.containsKey(cellValue)) {
	            return nfk.get(cellValue);
	        } else {
	            return "0";
	        }
	    }
	    public String getName() {
	        return "接管企业";
	    }
	    
	}

