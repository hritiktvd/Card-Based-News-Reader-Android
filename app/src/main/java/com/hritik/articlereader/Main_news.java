package com.hritik.articlereader;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main_news extends AppCompatActivity {

    //a list to store all the products
    List<News_list> newsList;
    //the recyclerview
    RecyclerView recyclerView;
    private Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        newsList = new ArrayList<>();


        //adding some items to our list
        newsList.add(
                new News_list("E3 is next week", "Upcoming E3 will be held in Los Angeles.", R.drawable.logosmall));

        newsList.add(
                new News_list("E3 is next week", "Upcoming E3 will be held in Los Angeles.", R.drawable.logosmall));
        newsList.add(
                new News_list("E3 is next week", "Upcoming E3 will be held in Los Angeles.", R.drawable.logosmall));
        newsList.add(
                new News_list("E3 is next week", "Upcoming E3 will be held in Los Angeles.", R.drawable.logosmall));

        //creating recyclerview adapter
        News_adapter adapter = new News_adapter(this, newsList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }


}
