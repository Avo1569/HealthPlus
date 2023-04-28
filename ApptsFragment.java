package com.example.healthplus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ApptsFragment extends Fragment implements View.OnClickListener {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,     Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_appts, container, false);
        FloatingActionButton addAppt = (FloatingActionButton) v.findViewById(R.id.addAppt);
        Button seeAppts = (Button) v.findViewById(R.id.seeAppts);

        seeAppts.setOnClickListener(this);
        addAppt.setOnClickListener(this);
        return v;
    }


            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.addAppt:
                Intent intent = new Intent(getActivity(), AppointmentsPage.class);
                startActivity(intent);
                break;
                    case R.id.seeAppts:
                        Intent intent1 = new Intent(getActivity(), SeeBookings.class);
                startActivity(intent1);
                break;
            }
        }


    }
