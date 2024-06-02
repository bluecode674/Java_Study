package http;

import java.util.HashMap;


public class Session {
	private HashMap<String, Object> table = null;
	private static Session instance = null;
			
	public Session() {
		table = new HashMap<String, Object>();
	}
	
	public static Session getInstance() { // Session.getInstance()로 호출할 경우, 공유 객체 생성
		if (instance == null) {
		instance = new Session();
		}
		return instance;
		}
	public void set(String key, Object val) {
		table.put(key, val);
	}
	public Object get(String key) {
		return table.get(key);
	}
	public Object remove(String key) {
		return table.remove(key);
	}
}
