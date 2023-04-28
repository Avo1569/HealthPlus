package com.example.healthplus;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link HomeFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class HomeFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        Button buyMedicine = (Button) v.findViewById(R.id.buyButton);

        buyMedicine.setOnClickListener(this);
        return v;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buyButton:
                Intent intent = new Intent(getActivity(), BuyMedicineActivity.class);
                startActivity(intent);
                break;

        }


    }


}