package day02.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	
	public static void main(String[] args)throws Exception{
		//서버소켓 객체 생성해서 소켓의 포트 번호:5555
		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready..."); //여기서 멈춘다

		for(int i=0; i<10; i++){
			//accept :서버가 연결될 때 까지 무한대기 서버에 접속이 되면 서버의 소켓 객체를 생성
			Socket socket =server.accept();
			System.out.println(socket);//클라이언트의 소켓 주소를 출력함

			//데이터 빨아들일려면 InputStream 
			//소켓의 InputStream을 받은것을 in에 넣는다
			InputStream in = socket.getInputStream();
			//받을때 값을 byte길이 100짜리로 받는데 그것을 byte타입의 배열의 buffer로 받는다
			byte[] buffer = new byte[100];
			int count = in.read(buffer);//buffer의 읽어진 값을 카운트에 넣는다
			System.out.println(count); //갯수가 출력된다
			
			//0~갯수만큼이니깐, 갯수만큼은 내가 입력한 길이니깐 
			//0,count가 없으면 공백이 주르륵 나온다
			String clientMsg = new String(buffer,0,count);
			
			System.out.println(clientMsg);
		
		}

	}
}
