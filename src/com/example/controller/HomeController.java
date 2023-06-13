package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.service.UserWebService;

@Controller
public class HomeController {
	@Autowired
	private UserWebService userWebService;
	
	@RequestMapping(value={"/"},method=RequestMethod.GET)
	public String dispatchHome(ModelMap modelMap){
		Map<String,List<User>> m=this.userWebService.processAll();
		for(String key:m.keySet()){
			modelMap.put("message", key);
			modelMap.put("ulist", m.get(key));
		}		
		return "home";
	}
}
