package com.example.app;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class MyPostApp {

	public static void main(String[] args) throws JSONException {
		String url="http://localhost:8080/Lec03_REST_SPRING_Provider/saveuser/";
		JSONObject userObj=new JSONObject();
		userObj.put("user_name", "Client Daw Su");
		userObj.put("user_age", 111);
		userObj.put("user_salary", 0);
		
		RestTemplate myRestTemp=new RestTemplate();
		String responStr=myRestTemp.postForObject(url, 
				userObj.toString(), 
				String.class);
		System.out.println(responStr);		
	}

}
