package com.example.cupcakefactory;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cupcakefactory.entity.Category;
import com.example.cupcakefactory.entity.User;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private static ArrayList<Category> categoryArrayList  = new ArrayList<>();
    private EditText categoryName;
    private Button addCategoryButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategory);

        categoryName = findViewById(R.id.etCategoryName);
        addCategoryButton = findViewById(R.id.btnAddCategory);
        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = categoryName.getText().toString().trim();
                if (category.isEmpty()) {
                    Toast.makeText(CategoryActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Category category1 = new Category(category);
                    categoryArrayList.add(category1);
                    Toast.makeText(CategoryActivity.this, "Category Created Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
