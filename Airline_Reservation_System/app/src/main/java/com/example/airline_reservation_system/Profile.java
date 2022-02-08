package com.example.airline_reservation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    EditText name, email, phone, nid;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference("User");
    String textEmail;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        textEmail = intent.getStringExtra("Email");

        name = findViewById(R.id.pNameTextView);
        email = findViewById(R.id.pEmailTextView);
        phone = findViewById(R.id.pPhoneTextView);
        nid = findViewById(R.id.pNidTextView);

//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot ds : snapshot.getChildren()){
//                        if(ds.child("Email").getValue().equals(textEmail)){
//                            name.setText(ds.child("Name").getValue(String.class));
//                            name.setText(textEmail);
//                            name.setText(ds.child("Mobile").getValue(String.class));
//                            name.setText(ds.child("NID").getValue(String.class));
//                        }
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


    }
}