package com.hritik.articlereader.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hritik.articlereader.R;
import com.hritik.articlereader.adapters.Sports_adapter;
import com.hritik.articlereader.endpoints.GetDataService_sports;
import com.hritik.articlereader.model.Article;
import com.hritik.articlereader.model.Entertainment;
import com.hritik.articlereader.networks.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_sports extends Fragment {

    View view;
    ProgressDialog progressDialog;
    private Sports_adapter adapter;
    private RecyclerView recyclerView;
    List<Article> array_List;


/*
    List<News_list> newsList;
*/

    @Nullable
    @Override
//layoutinflater is used to bring up the selected layout
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sports, container, false);

        //Loading Dialog Box
        progressDialog = ProgressDialog.show(getActivity(), "", "Latest Sports News", true);
        progressDialog.show();

        /*to generate List of data using RecyclerView with custom adapter*/
        recyclerView = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        /*Create handle for the RetrofitInstance interface*/
        //initialize the endpoint GetDataService_entertainment instance


        //The main class is Entertainment which contains article and source. So we have to call that.
        //Always call the main class.
        GetDataService_sports service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService_sports.class);
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
                    adapter = new Sports_adapter(getActivity(), array_List);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Try Again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Entertainment> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}

        /* TO ADD STATIC DATA

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        newsList = new ArrayList<>();


        //adding some items to our list
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.tcc));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.tcc));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.tcc));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.tcc));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.tcc));


        // 3. create an adapter
        News_adapter mAdapter = new News_adapter(getActivity(), newsList);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return view;*/
