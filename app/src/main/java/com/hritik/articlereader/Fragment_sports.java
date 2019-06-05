package com.hritik.articlereader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment_sports extends Fragment {

    View view;
    List<News_list> newsList;

    @Nullable
    @Override
//layoutinflater is used to bring up the selected layout
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sports, container, false);

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        newsList = new ArrayList<>();


        //adding some items to our list
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));
        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));

        newsList.add(
                new News_list("Modi Won", "Clean sweep by Modi. 352 seats for BJP.", R.drawable.logosmall));


        // 3. create an adapter
        News_adapter mAdapter = new News_adapter(getActivity(), newsList);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return view;
    }
}
