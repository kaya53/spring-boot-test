package com.example.demo;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(value="")
public class HelloController {
	@GetMapping("/getUserInfo")
	public HashMap<String, String> getUserInfo() {
		// 콜렉션 클랙스 - 배열, map, json, hashmap 등
		// 해시맵, 딕셔너리, 객체 등 => 키 값으로 접근 가능
		HashMap<String, String> map = new HashMap<String, String>();
		
		// {"name": "길동이", ...}
		map.put("name", "길동이");
		map.put("phone", "010-9000-0001");
		map.put("address", "서울시 관악구");
		return map;
	}
	
	// Post 방식
	// add1?x=5&y=7 {x: 5, y: 7, result: 12} - get
	// add2/5/7 {x: 5, y: 7, result: 12} - get
	// add3 {x: 5, y: 7, result: 12} - post
	
	// @RequestParm(parameterName)을 앞에 붙여야 url의 쿼리 스트링을 인식함
	@GetMapping("/add1")
	public HashMap<String, Object> add1(@RequestParam("x") int x, @RequestParam("y") int y){
		// 예전) HttpServletRequest 객체에 변수들을 담아옴 => 여기로부터 x, y값을 추출해야 함
		// spring 사용 후) 인자를 써주면 알아서 추출해서 가져옴
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x+y);
		
		return map;
	}
	
	// add2/5/7
	@GetMapping("add2/{x}/{y}")
	public HashMap<String, Object> add2(@PathVariable("x") int x, @PathVariable("y") int y){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x+y);
		
		return map;
	}
	@PostMapping("add3")
	public HashMap<String, Object> add3(@RequestParam("x") int x, @RequestParam("y") int y){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x+y);
		
		return map;
	}
	
	// @RequestBody를 붙여줘야 json으로 받을 수 있다
	// HashMap<key값의 형태, value값의 형태>
	// HashMap<String, String> : 클라이언트에서 가져오는 값은 타입을 정확히 아니까 지정을 해준 것
	// HashMap<String, Object>: Object로 하는 이유 - 결과를 뭘로 보낼 지 모르니까
		// 문자열로 보낼 수도, 리스트로 보낼 수도 있고
	@PostMapping("add4")
	public HashMap<String, Object> add4(
			@RequestBody HashMap<String, String> map){
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		int x = Integer.parseInt(map.get("x").toString());
		int y = Integer.parseInt(map.get("y").toString());
		map2.put("x", x);
		map2.put("y", y);
		map2.put("result", x+y);
		return map2;
	}
}
