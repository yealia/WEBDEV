package dya003.ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Test1 {

	public static void main(String[] args)throws Exception{
		
		FileInputStream fin = new FileInputStream("C:\\zzz\\test.txt");
		FileOutputStream fos = new FileOutputStream("C:\\zzz\\copy.txt");
		
		byte[] buffer = new byte[5];
		
		while(true) {
			int count = fin.read(buffer);
			System.out.println(count);
			System.out.println(Arrays.toString(buffer));
			if(count == -1) {break;}
			fos.write(buffer,0,count);
		}
	}

}
