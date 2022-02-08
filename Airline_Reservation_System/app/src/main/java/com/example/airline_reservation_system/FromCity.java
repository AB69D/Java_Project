package com.example.airline_reservation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FromCity extends AppCompatActivity {

    RecyclerView recyclerView ;
    DatabaseReference databaseReference;
    FromcityAdapter fromcityAdapter;
    ArrayList<FromCityModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_city);

        recyclerView = findViewById(R.id.FromOneWayRecycleView);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("From_Airport_City");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        fromcityAdapter = new FromcityAdapter(this,list);
        recyclerView.setAdapter(fromcityAdapter);

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull  DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot: snapshot.getChildren() )
//                {
//                    FromCityModel fromcitymodel = dataSnapshot.getValue(FromCityModel.class);
//                    list.add(fromcitymodel);
//                }
//
//                fromcityAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull  DatabaseError error) {
//
//            }
//        });

    }

}