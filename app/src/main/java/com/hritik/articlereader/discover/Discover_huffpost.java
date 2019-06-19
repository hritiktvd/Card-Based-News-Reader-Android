package com.hritik.articlereader.discover;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hritik.articlereader.R;
import com.hritik.articlereader.adapters.Discover_adapter;
import com.hritik.articlereader.endpoints.GetDataService_huffpost;
import com.hritik.articlereader.model.Article;
import com.hritik.articlereader.model.Entertainment;
import com.hritik.articlereader.model.Source;
import com.hritik.articlereader.networks.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Discover_huffpost extends AppCompatActivity {

    View view;
    ProgressDialog progressDialog;
    /*
        List<News_list> newsList;
    */
    List<Article> array_List;
    int position;
    private Discover_adapter adapter;
    private RecyclerView recyclerView;
    //we are storing all the products in a list
    private List<Source> sourceList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news_discover);

        //getting name of the publisher

        getSupportActionBar().setTitle(R.string.huffpost); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#09061a")));


        //changing the color of status bar.
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark)); //status bar or the time bar at the top
        }

        //Loading Dialog Box
        progressDialog = ProgressDialog.show(this, "", "Loading", true);
        progressDialog.show();

        /*to generate List of data using RecyclerView with custom adapter*/
        recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        /*Create handle for the RetrofitInstance interface*/
        //initialize the endpoint GetDataService_entertainment instance


        //The main class is Entertainment which contains article and source. So we have to call that.
        //Always call the main class.
        GetDataService_huffpost service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService_huffpost.class);
        Call<Entertainment> articlecall = service.getArticleDetails();

        /*enqueue() asynchronously sends the request and notifies your app with a callback when a response comes back.
        Since this request is asynchronous,
         Retrofit handles it on a background thread so that the main UI thread isn't blocked or interfered with.
         */

        articlecall.enqueue(new Callback<Entertainment>() {
            @Override
            public void onResponse(Call<Entertainment> call, Response<Entertainment> response) {

                progressDialog.dismiss();
                String status = response.body().getStatus();
                if (status.equals("ok")) {
                    array_List = response.body().getArticles();
                    adapter = new Discover_adapter(Discover_huffpost.this, array_List);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Entertainment> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }


        });

    }

    //when back button is pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);


    }
}
