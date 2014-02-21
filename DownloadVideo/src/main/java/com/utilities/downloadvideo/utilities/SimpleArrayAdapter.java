package com.utilities.downloadvideo.utilities;

/**
 * Created by jandresv on 17/01/14.
 */

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.utilities.downloadvideo.R;
import com.utilities.downloadvideo.properties.SuggestGetSet;

import java.util.List;

import static android.content.Context.*;


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

    private class ViewHolder {
        TextView textView;
        TextView descriptionView;
        ImageView imageView;
    }


    @Override
    public View getView(int position, View contentView, ViewGroup parent){

        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewHolder title;

        if(contentView == null) {
            contentView = inflater.inflate(R.layout.rowlayout,parent,false);
            title = new ViewHolder();
            if (!(contentView == null))
                title.textView = (TextView) contentView.findViewById(R.id.label);
            if (!(contentView == null))
                title.descriptionView = (TextView) contentView.findViewById(R.id.secondLine);
            if (!(contentView == null))
                title.imageView = (ImageView) contentView.findViewById(R.id.icon);
            if (!(contentView == null)) contentView.setTag(title);
        } else {
            title = (ViewHolder) contentView.getTag();
        }


        SuggestGetSet myClass;
        myClass = values.get(position);
        title.textView.setText(myClass.getName());
        title.descriptionView.setText(myClass.getDescription());
        imageLoader.DisplayImage(myClass.getImageUrl(),title.imageView);


        return contentView;
    }

}
