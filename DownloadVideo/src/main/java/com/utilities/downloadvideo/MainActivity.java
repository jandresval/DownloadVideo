package com.utilities.downloadvideo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.utilities.downloadvideo.properties.SuggestGetSet;
import com.utilities.downloadvideo.utilities.AsincJsonParser;
import com.utilities.downloadvideo.utilities.SimpleArrayAdapter;
import com.utilities.downloadvideo.utilities.SuggestionAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.T_findVideo);

        if (acTextView == null)
            return;

        Editable textView = acTextView.getText();

        if (textView == null)
            return;

        acTextView.setAdapter(new SuggestionAdapter(this,textView.toString()));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onClickSearchButton(View v){
        ListView listView = (ListView) findViewById(R.id.list_Videos);

        AutoCompleteTextView acTextView;
        acTextView = (AutoCompleteTextView) findViewById(R.id.T_findVideo);

        if (acTextView == null)
            return;

        Editable textView = acTextView.getText();

        if (textView == null)
            return;

        if (!textView.toString().equals("")) {

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

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), ProcessDownloadVideo.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                }
            });
        }

    }

    
    
}
