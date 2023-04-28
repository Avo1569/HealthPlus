package com.example.healthplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.example.healthplus.databinding.ActivityAppointmentsPageBinding;

import java.util.ArrayList;

public class AppointmentsPage extends AppCompatActivity {
    //For Appointment list items
    @NonNull ActivityAppointmentsPageBinding binding;
    ListAdapter listAdapter;
    ArrayList<DoctorListData> dataArrayList = new ArrayList<>();
    DoctorListData doctorListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppointmentsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.doctor1, R.drawable.doctor2, R.drawable.doctor3, R.drawable.doctor4, R.drawable.doctor5, R.drawable.doctor6, R.drawable.doctor7};
        int[] educationList = {R.string.doc1Education,R.string.doc2Education, R.string.doc3Education, R.string.doc4Education, R.string.doc5Education, R.string.doc6Education, R.string.doc7Education};
        int[] priceList = {R.string.doc1Price, R.string.doc2Price, R.string.doc3Price, R.string.doc4Price, R.string.doc5Price, R.string.doc6Price, R.string.doc7Price};
        int[] specialityList = {R.string.doc1Speciality, R.string.doc2Speciality, R.string.doc3Speciality, R.string.doc4Speciality, R.string.doc5Speciality, R.string.doc6Speciality, R.string.doc7Speciality };
        String[] nameList = {"Dr. Narayan Swami", "Dr. Girish Chandra", "Dr. Neha Wasnaik", "Dr. Shreya Bhatt", "Dr. Sandeep Waishya", "Dr. Rakesh Tandon", "Dr. Parul Sony"};
        String[] specsList = {"NS", "C", "OS", "C", "NS", "NS", "OS"};

        for (int i= 0; i < imageList.length;i++){
            doctorListData = new DoctorListData(nameList[i], specsList[i],specialityList[i], priceList[i], educationList[i], imageList[i] );
            dataArrayList.add(doctorListData);
        }
        listAdapter = new DoctorListAdapter(AppointmentsPage.this, dataArrayList);
        binding.doctorListView.setAdapter(listAdapter);
        binding.doctorListView.setClickable(true);

        binding.doctorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AppointmentsPage.this, DoctorDetails.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("specs", specsList[i]);
                intent.putExtra("speciality", specialityList[i]);
                intent.putExtra("price", priceList[i]);
                intent.putExtra("education", educationList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });

    }
}