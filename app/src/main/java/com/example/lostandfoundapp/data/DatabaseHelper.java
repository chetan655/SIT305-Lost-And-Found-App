package com.example.lostandfoundapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.lostandfoundapp.model.Item;
import com.example.lostandfoundapp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ITEM_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" +Util.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Util.USER_NAME + " TEXT," + Util.PHONE_NUM + " TEXT," + Util.DESCRIPTION + " TEXT," + Util.DATE + " TEXT," + Util.LOCATION
                + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_USER_TABLE = ("DROP TABLE IF EXISTS " + Util.TABLE_NAME);
        sqLiteDatabase.execSQL(DROP_USER_TABLE, new String[]{Util.TABLE_NAME});
        onCreate(sqLiteDatabase);
    }

    public long insertItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.USER_NAME, item.getUserName());
        contentValues.put(Util.PHONE_NUM, item.getPhoneNum());
        contentValues.put(Util.DESCRIPTION, item.getDescription());
        contentValues.put(Util.DATE, item.getDate());
        contentValues.put(Util.LOCATION, item.getLocation());

        long newRowId = db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    public Item fetchItem(int val){

        Item item = new Item();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(" SELECT * FROM " + Util.TABLE_NAME,  null);

        if (cursor.moveToFirst() && cursor.getCount() >= 1 ) {
            do {
                if (cursor.getInt(0) == val) {

                    item.setUserName(cursor.getString(1));
                    item.setPhoneNum(cursor.getString(2));
                    item.setDescription(cursor.getString(3));
                    item.setDate(cursor.getString(4));
                    item.setLocation(cursor.getString(5));
                    return item;
                }
            } while (cursor.moveToNext());
        }
        return item;
    }

    public List<Item> fetchAllItems(){
        List<Item> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = " SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        if(cursor.moveToFirst()){
            do {
                Item item = new Item();
                //item.setUserId(cursor.getInt(0));
                item.setUserName(cursor.getString(1));
                item.setPhoneNum(cursor.getString(2));
                item.setDate(cursor.getString(3));
                item.setDescription(cursor.getString(4));
                item.setLocation(cursor.getString(5));
                itemList.add(item);


            }while (cursor.moveToNext());
        }
        return itemList;
    }

    public void removeItem(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,Util.USER_ID + " = " + i,null);
    }
}
