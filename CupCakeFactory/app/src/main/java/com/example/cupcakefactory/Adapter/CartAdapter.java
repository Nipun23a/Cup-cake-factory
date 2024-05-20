package com.example.cupcakefactory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.cupcakefactory.R;
import com.example.cupcakefactory.entity.CartItem;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> itemList;
    private Context context;

    // Constructor to initialize the adapter with the list of items
    public CartAdapter(List<CartItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    // ViewHolder class to hold the views for each item in the RecyclerView
    static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView, quantityTextView, priceTextView;
        ImageView itemImageView;
        Button btnMinus, btnPlus;

        public CartViewHolder(View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.item_name);
            quantityTextView = itemView.findViewById(R.id.quantity);
            priceTextView = itemView.findViewById(R.id.price);
            itemImageView = itemView.findViewById(R.id.item_image);
            btnMinus = itemView.findViewById(R.id.btn_minus);
            btnPlus = itemView.findViewById(R.id.btn_plus);
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        // Get the item at the given position
        CartItem cartItem = itemList.get(position);

        // Set item name, quantity, and price to the respective TextViews
        holder.itemNameTextView.setText(cartItem.getItemName());
        holder.quantityTextView.setText(String.valueOf(cartItem.getQuantity()));
        holder.priceTextView.setText(String.valueOf(cartItem.getPrice()));

        // Load item image using Glide
        Glide.with(context)
                .load(cartItem.getImageUrl()) // Use the image URL or file path from the item object
                .placeholder(R.drawable.placeholder_image) // Placeholder image
                .into(holder.itemImageView);

        // Button click listeners to handle quantity adjustments
        holder.btnMinus.setOnClickListener(view -> {
            int quantity = cartItem.getQuantity();
            if (quantity > 0) {
                cartItem.setQuantity(quantity - 1);
                notifyDataSetChanged();
            }
        });

        holder.btnPlus.setOnClickListener(view -> {
            int quantity = cartItem.getQuantity();
            cartItem.setQuantity(quantity + 1);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

