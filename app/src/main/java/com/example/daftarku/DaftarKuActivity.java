package com.example.daftarku;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.example.daftarku.api_client.PhotosAPIClient;
import com.example.daftarku.api_services.PhotosService;
import com.example.daftarku.daftarku.DaftarKuAdapter;
import com.example.daftarku.model.Photo;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class DaftarKuActivity extends AppCompatActivity {

    private DaftarKuAdapter daftarKuAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_ku);

        setTitle("Daftar Photo");

        RecyclerView daftarku = findViewById(R.id.daftar_ku);

//        Adapter
        daftarKuAdapter = new DaftarKuAdapter(getApplicationContext());

//        Terapkan adapter ke recyclerview
        daftarku.setAdapter(daftarKuAdapter);

        fetchData();
    }

//    @Override
//    protected void onStart() {
//        fetchData();
//
//        super.onStart();
//    }

    void fetchData() {
        Toast.makeText(this,"Fetching",Toast.LENGTH_SHORT).show();
        PhotosService service = PhotosAPIClient.getClient().create(PhotosService.class);
        Call<List<Photo>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NotNull Call<List<Photo>> call, @NotNull Response<List<Photo>> response) {
                setDaftarPhoto(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<Photo>> call, @NotNull Throwable t) {
                Log.e("Daftar photos","Error fetching daftar photos",t);
            }
        });
    }

    void setDaftarPhoto(List<Photo> daftar) {
//        Update list
        daftarKuAdapter.setData(daftar);
    }
}