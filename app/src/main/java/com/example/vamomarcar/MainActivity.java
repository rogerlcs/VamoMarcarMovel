package com.example.vamomarcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Config.getLogin(MainActivity.this).isEmpty()) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
        else {
            Intent i = new Intent(MainActivity.this, AllEventsActivity.class);
            startActivity(i);
            finish();
        }

    }
}