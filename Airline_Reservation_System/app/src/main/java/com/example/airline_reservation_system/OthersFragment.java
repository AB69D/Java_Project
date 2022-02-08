package com.example.airline_reservation_system;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URISyntaxException;
import java.util.Objects;


public class OthersFragment extends Fragment {
    //
    //connect to database path
    //

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://airline-reservation-syst-8b409-default-rtdb.firebaseio.com/").child("User");
    //
    // create TextView
    //
    TextView nameText, emailText;
    String name;
    Button logout;
    LinearLayout myProfileBtn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_others, container, false);
            myProfileBtn = view.findViewById(R.id.myProfileBtn);
            logout = view.findViewById(R.id.LogoutBtn);

            myProfileBtn.setOnClickListener(v->{
                startActivity(new Intent(getContext(),Profile.class));
            });

            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(),login.class));
                }
            });


        return view;
    }
}
// name = snapshot.child("Name").getValue(String.class);
//        for (DataSnapshot ds : snapshot.getChildren())
//        {
//        if (ds.child("Name").getValue().equals(name))
//        {
//
//        }
//        }