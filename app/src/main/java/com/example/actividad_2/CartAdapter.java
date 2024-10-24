package com.example.actividad_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private final List<String> cartItems;
    private final int[] quantities;

    public CartAdapter(List<String> cartItems) {
        this.cartItems = cartItems;
        this.quantities = new int[cartItems.size()];
        Arrays.fill(quantities, 1);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productName.setText(cartItems.get(position));
        holder.quantity.setText(String.valueOf(quantities[position]));

        holder.buttonIncrease.setOnClickListener(v -> {
            quantities[position]++;
            holder.quantity.setText(String.valueOf(quantities[position]));
        });

        holder.buttonDecrease.setOnClickListener(v -> {
            if (quantities[position] > 1) {
                quantities[position]--;
                holder.quantity.setText(String.valueOf(quantities[position]));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView quantity;
        Button buttonIncrease;
        Button buttonDecrease;

        ViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            quantity = itemView.findViewById(R.id.quantity);
            buttonIncrease = itemView.findViewById(R.id.button_increase);
            buttonDecrease = itemView.findViewById(R.id.button_decrease);
        }
    }
}