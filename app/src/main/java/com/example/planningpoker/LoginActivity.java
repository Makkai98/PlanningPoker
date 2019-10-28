package com.example.planningpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editText_name);
        Button sign_in = findViewById(R.id.button_signin);
        //adatbazismuvelet


        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_intent = new Intent(LoginActivity.this, MainActivity.class);
                login_intent.putExtra("Name",username.getText().toString());
                startActivity(login_intent);
            }
        });
    }
}
