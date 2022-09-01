package com.example.daftarku.api_client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotosAPIClient {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private PhotosAPIClient(){}
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit != null) {
            return retrofit;
        }

        final Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
