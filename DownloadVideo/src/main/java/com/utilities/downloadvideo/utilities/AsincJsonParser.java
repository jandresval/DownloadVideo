package com.utilities.downloadvideo.utilities;

import android.os.AsyncTask;

import com.utilities.downloadvideo.json.JsonParse;
import com.utilities.downloadvideo.properties.SuggestGetSet;

import java.util.List;

/**
 * Created by jandresv on 20/01/14.
 */
public class AsincJsonParser extends AsyncTask<String,Void,List<SuggestGetSet>> {

    @Override
    protected List<SuggestGetSet> doInBackground(String... params) {
        JsonParse jp=new JsonParse();
        return jp.getParseJsonWCF(params[0].toString());
    }


}
