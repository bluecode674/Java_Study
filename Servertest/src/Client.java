import java.io.*; 
import java.net.*; 
import java.util.*;

public class Client {
    public static void main(String[] args) { 
        try {
            Socket sock = new Socket("localhost", 9999); 
            System.out.println("Client started ... \n");
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream())); PrintWriter out = new PrintWriter(sock.getOutputStream());
            Scanner scan = new Scanner(System.in);	// 사용자로부터 메시지를 입력받도록 Scanner 클래스 이용
            while (true) { System.out.print(">> ");
                String mymsg = scan.next(); 
                out.println(mymsg); 
                out.flush();
                String msg = in.readLine(); System.out.println(msg);
                if (mymsg.equals("bye")) break;
            }
            scan.close();
            sock.close();
            System.out.println("\nClient stopped ...");}
        catch (IOException ex) {ex.printStackTrace();}
    }
}
