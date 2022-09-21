package day01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import day01.dto.Restaurant;

public enum RestaurantService {

	INSTANCE;
	
	private List<Restaurant> stores;
	RestaurantService(){
		
		
		stores = new ArrayList();
		stores.add(new Restaurant("79수육국밥철판",35.166678,129.13301,"111-222"));
		stores.add(new Restaurant("수변최고돼지",35.167310,129.133479,"111-222"));
		stores.add(new Restaurant("해담소곱창순대국",35.137901,129.132896,"111-222"));
		stores.add(new Restaurant("김가네돼지국밥",35.170389,129.132463,"111-222"));
		stores.add(new Restaurant("선우경맛국밥",35.173003,129.131629,"111-222"));

		
	}
	public List<Restaurant> returnlist() {
		return stores;
	}
	
	public List<Restaurant> search(String keyword){
		return stores.stream()
			.filter(res -> res.getName().indexOf(keyword) >=0)
			.collect(Collectors.toList());
	}

}
