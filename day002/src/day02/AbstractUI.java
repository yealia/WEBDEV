package day02;

import java.util.Scanner;

public abstract class AbstractUI {

		private Scanner scanner;
		
		public AbstractUI() {
			scanner = new Scanner(System.in);
		}
		//msg 문자를 받는것을 뽑아내는거 
		public String input(String msg) {
			System.out.println(msg);
			return scanner.nextLine();
		}
		//msg뮨저룰 int형으로 뽑아내는 거
		public int inputInt(String msg) {
			return Integer.parseInt(input(msg));
		}
		//msg문자를 double형으로 뽑아내는거
		public double inputDouble(String msg) {
			return Double.parseDouble(input(msg));
		}
		
		public abstract void oper();
	
	

}
