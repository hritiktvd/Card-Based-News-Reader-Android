/*To issue network requests to a REST API with Retrofit,
 we need to create an instance using the Retrofit.
 Builder class and configure it with a base URL.*/

//Base URL is the basic url where the api will call

package com.hritik.articlereader.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance_entertainment {


    public static final String BASE_URL = "https://newsapi.org";
    public static Retrofit retrofit;

    /*GsonConvertor maps the json strings to its equivalent mapped java object in the model and vice versa*/

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
