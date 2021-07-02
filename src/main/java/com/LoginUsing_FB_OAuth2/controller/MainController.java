package com.LoginUsing_FB_OAuth2.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
		String loginApp(Principal principal)
	{
		
		Map<String, Object> authDetails = (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication()
                .getDetails();
		System.out.println("inside login app");
		String userName = (String) authDetails.get("name");
		

        return "Hey " + userName + ", Welcome to My App using Facebook OAuth2 login";
	}

}
