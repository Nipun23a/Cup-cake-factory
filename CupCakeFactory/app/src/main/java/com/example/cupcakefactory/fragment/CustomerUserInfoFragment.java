package com.example.cupcakefactory.fragment;




import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cupcakefactory.R;

public class CustomerUserInfoFragment extends Fragment {

    public CustomerUserInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_customer_info, container, false);
    }
}