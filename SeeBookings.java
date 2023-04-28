package com.example.healthplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SeeBookings extends AppCompatActivity {
    RecyclerView recyclerView;
    List<BookingDataClass> bookingDataList;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    MyAdapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_bookings);

        recyclerView = findViewById(R.id.bookedAppts);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(SeeBookings.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        AlertDialog.Builder builder = new AlertDialog.Builder(SeeBookings.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();


        bookingDataList = new ArrayList<>();

        MyAdapter adapter = new MyAdapter(SeeBookings.this, bookingDataList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Bookings Made");
        dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bookingDataList.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    BookingDataClass bookingDataClass = itemSnapshot.getValue(BookingDataClass.class);
                    bookingDataList.add(bookingDataClass);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                dialog.dismiss();
            }
        });
    }
}