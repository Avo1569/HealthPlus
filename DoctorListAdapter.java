package com.example.healthplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DoctorListAdapter extends ArrayAdapter<DoctorListData> {

    public DoctorListAdapter(@NonNull Context context, ArrayList<DoctorListData> dataArrayList) {
        super(context, R.layout.doctor_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        DoctorListData doctorListData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.doctor_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.doctorImage);
        TextView listName = view.findViewById(R.id.doctorName);
        TextView listSpecs = view.findViewById(R.id.specs);

        listImage.setImageResource(doctorListData.image);
        listName.setText(doctorListData.name);
        listSpecs.setText(doctorListData.specs);


        return view;

    }
}
