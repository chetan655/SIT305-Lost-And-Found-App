package com.example.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lostandfoundapp.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    Button newAdvertBtn, itemSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newAdvertBtn = findViewById(R.id.newAdvertBtn);
        itemSearchBtn = findViewById(R.id.itemSearchBtn);

        newAdvertBtn.setOnClickListener(view -> {
            Intent newAdvertIntent = new Intent(getApplicationContext(), NewAdvert.class);
            startActivity(newAdvertIntent);
        });

        itemSearchBtn.setOnClickListener(view -> {
            Intent sAdvertIntent = new Intent(getApplicationContext(), SearchAdvert.class);
            startActivity(sAdvertIntent);
        });
    }
}