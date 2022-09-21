package dya003.ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.Cleanup;

public class FileServer {
	
	private static void sendFile(String fileName, DataOutputStream dos)
			throws FileNotFoundException,IOException {
		FileInputStream fin = new FileInputStream("C:\\zzz\\"+fileName);
		byte[] buffer = new byte[1024*8];
		
		dos.writeUTF("200");
		
		while(true) {
			int count = fin.read(buffer);
			if(count==-1) {break;}
			dos.write(buffer,0,count);
		}
		
		//success
		fin.close();
				
	}
	
	public static void main(String[] args)throws Exception {
		
		//1.ServerSocket ready
		@Cleanup ServerSocket server = new ServerSocket(5555);
		
		while(true) {
			
			
			
			//@Cleanup
			Socket socket = server.accept();
			
			new Thread(() -> {
				try {
					//@Cleanup
					DataInputStream din = new DataInputStream(socket.getInputStream());
					//@Cleanup
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					
					String firstLine = din.readUTF(); 
					System.out.println(firstLine); //firstLine 파일 이름이 나옴
					
					try {
						sendFile(firstLine, dos);
					}catch(FileNotFoundException fn) {
						dos.writeUTF("404");
					}
					
					dos.close();
				}catch(Exception e) {
					
				}//end exception 
					
			}).start();
			
			
			
			
			
			
		}//end while
	}
}
