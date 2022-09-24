package day004.ex1;

public class Ex2 {
	
	public static void main(String[] args) {
		
		StringBuffer str = new StringBuffer();
		
		new Thread(()-> {
			for (int i = 0; i < 100; i++) {
				System.out.println("A :" + i);
				str.append(""+i);
			}
			System.out.println(str);
			
		}).start();
		
		
		for (int i = 0; i < 100; i++) {
			System.out.println("B :" + i);
		}
	}
}
