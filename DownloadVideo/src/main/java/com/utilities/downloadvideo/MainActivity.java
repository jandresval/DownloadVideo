package com.utilities.downloadvideo;


import com.utilities.downloadvideo.properties.SuggestGetSet;
import com.utilities.downloadvideo.utilities.AsincJsonParser;
import com.utilities.downloadvideo.utilities.SimpleArrayAdapter;
import com.utilities.downloadvideo.utilities.SuggestionAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.T_findVideo);
        acTextView.setAdapter(new SuggestionAdapter(this,acTextView.getText().toString()));

    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onClickSearchButton(View v){
        ListView listView = (ListView) findViewById(R.id.list_Videos);

        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.T_findVideo);
        if (!acTextView.getText().toString().equals("")) {
            AsincJsonParser ajp = new AsincJsonParser();
            List<SuggestGetSet> values = null;
            try {
                values = ajp.execute(acTextView.getText().toString()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            listView.setAdapter(new SimpleArrayAdapter(this,values));
        }

    }

    public void onClickListView(View v) {

    }
    
    
}
