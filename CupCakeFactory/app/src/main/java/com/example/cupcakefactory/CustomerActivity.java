package com.example.cupcakefactory;


import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cupcakefactory.fragment.CustomerDashboardFragment;
import com.example.cupcakefactory.fragment.CustomerCartFragment;
import com.example.cupcakefactory.fragment.CustomerUserInfoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.*;

public class CustomerActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        bottomNavigationView
                = findViewById(R.id.bottom_customer_navigation);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.customer_home);
    }

    CustomerCartFragment customerCartFragment = new CustomerCartFragment();
    CustomerDashboardFragment customerDashboardFragment = new CustomerDashboardFragment();
    CustomerUserInfoFragment customerUserInfoFragment = new CustomerUserInfoFragment();


    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId()) {
            case R.id.customer_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.customer_fragment_container, customerDashboardFragment)
                        .commit();
                return true;

            case R.id.customer_cart:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.customer_fragment_container,customerCartFragment)
                        .commit();
                return true;

            case R.id.customer_profile:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.customer_fragment_container, customerUserInfoFragment)
                        .commit();
                return true;

        }
        return false;
    }
}

