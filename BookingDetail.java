package com.example.healthplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookingDetail extends AppCompatActivity {

    TextView detailName, detailDate, detailTime;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        detailImage = findViewById(R.id.detailImage);
        detailName = findViewById(R.id.detailName);
        detailDate = findViewById(R.id.detailDate);
        detailTime = findViewById(R.id.detailTime);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailDate.setText(bundle.getString("Date"));
            detailName.setText(bundle.getString("Name"));
            detailTime.setText(bundle.getString("Time"));
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
    }
}