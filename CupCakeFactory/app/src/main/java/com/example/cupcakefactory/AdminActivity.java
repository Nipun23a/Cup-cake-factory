package com.example.cupcakefactory;


import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cupcakefactory.fragment.AdminCategoryFragment;
import com.example.cupcakefactory.fragment.AdminDashboardFragment;
import com.example.cupcakefactory.fragment.AdminInfoFragment;
import com.example.cupcakefactory.fragment.AdminOrdersFragment;
import com.example.cupcakefactory.fragment.AdminProductFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.*;

public class AdminActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        bottomNavigationView
                = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.admin_dashboard);
    }

    AdminDashboardFragment adminDashboardFragment = new AdminDashboardFragment();
    AdminCategoryFragment adminCategoryFragment = new AdminCategoryFragment();
    AdminInfoFragment adminInfoFragment = new AdminInfoFragment();
    AdminOrdersFragment adminOrdersFragment = new AdminOrdersFragment();
    AdminProductFragment adminProductsFragment = new AdminProductFragment();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId()) {
            case R.id.admin_dashboard:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.admin_fragment_container, adminDashboardFragment)
                        .commit();
                return true;

            case R.id.admin_orders:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.admin_fragment_container,adminOrdersFragment)
                        .commit();
                return true;

            case R.id.admin_category:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.admin_fragment_container, adminCategoryFragment)
                        .commit();
                return true;
            case R.id.admin_products:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.admin_fragment_container, adminProductsFragment)
                        .commit();
                return true;
            case R.id.admin_user:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.admin_fragment_container, adminInfoFragment)
                        .commit();
                return true;


        }
        return false;
    }
}

