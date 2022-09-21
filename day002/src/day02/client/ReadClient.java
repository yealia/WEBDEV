package day02.client;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadClient {

//클라이언트 받는 서버
	//bad code
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(8080);
		
		System.out.println("listen.......");
		while(true) {
			Socket socket =server.accept();
			System.out.println(socket);//브라우저에 치면 나온다

			InputStream in = socket.getInputStream();
			byte[] buffer = new byte[100];
			int count = in.read(buffer);
			System.out.println("Count" + count);
			
			String clientMsg = new String(buffer,0,count);
			
			System.out.println(clientMsg);
		}//end while
	}

}
