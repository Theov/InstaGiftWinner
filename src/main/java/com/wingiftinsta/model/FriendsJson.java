package com.wingiftinsta.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendsJson {
	
	private ArrayList<FriendJson> data;
	
	public FriendsJson(){
	}
	
	public ArrayList<FriendJson> getData(){
		return this.data;
	}

}
