package com.appsbymonil.cover_flow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hp 15 on 8/8/2017.
 */

public class MovieAdapter extends BaseAdapter {
    private List<Movie> movieList;
    private Context mContext ;

    public MovieAdapter(List<Movie> movieList, Context mContext) {
        this.movieList = movieList;
        this.mContext = mContext;
    }





    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view ;
        if (rowView == null){
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item , null);
            TextView name = (TextView)rowView.findViewById(R.id.label);
            ImageView image = (ImageView)rowView.findViewById(R.id.image);


            Picasso.with(mContext).load(movieList.get(i).getImageUrl()).into(image);
            name.setText(movieList.get(i).getName());
        }
        return rowView ;
            }
}
