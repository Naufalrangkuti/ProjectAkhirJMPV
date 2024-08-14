package com.example.projectakhirjmp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnLihatData, btnInputData, btnInformasi, btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnLihatData = findViewById(R.id.buttonlihatdata);
        btnInputData = findViewById(R.id.buttoninputdata);
        btnInformasi = findViewById(R.id.buttoninformasi);
        btnKeluar = findViewById(R.id.buttonkeluar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLihatData.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, listdata.class);
            startActivity(intent);
        });

        btnInputData.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, inputdata.class);
            startActivity(intent);
        });

        btnInformasi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, informasi.class);
            startActivity(intent);
        });

        btnKeluar.setOnClickListener(v -> {
            finish();
        });
    }
}
