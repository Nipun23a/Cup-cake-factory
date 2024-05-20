package com.example.cupcakefactory;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the cupcakeContainer LinearLayout
        LinearLayout cupcakeContainer = findViewById(R.id.cupcakeContainer);

        // Sample cupcake data (you should replace this with your actual cupcake data)
        String[] cupcakeNames = {"Red Velvet", "Chocolate", "Vanilla"};
        String[] cupcakeCategories = {"Classic", "Chocolate", "Vanilla"};
        double[] cupcakePrices = {3.99, 4.49, 3.49};

        // Loop through the cupcake data and add containers for each cupcake
        for (int i = 0; i < cupcakeNames.length; i++) {
            // Create a new container for the cupcake information
            LinearLayout cupcakeInfoContainer = new LinearLayout(this);
            cupcakeInfoContainer.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cupcakeInfoContainer.setOrientation(LinearLayout.VERTICAL);

            // Create TextViews for cupcake name, category, and price
            TextView cupcakeNameTextView = new TextView(this);
            cupcakeNameTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cupcakeNameTextView.setText("Name: " + cupcakeNames[i]);
            cupcakeInfoContainer.addView(cupcakeNameTextView);

            TextView cupcakeCategoryTextView = new TextView(this);
            cupcakeCategoryTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cupcakeCategoryTextView.setText("Category: " + cupcakeCategories[i]);
            cupcakeInfoContainer.addView(cupcakeCategoryTextView);

            TextView cupcakePriceTextView = new TextView(this);
            cupcakePriceTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cupcakePriceTextView.setText("Price: $" + cupcakePrices[i]);
            cupcakeInfoContainer.addView(cupcakePriceTextView);

            // Add the cupcake information container to the main cupcakeContainer
            cupcakeContainer.addView(cupcakeInfoContainer);
        }
    }
}
