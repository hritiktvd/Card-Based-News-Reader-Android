package com.hritik.articlereader.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hritik.articlereader.Article_main;
import com.hritik.articlereader.R;
import com.hritik.articlereader.model.Article;
import com.hritik.articlereader.model.Entertainment;
import com.hritik.articlereader.model.Source;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Entertaiment_adapter extends RecyclerView.Adapter<Entertaiment_adapter.EntertainmentViewHolder> {

    //we are storing all the products in a list
    private List<Article> articleList;
    private List<Entertainment> entertainmentList;
    private List<Source> sourceList;
    //this context we will use to inflate the layout
    private Context context;
    //onclick to next page
    CardView cardView;


    //getting the context and product list with constructor
    public Entertaiment_adapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
        this.entertainmentList = entertainmentList;
        this.sourceList = sourceList;
    }

    //to create an instance of the product
    @NonNull
    @Override
    public EntertainmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_news, parent, false);
        return new EntertainmentViewHolder(view);
    }

    //binding the data to the view holder
    @Override
    public void onBindViewHolder(@NonNull EntertainmentViewHolder holder, int position) {

        holder.headline.setText(articleList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(articleList.get(position).getUrlToImage())
                .placeholder((R.drawable.ic_launcher_foreground))
                .error(R.drawable.entertainment_error)
                .into(holder.thumbnail);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = articleList.get(position).getTitle();
                String desc = articleList.get(position).getContent();
                String article_url = articleList.get(position).getUrl();

                Log.i("position", position + "");
                Bundle bundle = new Bundle();
                bundle.putString("img_url", articleList.get(position).getUrlToImage());
                bundle.putString("title", title);
                bundle.putString("description", desc);
                bundle.putString("url", article_url);
                Intent i_main = new Intent(context.getApplicationContext(), Article_main.class);
                i_main.putExtras(bundle);
                context.startActivity(i_main);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class EntertainmentViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView headline, shortdesc;
        ImageView thumbnail;

        EntertainmentViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            headline = mView.findViewById(R.id.headline);
            thumbnail = mView.findViewById(R.id.thumbnail);
            shortdesc = mView.findViewById(R.id.shortdesc);
            cardView = mView.findViewById(R.id.news_card);

        }
    }
}
