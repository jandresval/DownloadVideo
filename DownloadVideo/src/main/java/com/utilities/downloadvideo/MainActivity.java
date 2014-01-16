package com.utilities.downloadvideo;

import com.utilities.downloadvideo.utilities.SuggestionAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AutoCompleteTextView;

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
    
    
}
