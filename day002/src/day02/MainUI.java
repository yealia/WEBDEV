package day02;

import java.io.FileInputStream;
import java.util.Properties;

//AbstractUI를 상속받는다
public class MainUI extends AbstractUI{

	@Override
	public void oper() {
		//상태
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("C:\\zzz\\ui.properties")); //FileInputStream를 통해 경로에 상태를 업로드ㅡ
			System.out.println(prop);
			
			String className = prop.getProperty(input("1번 키워드 2번 위치"));//
			
			System.out.println(className);
			
			Class clz = Class.forName(className);
			
			AbstractUI ui = (AbstractUI)clz.getConstructor(null).newInstance(null);
			
			System.out.println(ui);
			
			ui.oper();
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
