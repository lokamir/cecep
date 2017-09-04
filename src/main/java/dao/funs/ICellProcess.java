package dao.funs;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.bstek.bdf2.importexcel.interceptor.impl.RequiredInterceptor;

@Component
public class ICellProcess extends RequiredInterceptor {
	@Resource El el;
	public Object execute(Object cellValue) throws Exception {
        super.execute(cellValue);
        Map<String, Integer> fk = el.mapProcess();
        if (fk.containsKey(cellValue)) {
            return fk.get(cellValue);
        } else {
            return "0";
        }
    }
    public String getName() {
        return "工艺段";
    }
}
