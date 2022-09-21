package day02.client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//소켓 통신 클라이언트
public class Client1 {

	//bad code
	public static void main(String[] args) throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("msg");
			String msg = scanner.nextLine();
			
			//소켓 객체에 보낼 주소 랑 포트 번호 적어
			Socket socket = new Socket("192.168.0.109",5555);
			System.out.println(socket);
			//OutputStream 값을 보내야하니깐 
			OutputStream out = socket.getOutputStream();
			
			//getBytes : 문자열을 바이트로 인코딩 하는 거 
			byte[] arr = msg.getBytes();
			//in-read out-write
			out.write(arr);
		}
		
		
		
		
	}

}
