package com.hritik.articlereader;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Article_main extends AppCompatActivity {

    ImageView coverImage;
    TextView articletitle, articledesc;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_article);

        //changing the color of status bar.
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark)); //status bar or the time bar at the top
        }

        coverImage = findViewById(R.id.coverImage);
        articletitle = findViewById(R.id.articletitle);
        articledesc = findViewById(R.id.articledesc);

        Bundle bundle = getIntent().getExtras();
        String showtitle = bundle.getString("title");
        String showdesc = bundle.getString("description");
        String image = bundle.getString("img_url");

        Picasso.with(this).load(image).into(coverImage);

        articletitle.setText(showtitle);
        articledesc.setText(showdesc);



    }
}
