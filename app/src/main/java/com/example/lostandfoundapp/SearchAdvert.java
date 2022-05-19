package com.example.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lostandfoundapp.data.DatabaseHelper;
import com.example.lostandfoundapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class SearchAdvert extends AppCompatActivity {

    ListView itemListView;
    ArrayList<String> itemArrayList;
    ArrayAdapter<String> adapter;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_advert);

        itemListView = findViewById(R.id.itemListView);
        itemArrayList = new ArrayList<>();
        db = new DatabaseHelper(SearchAdvert.this);

        List<Item> itemList = db.fetchAllItems();

        for(Item item:itemList){ itemArrayList.add(item.getUserName()); }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemArrayList);
        itemListView.setAdapter(adapter);

        itemListView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent removeAdvertIntent =  new Intent(SearchAdvert.this, RemoveAdvert.class);
            System.out.println(i);
            removeAdvertIntent.putExtra("ItemId", i);
            startActivity(removeAdvertIntent);
        });
    }
}