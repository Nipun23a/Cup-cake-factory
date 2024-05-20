package com.example.cupcakefactory.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupcakefactory.R;

public class CustomerDashboardFragment extends Fragment {

    public CustomerDashboardFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customer_dashboard, container, false);
    }
}
