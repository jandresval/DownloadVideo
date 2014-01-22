package com.utilities.downloadvideo.utilities;

/**
 * Created by jandresv on 17/01/14.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.utilities.downloadvideo.R;
import com.utilities.downloadvideo.properties.SuggestGetSet;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.util.List;


public class SimpleArrayAdapter extends ArrayAdapter<SuggestGetSet> {

    private final Context context;
    private final List<SuggestGetSet> values;
    public ImageLoader imageLoader;

    public SimpleArrayAdapter(Context context, List<SuggestGetSet> values){
        super(context,R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
        imageLoader = new ImageLoader(context);
    }


    @Override
    public View getView(int position, View contentView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout,parent,false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        textView.setMovementMethod(new ScrollingMovementMethod());
        TextView descriptionView = (TextView) rowView.findViewById(R.id.secondLine);
        descriptionView.setMovementMethod(new ScrollingMovementMethod());
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        SuggestGetSet myClass;
        myClass = values.get(position);
        textView.setText(myClass.getName());
        descriptionView.setText(myClass.getDescription());

        imageLoader.DisplayImage(myClass.getImageUrl(),imageView);

        return rowView;
    }

}
