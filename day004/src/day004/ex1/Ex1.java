package day004.ex1;

public class Ex1 implements Runnable{
	
	
	@Override
	public void run() {
		doA();
	}
	
	public void doA() {
		
		for(int i = 0; i < 100; i++) {
			System.out.println(this+"."+Thread.currentThread().getName()+":"+i);
		}
	}
	public static void main(String[] args) {
		
		Ex1 obj1 = new Ex1();
		
		new Thread(obj1).start();
		new Thread(obj1).start();
		new Thread(obj1).start();
	}
}
