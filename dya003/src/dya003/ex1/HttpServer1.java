package dya003.ex1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HttpServer1 {
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(5555);
		
		
		while(true) {
			Socket socket = server.accept();
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			Scanner scanner = new Scanner(in);
			
			
			
			String firstLine = scanner.nextLine();
			
			System.out.println(firstLine);
			
			String fileName = firstLine.split(" ")[1];
			System.out.println(fileName);
			System.out.println("==================");
			
			String msg = "<h1>" +fileName+ "</h1>";
			
			out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
			//out.write(new String("Cache-Control: private\r\n").getBytes());
			//out.write(new String("Content-Length:"+msg.getBytes("UTF-8").length+"\r\n").getBytes());
			//마인 타입 : 브라우저한테 말한다 내가 지금 보내는 데이터 타입이 이런거야
			out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes()); //안쓰면 빈화면 뜬다
			//out.write(msg.getBytes(StandardCharsets.UTF_8));
			
			FileInputStream fin = new FileInputStream("C:\\zzz" + fileName);
			
	        byte[] buffer = new byte[1024 * 8];

	         while (true) {
	            int count = fin.read(buffer);
	            if (count == -1) {
	               break;
	            }
	            out.write(buffer, 0, count);
	         }
			 fin.close();
			
			
			
			
			
			
			
			
			out.close();
		}//end while
	}

}
