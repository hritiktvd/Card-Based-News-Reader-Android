package com.hritik.articlereader.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hritik.articlereader.R;

public class Fragment_share extends Fragment {

    View view;
    Button shareapp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_share, container, false);
        shareapp = view.findViewById(R.id.shareapp);

        shareapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_share = new Intent(Intent.ACTION_SEND);
                i_share.setType("text/plain");
                String body = "Download Article Reader on Play Store now";
                String sub = "";
                i_share.putExtra(Intent.EXTRA_SUBJECT, sub);
                i_share.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(i_share, "Share Using"));
            }
        });

        return view;
    }
}

