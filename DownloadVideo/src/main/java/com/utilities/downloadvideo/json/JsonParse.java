package com.utilities.downloadvideo.json;

import com.utilities.downloadvideo.properties.SuggestGetSet;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {
	
	public JsonParse(){}
	
	public List<SuggestGetSet> getParseJsonWCF(String sName){
		List<SuggestGetSet> ListData = new ArrayList<SuggestGetSet>();
        try {
           String temp=sName.replace(" ", "%20");	
           URL js = new URL("http://gdata.youtube.com/feeds/mobile/videos?alt=json&q="+temp+"&format=1,6");
           URLConnection jc = js.openConnection();
           BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
           String line = reader.readLine();
           JSONObject jsonResponse = new JSONObject(line);
           JSONObject jsonObjectFeed = (JSONObject) jsonResponse.get("feed");
           JSONArray jsonArray = jsonObjectFeed.getJSONArray("entry");
           for(int i = 0; i < jsonArray.length(); i++){
               JSONObject r = jsonArray.getJSONObject(i);
               JSONObject title = (JSONObject) r.get("title");
               JSONObject id = (JSONObject) r.get("id");
               JSONArray linkArray = (JSONArray) r.get("link");
               JSONObject link = linkArray.getJSONObject(3);
               JSONObject content = (JSONObject)r.get("content");
               JSONObject mediaGroup = (JSONObject)r.get("media$group");
               JSONArray mediaThumbnailArray = (JSONArray)mediaGroup.get("media$thumbnail");
               JSONObject mediaThumbnail = mediaThumbnailArray.getJSONObject(3);
               ListData.add(new SuggestGetSet(id.getString("$t"),title.getString("$t"),link.getString("href"),content.getString("$t"),mediaThumbnail.getString("url")));
           }
       }
        catch(MalformedURLException e1){
        	// TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (Exception e1) {
           // TODO Auto-generated catch block
           e1.printStackTrace();
       }
        return ListData;
	}


}
