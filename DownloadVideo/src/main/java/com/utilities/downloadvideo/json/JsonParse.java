package com.utilities.downloadvideo.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
 
import org.json.JSONArray;
import org.json.JSONObject;

import com.utilities.downloadvideo.properties.SuggestGetSet;

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
               ListData.add(new SuggestGetSet(r.getString("id"),title.getString("$t")));
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
