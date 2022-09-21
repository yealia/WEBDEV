package dya003.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy2 {

	
	public static void main(String[] args) {
	
		try(
				InputStream fin =  new FileInputStream("C:\\zzz\\test.jpg");
				OutputStream fos = new FileOutputStream("C:\\zzz\\copy.jpg");
			 ){
			long start = System.currentTimeMillis();
			
			byte[] buffer = new byte[1024*8];
			
			while(true) {
				int count = fin.read(buffer);
				if(count == -1) {break;}
				fos.write(buffer);
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println("TIME:" + (end - start));
			
		}catch(Exception e){
		
		}
	}
}
