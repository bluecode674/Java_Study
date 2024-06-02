import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import http.JspService;
import http.Session;

class ServerThread extends Thread {
	Socket sock ;
	
	public ServerThread(Socket sock) {
		this.sock = sock;
	}
	
	public void run() {
		try {
			HttpRequest req = new HttpRequest();
			
			String msg = req.receive(sock.getInputStream());
			String url = req.getUrl(msg);
			System.out.println(url);
			
			if (url != null) {
				String host = req.getHost(msg); // msg의 2행으로부터 "localhost" 추출 (세션 저장에 필요)
				String file = req.getFile(url); // url로부터 "/setUser.jsp" 추출
				String[] params = req.getParams(url); // url로부터 {"id=kim", "tel=1111"} 배열 추출
				
				if (params != null) {
					System.out.println("host:" + host + ",file:" + file +",params[0]:" + params[0]);
				}
				Session ses = Session.getInstance();
				ses.set("localhost", url);
			
				HttpResponse res = new HttpResponse();
				res.send(sock.getOutputStream(), host, file, params);
			}
			sock.close();
			 
		} catch (IOException ex) { ex.printStackTrace(); }
	}
}

class HttpRequest {
	public String receive(InputStream is) throws IOException {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int cnt;
		while((cnt = is.read(buf)) != -1) {
		bao.write(buf);
		if (cnt < buf.length) break;
		}
		return bao.toString();
	}
	
	public String getUrl(String msg) {
		String[] lines = msg.trim().split("\n");
		if (lines.length == 0) return null;
		System.out.println("first: " + lines[0]); // first: GET /index.html HTTP/1.1
		String[] toks = lines[0].trim().split(" ");
		if (toks.length < 2) return null;
		if (!toks[0].equals("GET") && !toks[0].equals("POST")) return null;
		return toks[1];
	}
	
	public String getHost(String msg) {
		String[] lines = msg.trim().split("\n");
		if (lines.length <= 0) return null;
		
		System.out.println("second: " + lines[1]); // first: GET /index.html HTTP/1.1
		String[] toks = lines[1].trim().split(" ");
		if (toks.length <= 1) return null;
		if (!toks[0].equals("Host") && !toks[0].equals("host")) return null;
		return toks[1].trim();
	}
	
	public String getFile(String url) {
		int idx = url.indexOf("?");
		if (idx < 0) return url;
		return url.substring(0, idx);
	}
	
	public String[] getParams(String url) {
		int idx = url.indexOf("?");
		return (idx < 0) ? null : url.substring(idx+1).split("&");
	}
}

class HttpResponse {
	public void send(OutputStream os, String host, String file, String[] params) throws IOException {
		if (isJsp(file)) {
			JspHandler hnd = new JspHandler();
			hnd.send(os, host, file, params);
		}
		else {
			file = "web" + file; // HTML 파일이 저장되는 루트 디렉토리로 web을 지정
			System.out.println("send file: " + file);
			String msg = "";
			if ((new File(file)).exists() == false) {
				msg = getMsgNotFound();
				sendText(os, msg);
			}
			else {
				if (isImage(file)) {
					byte[] bytes = getMsgImage(file);
					sendBytes(os, bytes);
				}
				else {
					msg = getMsgText(file);
					sendText(os, msg);
				}
			}
		}
	}
		private boolean isImage(String file) {
			int idx = file.lastIndexOf(".");
			String ext = (idx > 0) ? file.substring(idx+1) : "";
			return (ext.equals("jpg") || ext.equals("jpeg")) ? true : false;
		}
		
		private boolean isJsp(String file) {
			int idx = file.lastIndexOf(".");
			String ext = (idx > 0) ? file.substring(idx+1) : "";
			return (ext.equals("jsp")) ? true : false;
		}
		
		private String getMsgNotFound() {
			String msg = "HTTP/1.1 404\n";
			msg += "Content-Type: text/html;charset=utf-8\n";
			msg += "Content-Language: ko\n";
			msg += "\n";
			msg += "<html><meta charset='utf-8'>요청하신 파일이 존재하지 않습니다.</html>\n";
			return msg;
			}
		private String getMsgText(String path) throws IOException {
			byte[] bytes = Files.readAllBytes(Paths.get(path));
			String msg = "HTTP/1.1 200\n";
			msg += "Content-Type: text/html;charset=utf-8\n";
			msg += "Content-Language: ko\n";
			msg += "Content-Length: " + bytes.length + "\n";
			msg += "\n";
			msg += new String(bytes, "utf-8");
			return msg;
			
		}
		private byte[] getMsgImage(String path) throws IOException {
			byte[] bytes = Files.readAllBytes(Paths.get(path));
			String msg = "HTTP/1.1 200\n";
			msg += "Content-Type: image/jpeg\n";
			msg += "Content-Length: " + bytes.length + "\n";
			msg += "\n";
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			bao.write(msg.getBytes());
			bao.write(bytes);
			return bao.toByteArray();
			}

		private void sendText(OutputStream os, String msg) throws UnsupportedEncodingException {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"));
			pw.println(msg);
			pw.flush();
		}
		
		private void sendBytes(OutputStream os, byte[] bytes) throws IOException {
			os.write(bytes);
			os.flush();
		}
}

class JspHandler {
	public void send(OutputStream os, String host, String file, String[] params) throws IOException {
		file = "jsp" + getClassName(file); // file: "/SetUser.jsp"  ".SetUser"
		try {
			Class c = Class.forName(file);
			JspService svc = (JspService) c.newInstance();
			sendText(os, getMsg(200, svc.getHtml(Session.getInstance(),host, params)));
		} catch(Exception ex) {
			ex.printStackTrace();
			sendText(os, getMsg(500, getHtml("서버 오류가 발생하였습니다.")));
		}
	}
	
	private void sendText(OutputStream os, String msg) throws UnsupportedEncodingException {
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, "utf-8"));
		pw.println(msg);
		pw.flush();
	}
	
	private String getMsg(int code, String html) {
		String msg = "HTTP/1.1" + code + "\n";
		msg += "Content-Type: text/html;charset=utf-8\n";
		msg += "Content-Language: ko\n";
		msg += "\n";
		msg += html;
		return msg;
		
	}
	
	private String getHtml(String desc) {
		return "<html><meta charset='utf-8'>" + desc + "</html>\n";
		
	}
	
	private String getClassName(String file) {
		int idx = file.lastIndexOf(".jsp");
		return (idx < 0) ? "" : file.substring(0, idx).replaceAll("/", ".");
	}
}
	
public class WebServer {
	public static void main(String[] args) {
		try {
			ServerSocket srvsock = new ServerSocket(80);
			
			System.out.println("Server started ... \n");
			while (true) {
				Socket sock = srvsock.accept();
				ServerThread thread = new ServerThread(sock);
				thread.start();
				
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
}