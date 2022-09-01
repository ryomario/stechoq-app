package com.example.daftarku.api_services;

import com.example.daftarku.model.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PhotosService {
    @GET("photos")
    Call<List<Photo>> getAllPhotos();
}
