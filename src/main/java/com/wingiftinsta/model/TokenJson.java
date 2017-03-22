package com.wingiftinsta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenJson {

	private String access_token;
	
	public TokenJson() {
	}
	
	public String getToken(){
		return this.access_token;
	}

}
