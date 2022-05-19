package com.example.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lostandfoundapp.data.DatabaseHelper;
import com.example.lostandfoundapp.model.Item;

public class RemoveAdvert extends AppCompatActivity {

    TextView dateEditText2, locationEditText2, descriptionEditText2;
    Button removeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_advert);

        dateEditText2 = findViewById(R.id.dateEditText2);
        locationEditText2 = findViewById(R.id.locationEditText2);
        descriptionEditText2 = findViewById(R.id.descriptionEditText2);
        removeBtn = findViewById(R.id.removeBtn);

        DatabaseHelper db = new DatabaseHelper(RemoveAdvert.this);
        int itemId = getIntent().getExtras().getInt("ItemId")+1;

        Item item = db.fetchItem(itemId);

        dateEditText2.setText(item.getDate());
        locationEditText2.setText(item.getLocation());
        descriptionEditText2.setText(item.getDescription());

        removeBtn.setOnClickListener(view -> {
            db.removeItem(itemId);
            Toast.makeText(this, "Item Removed From The List" , Toast.LENGTH_SHORT).show();
            Intent backToMain = new Intent(this , MainActivity.class);
            startActivity(backToMain);
        });

    }
}