package com.example.demo;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*	
 * @RequestBody
 * 데이터를 client가 json 형태로 보낼 때 json 데이터를 받아서 자바 객체로 변환 과정을 거침
 * HashMap이나 DTO(Data Transfer Object) 클래스
 * db 테이블 필드와 거의 1:1
 * 3개의 테이블을 조인해서 필요한 필드만큼 만들 수 있다
 * 클라이언트로부터 파라미터를 받아올 때 보통 DTO 사용
 *
 * xml: 실제 데이터를 가져오는 파싱 과정이 별도로 필요함 => 그래서 보통 json 사용
*/

@CrossOrigin("*")
@RestController
@RequestMapping(value="")
public class WageController {
	@PostMapping("/payment")
	public HashMap<String, Object> setWagePerWeek(
			@RequestBody HashMap<String, String> map) {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		int time = Integer.parseInt(map.get("time").toString());
		int cost = Integer.parseInt(map.get("cost").toString());
		
		resMap.put("time", time);
		resMap.put("cost", cost);
		resMap.put("wage", time*cost);
		
		return resMap;
	}
}
