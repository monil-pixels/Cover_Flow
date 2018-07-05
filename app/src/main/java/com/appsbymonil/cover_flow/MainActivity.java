package com.appsbymonil.cover_flow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow ;
    private MovieAdapter movieAdapter ;
    private List<Movie> movieList = new ArrayList<>();
    private TextSwitcher mTitle ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView txt = (TextView) inflater.inflate(R.layout.layout_title, null);
                return txt;

            }

        });

        Animation in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);


            movieAdapter = new MovieAdapter(movieList, this);
            coverFlow = (FeatureCoverFlow) findViewById(R.id.coverFlow);
            coverFlow.setAdapter(movieAdapter);
            coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
                @Override
                public void onScrolledToPosition(int position) {
                    mTitle.setText(movieList.get(position).getName());
                }

                @Override
                public void onScrolling() {

                }
            });

    }
    private void initData() {
        movieList.add(new Movie("1" , "https://cdn.pixabay.com/photo/2016/10/27/22/53/heart-1776746_960_720.jpg"));
        movieList.add(new Movie("2" , "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX11577994.jpg"));
        movieList.add(new Movie("3" , "https://cdn.pixabay.com/photo/2017/05/09/21/49/gecko-2299365_960_720.jpg"));
        movieList.add(new Movie("4" , "http://www.gettyimages.com/gi-resources/images/Embed/new/embed2.jpg"));
        movieList.add(new Movie("5" , "http://www.qygjxz.com/data/out/123/4027476-images.jpg"));
        movieList.add(new Movie("6" , "https://s-media-cache-ak0.pinimg.com/236x/a7/c0/56/a7c05674c576d8cc20dbf331b452a09c.jpg"));
        movieList.add(new Movie("7" , "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsXUtxNPqBET8CdLgZ-ByWd6pa9AQioyOl-Drf2G7dhaC65irp6Q"));
        movieList.add(new Movie("8" , "http://www.qygjxz.com/data/out/240/3848765-wallpaper-images-download.jpg"));


    }
}
