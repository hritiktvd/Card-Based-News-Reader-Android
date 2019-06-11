/* STATIC MODEL ADAPTER

package com.hritik.articlereader;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class News_adapter extends RecyclerView.Adapter<News_adapter.ProductViewHolder> {


*/
/*
    private View.OnClickListener clicklistener = null;
*//*


    CardView cardView;


    //this context we will use to inflate the layout

    private Context mCtx;

    //we are storing all the products in a list
    private List<News_list> productList;

    //getting the context and product list with constructor
    public News_adapter(Context mCtx, List<News_list> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    //to create an instance of the product
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_news, null);

        return new ProductViewHolder(view);
    }

    //binding the data to the view holder
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        News_list product = productList.get(position);
        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
*/
/*
        holder.textViewShortDesc.setText(product.getShortdesc());
*//*

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_article = new Intent(mCtx.getApplicationContext(), WelcomeScreen.class);
                mCtx.startActivity(i_article);
            }
        });

    }


    //Return the size of the list
    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.headline);
*/
/*
            textViewShortDesc = itemView.findViewById(R.id.shortdesc);
*//*

            imageView = itemView.findViewById(R.id.thumbnail);
            cardView = itemView.findViewById(R.id.news_card);


        }


    }

*/
/*    public void setClicklistener (View.OnClickListener clicklistener){
        this.clicklistener = clicklistener;
    }*//*

}*/
