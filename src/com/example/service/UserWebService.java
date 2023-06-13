package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;
import com.example.utils.WebServiceUtils;

@Service
public class UserWebService {
	public Map<String,List<User>> processAll(){
		Map<String,List<User>> m=new HashMap<String,List<User>>();
		RestTemplate myTemplate=new RestTemplate();
		String jsonStr=myTemplate.getForObject(
				WebServiceUtils.BASE_URL+WebServiceUtils.GET_ALL_URL,
				String.class);
		try{
			JSONObject jsonObj=new JSONObject(jsonStr);
			String key=(String)jsonObj.get("message");
			
			JSONArray jsonArray=jsonObj.getJSONArray("userslist");
			List<User> ul=new ArrayList<User>();
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonUser=jsonArray.getJSONObject(i);
				User user=new User();
					user.setUserId(jsonUser.getLong("user_id"));
					user.setUserName(jsonUser.getString("user_name"));
					user.setUserAge(jsonUser.getInt("user_age"));
					user.setUserSalary(jsonUser.getDouble("user_salary"));
				ul.add(user);						
			}
			m.put(key, ul);		
		}catch(Exception e){}
		return m;
	}
}
