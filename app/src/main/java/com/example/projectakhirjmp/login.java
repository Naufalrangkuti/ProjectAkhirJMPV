package com.example.projectakhirjmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
    Button btnregister,btnlogin;
    EditText eduserlogin,edpasslogin;
    DatabaseHelper dblogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnregister = findViewById(R.id.buttonregister);
        btnlogin = findViewById(R.id.buttonlogin);
        eduserlogin = findViewById(R.id.editTextText2);
        edpasslogin = findViewById(R.id.editTextTextPassword);

        dblogin = new DatabaseHelper(this);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser =eduserlogin.getText().toString();
                String spassword = edpasslogin.getText().toString();
                Boolean checkUserPassword = dblogin.checkUserPassword(suser, spassword);
                if (checkUserPassword) {
                    Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(login.this,register.class);
                startActivity(intent);
            }
        });
    }
}