package com.example.healthplus;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.healthplus.databinding.ActivityDoctorDetailsBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DoctorDetails extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference reference;
    FloatingActionButton fab;
    private AppBarConfiguration appBarConfiguration;
    private ActivityDoctorDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityDoctorDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String specs = intent.getStringExtra("specs");
            int speciality = intent.getIntExtra("speciality", R.string.doc1Speciality);
            int education = intent.getIntExtra("education", R.string.doc1Education);
            int price = intent.getIntExtra("price", R.string.doc1Price);
            int image = intent.getIntExtra("image", R.drawable.doctor1);

            binding.docName.setText(name);
            binding.docSpeciality.setText(speciality);
            binding.docEducation.setText(education);
            binding.docPrice.setText(price);
            binding.docImage.setImageResource(image);

        }
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorDetails.this, BookAppointment.class);
                startActivity(intent);
            }
        });



    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_doctor_details);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}