package com.example.actividad_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> cartItems = new ArrayList<>();
        cartItems.add("Producto 1");
        cartItems.add("Producto 2");
        cartItems.add("Producto 3");
        cartItems.add("Producto 4");
        cartItems.add("Producto 5");

        CartAdapter adapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(adapter);

        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, ProductListActivity.class);
            startActivity(intent);
            finish();
        });
    }
}