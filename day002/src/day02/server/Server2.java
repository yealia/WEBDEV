package day02.server;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.Cleanup;

//파일 전송 서버2 
public class Server2 {

	public static void main(String[] args) throws Exception{
		//1.소켓서버 객체 만들어서 포트 번호 준다.
		ServerSocket server = new ServerSocket(5555);
		
		
		while(true) {
			//try {
				//@Cleanup : 현재 범위를 종료되기전에 지정된 리소스가 자동적으로 정리되겠금
			//2.server.accept(서버가 연결이 되면) 소켓의 client라는 객체를 생성함 
				@Cleanup Socket client = server.accept();
				
				//3.client.getInputStream()의 정보를 가지고 있는 객체를 din에 담는다
				@Cleanup DataInputStream din = 
						new DataInputStream(client.getInputStream());
				
				//4.보내는거는 객체 out에 선언
				@Cleanup OutputStream out = client.getOutputStream();
				
				//din을 utf로 읽고 공백을 제거한다
				//readUTF 문자열 받는게 아니라 파일이름 깨지지않게 하기 위해서
				String fileName = din.readUTF().trim();
				//trim() => 공백제거
				
				System.out.println(fileName);
				
				//빨대로 빨 위치 경로를 적고 fin객체 선언
				//FileInputStream 파일 읽어오는 거 
				@Cleanup
				FileInputStream fin = new FileInputStream("C\\zzz\\"+fileName);
				
				//바이트 크기를 주고 바이트 배열 형태로 버퍼로 선언
				byte[] buffer = new byte[1024*8];
				
				
				while(true) {
					//파일의 바이트 크기를 count로 넣어
					int count = fin.read(buffer);
					//
					if(count == -1) {break;}
					out.write(buffer,0,count);
			
				}
			
			}
//			catch(FileNotFoundException e) {
//				e.printStackTrace();
//			}
			
		}//end while
	}

//}
