package day01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Restaurant {

	private String name;
	private double lat; //위도
	private double lag; //경도
	private String tel;
	
}
