package http;

abstract public class JspService {
	abstract public String getHtml(Session sess, String host, String[] params);
	
	public String getParamValue(String[] params, String name) {
		for (String param : params) {
			String[] toks = param.split("=");
			if (toks.length == 2 && toks[0].equals(name)) return toks[1];
		}
		return null;
	}
}
