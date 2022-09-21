package day01.ui;

import java.util.List;
import java.util.Scanner;

import day01.dto.Restaurant;
import day01.service.RestaurantService;

public enum RestaurantUI {

	INSTANCE;
	private Scanner scanner;
	private RestaurantService service;
	
	
	private RestaurantUI() {
		this.scanner = new Scanner(System.in);
		this.service = RestaurantService.INSTANCE;
	
	}
	
	
	public void searchByKeyword() {
		System.out.println("input keyword");
		String keyword = this.scanner.nextLine();
		
		System.out.println(keyword);
		
		
		//내가 입력한 음식점의 정보 출력
		//서비스의 리던리스트 중 get으로 하나 뽑을떄 for문을 통해서 뽑으면 좀 더 간단
		//키워드와 서비스의 리턴리스트의 한 데이터 중 이름 의 값이랑 같은지
		for(int i=0; i<service.returnlist().size();i++){
			if(keyword.equals(service.returnlist().get(i).getName())){
				System.out.println("찾은집 여기입니다.관련 정보 드릴게요");
				System.out.println(service.returnlist().get(i));
			}
		}
	
		
//		for(int i=0; i<restaurantService.returnlist().size();i++) {
//			System.out.println(restaurantService.returnlist().get(i));
//	
//		}
		//get lat get lag
		if(keyword.equals("exit")) {
			return;
		}
	}
	
	public double calc() {
		List<Restaurant> number = service.returnlist();
		double distance = Math.sqrt(Math.pow( (35.172876-number.get(0).getLat()),2) + (Math.pow (129.130731-number.get(0).getLag(),2)));
		return distance;
	}

	//결과 출력
	public void search(String keyword){
	service.search(keyword).forEach(res->System.out.println(res));
	
	searchByKeyword();
	}
	
}
