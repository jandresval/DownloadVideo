package com.utilities.downloadvideo.properties;

public class SuggestGetSet {
	
	String id,name;
	public SuggestGetSet(String id, String name){
		this.setId(id);
		this.setName(name);
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	

}
