package com.example.gonzaga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gonzaga.data.DatabaseHandler;
import com.example.gonzaga.model.Product;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Product product = new Product();

        product.setName("I Phone");
        product.setPrice((long)3000.15);
        product.setQuantity(10);

        db.addProduct(product);
    }
}