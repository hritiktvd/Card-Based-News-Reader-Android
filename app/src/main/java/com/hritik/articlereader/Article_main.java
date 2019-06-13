package com.hritik.articlereader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Article_main extends AppCompatActivity {

    ImageView coverImage;
    TextView articletitle, articledesc;
    Context context;
    Button fullarticle, sharearticle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_article);

        getSupportActionBar().setTitle("ARTICLE READER"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#09061a")));


        //changing the color of status bar.
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark)); //status bar or the time bar at the top
        }


        coverImage = findViewById(R.id.coverImage);
        articletitle = findViewById(R.id.articletitle);
        articledesc = findViewById(R.id.articledesc);
        fullarticle = findViewById(R.id.fullarticle);
        sharearticle = findViewById(R.id.sharearticle);

        Bundle bundle = getIntent().getExtras();
        String showtitle = bundle.getString("title");
        String showdesc = bundle.getString("description");
        String image = bundle.getString("img_url");
        String url = bundle.getString("url");

        Picasso.with(this).load(image).into(coverImage);

        articletitle.setText(showtitle);
        articledesc.setText(showdesc);
        fullarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_url = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i_url);
            }
        });

        //share button intent
        sharearticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_share = new Intent(Intent.ACTION_SEND);
                i_share.setType("text/plain");
                String body = "Hey check out this amazing article I found  " + url +
                        "  Download Article Reader on Play Store for more amazing articles like this";
                String sub = "Subject here";
                i_share.putExtra(Intent.EXTRA_SUBJECT, sub);
                i_share.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(i_share, "Share Using"));
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
