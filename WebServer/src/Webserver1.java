import java.io.*;
import java.net.*;

public class Webserver1 {
	public static void main(String[] args) {
		try {
			ServerSocket srvsock = new ServerSocket(80);
			System.out.println("Server started ... \n");
			while(true) {
				Socket sock = srvsock.accept();
				ServerThread1 thread = new ServerThread1(sock);
				thread.start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class ServerThread1 extends Thread {
	Socket sock;
	public ServerThread1(Socket sock) { this.sock = sock; }
	public void run() {
		try {
			InputStream is = sock.getInputStream();
			ByteArrayOutputStream bao = new ByteArrayOutputStream(); // 08.파일 입출력 PPT 15페이지 참고
			byte[] buf = new byte[1024];
			int cnt;
			while((cnt = is.read(buf)) != -1) {
				bao.write(buf);
				if (cnt < buf.length) break;
			};
			System.out.println(bao.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}