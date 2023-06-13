package com.example.app;

import org.springframework.web.client.RestTemplate;

public class MyGetApp {

	public static void main(String[] args) {
		String url="http://localhost:8080/Lec03_REST_SPRING_Provider/alluser/";
		RestTemplate myRestTemp=new RestTemplate();
		String responStr=myRestTemp.getForObject(url, String.class);
		System.out.println(responStr);		
	}

}
