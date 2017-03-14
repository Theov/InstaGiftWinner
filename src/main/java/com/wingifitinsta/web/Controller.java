package com.wingifitinsta.web;

import java.lang.annotation.Annotation;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wingifitinsta.service.InstagramService;

@RestController
public class Controller {
	
    @Autowired
    private InstagramService authentication;

    
    @RequestMapping("/test")
    public String redirectAuthorize(@RequestParam String code){
    	if(code.contains("access_token")){
    		System.out.println(code);
    	}else{
    		System.out.println(code);
    		authentication.getAuthorize(code);
    	}
    	return "";
    }
    
    
}
