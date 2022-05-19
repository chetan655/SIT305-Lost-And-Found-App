package com.example.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lostandfoundapp.data.DatabaseHelper;
import com.example.lostandfoundapp.model.Item;

public class NewAdvert extends AppCompatActivity {

    DatabaseHelper db;
    Button saveBtn;
    EditText personNameEditText, phoneNumEditText, descriptionEditText, dateEditText, locationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);

        saveBtn = findViewById(R.id.saveBtn);
        personNameEditText = findViewById(R.id.personNameEditText);
        phoneNumEditText = findViewById(R.id.phoneNumEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        dateEditText = findViewById(R.id.dateEditText);
        locationEditText = findViewById(R.id.locationEditText);

        db = new DatabaseHelper(this );

        saveBtn.setOnClickListener(view -> {

            String Name = personNameEditText.getText().toString();
            String Phone = phoneNumEditText.getText().toString();
            String Desc = descriptionEditText.getText().toString();
            String Date = dateEditText.getText().toString();
            String Location = locationEditText.getText().toString();

            if (!Name.isEmpty() && !Phone.isEmpty() && !Desc.isEmpty() && !Date.isEmpty() && !Location.isEmpty()) {

                long result = db.insertItem(new Item(Name, Phone, Desc, Date, Location));
                Log.d("newItem", String.valueOf(result));

                if (result > 0) {
                    Toast.makeText(this, "Item Added To The List", Toast.LENGTH_SHORT).show();
                    Intent backToMainIntent =  new Intent(getApplicationContext() , MainActivity.class);
                    startActivity(backToMainIntent);
                } else { Toast.makeText(NewAdvert.this, "Item Not Added To The List", Toast.LENGTH_SHORT).show(); }
            } else { Toast.makeText(NewAdvert.this, "Enter The Required Details" , Toast.LENGTH_SHORT).show(); }
        });
    }
}