package zserver.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import zserver.server.let.HelloPorolet;
import zserver.server.let.PoroRes;
import zserver.server.let.Porolet;

public class MainServer {
	
	private Map<String, Porolet> letMap;
	
	public MainServer() {
		letMap = new HashMap<>();
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("C:\\zzz\\ui.properties.txt"));
			
			prop.keySet().stream().forEach(key -> {
				String value = prop.getProperty((String)key);
				System.out.println(value);
				
				try {
					Class clz = Class.forName(value);
					Porolet obj = (Porolet)clz.getConstructor(null).newInstance(null);
					obj.init();
					letMap.put((String)key, obj);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void runServer() {
		
		
		try {
			ServerSocket server = new ServerSocket(80);
			//5555도 될거같은데에ㅔ?
			System.out.println("server running.................");
			
			//Porolet let = null;
			//let.init();
			
			while(true) {
				
				Socket socket = server.accept();
				
				new Thread(() -> {
					try {
						InputStream in = socket.getInputStream();
						Scanner inScanner = new Scanner(in);
						OutputStream out = socket.getOutputStream();
						
						String firstLine = inScanner.nextLine();
						
						String target = firstLine.split(" ")[1];
						
					
						PoroRes res = new PoroRes(out);
						
						//let.init();
						try {
							
							Porolet let = letMap.get(target);
							
							let.service(in, res);
						} catch (Exception e) {
							out.write(new String("HTTP/1.1 500 Internel Server Error\r\n").getBytes());
						}
						in.close();
						out.close();
					}catch(Exception e) {
						
					}
				}).start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


