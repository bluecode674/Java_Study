package jsp;

import http.JspService;
import http.Session;

public class SetUser extends JspService {

	@Override
	public String getHtml(Session ses,String host, String[] params) {
		ses.set(host, params);
		return "<html><meta charset='utf-8'>세션 정보가 추가되었습니다.</html>";
	}

}
