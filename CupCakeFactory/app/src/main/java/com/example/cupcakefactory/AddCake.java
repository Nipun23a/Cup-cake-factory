package com.example.cupcakefactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cupcakefactory.entity.Cake;
import com.example.cupcakefactory.entity.User;

public class AddCake extends AppCompatActivity {

private EditText etCakeName,etCakeQuantity,etCakePrice;
private Button  addNewCakeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcake);

        etCakeName = findViewById(R.id.cakeNameEditText);
        etCakeQuantity = findViewById(R.id.cakeQuantityEditText);
        etCakePrice = findViewById(R.id.cakePriceEditText);
        addNewCakeButton = findViewById(R.id.addCakeButton);

        addNewCakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cakeName = etCakeName.getText().toString().trim();
                String cakeQuantity = etCakeQuantity.getText().toString().trim();
                String cakePrice= etCakePrice.getText().toString().trim();

                if (cakeName.isEmpty() || cakeQuantity.isEmpty() || cakePrice.isEmpty()) {
                    Toast.makeText(AddCake.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Cake cake= new Cake(cakeName, cakeQuantity, cakePrice);
                    cake.addCake(cake);
                    Toast.makeText(AddCake.this, "Cake Added Succefully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddCake.this, LoginActivity.class));
                    finish();
                }
            }
        });
    }
}
