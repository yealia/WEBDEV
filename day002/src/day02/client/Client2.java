package day02.client;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.Cleanup;

//파일 전송 클라이언트2 
public class Client2 {

	
	//bad code
	public static void main(String[] args) throws Exception{
		
		
		Scanner keyScanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("input tour msg");
			String fileName = keyScanner.nextLine();               
			
			@Cleanup Socket socket = new Socket("192.168.200.108",5555);
			@Cleanup DataOutputStream dos =
					new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);
			@Cleanup InputStream in = socket.getInputStream();
			@Cleanup FileOutputStream fos = new FileOutputStream("C:\\zzz2\\" + fileName);
			byte[] buffer = new byte[1024*8];
			
			while(true) {
				//파일의 바이트 크기를 count로 넣어
				int count = in.read(buffer);
				//-1 이면 없다. break해당 키워드의 파일이 없음
				
				
				
				
				
				
				if(count == -1) {break;}
				
				//클라이언트로 byte type 데이터로 전송
				fos.write(buffer,0,count);
			}
			
		}//end while
	}

}
