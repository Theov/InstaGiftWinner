package com.wingifitinsta.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wingifitinsta.service.InstagramService;
import com.wingiftinsta.model.FriendJson;

@RestController
public class Controller {
	
    @Autowired
    private InstagramService service;

    
    @RequestMapping("/test")
    public String redirectAuthorize(@RequestParam String code){
    	return service.getTokenBy(code);
    }
    
    
    @RequestMapping("/friends")
    public ArrayList<FriendJson> getFriends(){
    	return service.getRelationships();
    }
    
}
