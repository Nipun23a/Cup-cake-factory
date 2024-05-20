package com.example.cupcakefactory;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerInfoActivity extends AppCompatActivity {

    private TextView customerNameTextView;
    private TextView joinDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        customerNameTextView = findViewById(R.id.customerNameTextView);
        joinDateTextView = findViewById(R.id.joinDateTextView);

        // For demonstration purposes, set customer name and join date directly.
        // In a real application, you would retrieve this data from a database or an API.
        String customerName = "John Doe";
        String joinDate = "Joined: January 1, 2020";

        customerNameTextView.setText(customerName);
        joinDateTextView.setText(joinDate);
    }

    public void signOut(View view) {
        // Handle sign out logic here
        // For demonstration, we just show a toast and navigate back to the main activity
        Toast.makeText(this, "Signed out", Toast.LENGTH_SHORT).show();

        // Redirect to the main activity (or login activity)
        Intent intent = new Intent(CustomerInfoActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Close the current activity
    }
}
