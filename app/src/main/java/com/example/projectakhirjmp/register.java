package com.example.projectakhirjmp;

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

public class register extends AppCompatActivity {
    Button btnregister;
    EditText eduser, edpass, edconfirmPass;
    DatabaseHelper dblogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnregister = findViewById(R.id.buttonreg);
        eduser = findViewById(R.id.editTextUser);
        edpass = findViewById(R.id.editTextPass);
        edconfirmPass = findViewById(R.id.editTextConfirmPass);
        dblogin = new DatabaseHelper(this);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = eduser.getText().toString();
                String password = edpass.getText().toString();
                String confirmPassword = edconfirmPass.getText().toString();

                if (user.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                Boolean checkUser = dblogin.checkUser(user);
                if (!checkUser) {
                    Boolean insert = dblogin.insertUser(user, password);
                    if (insert) {
                        Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(register.this, "Username already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button backToLogin = findViewById(R.id.backtologin);
        backToLogin.setOnClickListener(v -> finish());
    }
}