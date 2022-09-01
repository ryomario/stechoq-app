package com.example.daftarku;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button daftarku = findViewById(R.id.btn_daftarku);

        daftarku.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DaftarKuActivity.class);

            startActivity(i);
        });
    }
}