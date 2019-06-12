package com.hritik.articlereader;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Article_main extends AppCompatActivity {

    ImageView coverImage;
    TextView articletitle, articledesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_article);

        coverImage = findViewById(R.id.coverImage);
        articletitle = findViewById(R.id.articletitle);
        articledesc = findViewById(R.id.articledesc);

        //changing the color of status bar.
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark)); //status bar or the time bar at the top
        }
    }
}
