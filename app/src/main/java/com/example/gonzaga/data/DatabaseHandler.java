package com.example.gonzaga.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.gonzaga.R;
import com.example.gonzaga.model.Product;
import com.example.gonzaga.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PRODUCT = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY,"
                + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PRICE + " DOUBLE,"
                + Util.KEY_QUANTITY + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf(R.string.drop_table);
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
    }


    //CREATE

    public void addProduct(Product product)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, product.getName());
        values.put(Util.KEY_PRICE, product.getPrice());
        values.put(Util.KEY_QUANTITY, product.getQuantity());

        db.insert(Util.TABLE_NAME, null, values);
        db.close();
    }
    //RETRIEVE

    //UPDATE

    //DELETE
}
