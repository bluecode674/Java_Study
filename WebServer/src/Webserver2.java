import java.io.*;
import java.net.*;

public class Webserver2 {
	public static void main(String[] args) {
		try {
			ServerSocket srvsock = new ServerSocket(80);
			System.out.println("Server started ... \n");
			while(true) {
				Socket sock = srvsock.accept();
				ServerThread2 thread = new ServerThread2(sock);
				thread.start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class ServerThread2 extends Thread {
	Socket sock;
	public ServerThread2(Socket sock) { this.sock = sock; }
	public void run() {
		try {
			InputStream is = sock.getInputStream();
			ByteArrayOutputStream bao = new ByteArrayOutputStream(); // PPT. 08 파일 입출력, 15페이지 참고
			byte[] buf = new byte[1024];
			int cnt;
			while((cnt = is.read(buf)) != -1) {
				bao.write(buf);
				if (cnt < buf.length) break;
			};
			System.out.println(bao.toString());
			String msg = "<html>Hello, world!</html>";
			PrintWriter pw = new PrintWriter(sock.getOutputStream()); // OutputStream을 통해 HTML 코드 출력
			pw.println(msg);
			pw.flush();
		} catch (IOException ex) { ex.printStackTrace(); }
	}
}