package com.hritik.articlereader.endpoints;

import com.hritik.articlereader.model.Entertainment;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService_huffpost {

    //We can pass the ending URL or can specify the full URL
    @GET("/v2/top-headlines?sources=the-huffington-post&apiKey=d6ff63172d094d7bb2ca3594cc66b2c1")

    //method name: can be kept anything you like
    //methodreturntype: You have to define what kind of data you expect from the server.
    //return type should be wrapped inside the call<>
    Call<Entertainment> getArticleDetails();

    //only one call is required
    //Call<List<Entertainment>> getEntertainmentDetails();
    //Call<List<Source>> getSourceDetails();

}
