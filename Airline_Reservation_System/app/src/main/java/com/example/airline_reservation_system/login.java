package com.example.airline_reservation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://airline-reservation-syst-8b409-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.LoginNameEditTextView);
        final EditText password = findViewById(R.id.LoginPasswordEditText);

        final Button LoginBtn = findViewById(R.id.LoginBtn);
        final TextView registerTextViewBtn = findViewById(R.id.createAccountBtnText);

        LoginBtn.setOnClickListener(v -> {
            final String userNameText = username.getText().toString().trim();
            final String passwordText = password.getText().toString().trim();

            if (userNameText.isEmpty() || passwordText.isEmpty())
            {
//                Toast.makeText(login.this, "Enter Your Username or Password", Toast.LENGTH_SHORT).show();
                username.setError("Enter your username address");
                username.requestFocus();
                password.setError("Enter your Password address");
                password.requestFocus();
            }
            else
            {

                databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(userNameText))
                        {
                            final String getPassword = snapshot.child(userNameText).child("Password").getValue(String.class);

                            if(getPassword.equals(passwordText))
                            {
                                Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(login.this,MainActivity.class));
                                finish();
                            }
                            else
                            {
                                password.setError("Wrong Password");
                                password.requestFocus();
                            }
                        }
                        else
                        {
                            username.setError("Wrong Username");
                            username.requestFocus();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        registerTextViewBtn.setOnClickListener(v -> startActivity(new Intent(login.this,registration.class)));



    }
}