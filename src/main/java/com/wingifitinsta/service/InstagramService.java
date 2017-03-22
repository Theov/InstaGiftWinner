package com.wingifitinsta.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.wingiftinsta.model.FriendJson;
import com.wingiftinsta.model.FriendsJson;
import com.wingiftinsta.model.TokenJson;

@Service
public class InstagramService {
	
	private static final String HOST = "https://api.instagram.com";
	private static final String ENDPOINT_ACCESS_TOKEN = "/oauth/access_token";
	private static final String ENDPOINT_FOLLOWED_BY = "/v1/users/self/follows";

	static Logger log = Logger.getLogger(InstagramService.class);
			
	private RestTemplate rest;
	
	private String accessToken;
		
	
	public String getTokenBy(String code){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		rest = new RestTemplate();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("client_id", "");
		parameters.add("client_secret","");
		parameters.add("grant_type","authorization_code");
		parameters.add("redirect_uri","http://localhost:8083/test");
		parameters.add("code",code);
		
		TokenJson response = null;
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(parameters, headers);
		try{
			response = rest.postForObject(HOST + ENDPOINT_ACCESS_TOKEN, request, TokenJson.class);
			log.info(response);
		}catch(HttpClientErrorException e){
			System.out.println(e.getResponseBodyAsString());
		}
		this.accessToken = response.getToken();
		return accessToken;
	}
		
	
	public ArrayList<FriendJson> getRelationships(){
		rest = new RestTemplate();
		FriendsJson subscriptionList = null;
		try{
			subscriptionList = rest.getForObject(HOST + ENDPOINT_FOLLOWED_BY + "?access_token=" + this.getToken(), FriendsJson.class);
			log.info(subscriptionList.getData());
		}catch(HttpClientErrorException e){
			e.printStackTrace();
		}
		return subscriptionList.getData();
	}


	private String getToken() {
		return this.accessToken;
	}
	
	
}
