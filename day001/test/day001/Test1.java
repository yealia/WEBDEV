package day001;

import org.junit.jupiter.api.Test;

import day01.service.RestaurantService;
import day01.ui.RestaurantUI;

public class Test1 {

	
	
	@Test
	public void test1() {
		RestaurantUI restaurantUI = RestaurantUI.INSTANCE;
		restaurantUI.searchByKeyword();
		
		
		
		RestaurantService restaurantService = RestaurantService.INSTANCE;
		
		
		System.out.println(restaurantService.returnlist().get(0).getLat());
		System.out.println(restaurantService.returnlist().get(0).getLag());
//		System.out.println("======");
//		for(int i=0 i<)
//		
		System.out.println(restaurantUI.calc());
	}


}
