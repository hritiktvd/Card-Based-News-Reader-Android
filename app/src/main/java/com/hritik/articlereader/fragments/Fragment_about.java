package com.hritik.articlereader.fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hritik.articlereader.R;
import com.makeramen.roundedimageview.RoundedImageView;

public class Fragment_about extends Fragment {

    View view;
    RoundedImageView insta, git, gmail, linkedin, interno;

    @Nullable
    @Override
    //layoutinflater is used to bring up the selected layout
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about, container, false);

        insta = view.findViewById(R.id.insta);
        git = view.findViewById(R.id.git);
        linkedin = view.findViewById(R.id.linkedin);
        gmail = view.findViewById(R.id.gmail);
        interno = view.findViewById(R.id.interno);

        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String github = "https://github.com/hritiktvd";
                Intent i_github = new Intent(Intent.ACTION_VIEW, Uri.parse(github));
                startActivity(i_github);
            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linked = "https://www.linkedin.com/in/hritik-trivedi-a560b0174/";
                Intent i_linkedin = new Intent(Intent.ACTION_VIEW, Uri.parse(linked));
                startActivity(i_linkedin);
            }
        });

        interno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String interno = "https://www.f6s.com/interno";
                Intent i_interno = new Intent(Intent.ACTION_VIEW, Uri.parse(interno));
                startActivity(i_interno);
            }
        });


        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/interno_ar");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/hritik_tvd")));
                }
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "interno.xr.solutions@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query:");
                startActivity(Intent.createChooser(emailIntent, null));
            }
        });


        return view;
    }
}
