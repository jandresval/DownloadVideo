package com.utilities.downloadvideo.properties;

public class SuggestGetSet {
	
	String id,name,link,description,imageUrl;

	public SuggestGetSet(String id, String name){
		this.setId(id);
		this.setName(name);
	}

    public SuggestGetSet(String id, String name,String link, String description, String imageUrl){
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.imageUrl = imageUrl;
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

    public String getLink(){
        return this.link;
    }

    public void setLink(String link){
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

}
