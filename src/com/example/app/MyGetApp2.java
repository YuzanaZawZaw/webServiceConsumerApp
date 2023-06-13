package com.example.app;

import org.springframework.web.client.RestTemplate;

public class MyGetApp2 {

	public static void main(String[] args) {
		String url="http://localhost:8080/Lec03_REST_SPRING_Provider/getuser/22";
		RestTemplate myRestTemp=new RestTemplate();
		String responStr=myRestTemp.getForObject(url, String.class);
		System.out.println(responStr);		
	}

}
