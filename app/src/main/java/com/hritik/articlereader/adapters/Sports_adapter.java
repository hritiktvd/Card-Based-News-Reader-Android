package com.hritik.articlereader.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hritik.articlereader.R;
import com.hritik.articlereader.model.Article;
import com.hritik.articlereader.model.Entertainment;
import com.hritik.articlereader.model.Source;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Sports_adapter extends RecyclerView.Adapter<Sports_adapter.SportsViewHolder> {

    //we are storing all the products in a list
    private List<Article> articleList;
    private List<Entertainment> entertainmentList;
    private List<Source> sourceList;
    //this context we will use to inflate the layout
    private Context context;

    //getting the context and product list with constructor
    public Sports_adapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
        this.entertainmentList = entertainmentList;
        this.sourceList = sourceList;
    }


    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_news, parent, false);
        return new SportsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {

        holder.headline.setText(articleList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(articleList.get(position).getUrlToImage())
                .placeholder((R.drawable.ic_launcher_foreground))
                .error(R.drawable.sports_error)
                .into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class SportsViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView headline;
        ImageView thumbnail;

        SportsViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            headline = mView.findViewById(R.id.headline);
            thumbnail = mView.findViewById(R.id.thumbnail);
        }
    }

}
