package com.example.airline_reservation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registration extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://airline-reservation-syst-8b409-default-rtdb.firebaseio.com/");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

//        final  EditText  name = findViewById(R.id.fullNameEditTextView);
        final EditText name = findViewById(R.id.fullNameEditTextView);
        final EditText SignupUsername = findViewById(R.id.userNameEditTextView);
        final EditText email = findViewById(R.id.EmailEditText);
        final EditText Mobile = findViewById(R.id.PhoneEditText);
        final EditText nid = findViewById(R.id.NidEditText);
        final EditText SignUpPassword = findViewById(R.id.PasswordEditText);
        final EditText conPassword = findViewById(R.id.conPasswordEditText);

        final Button SignUpBtn = findViewById(R.id.registerBtn);
        final TextView LoginTextBtn = findViewById(R.id.LoginBtnText);


        SignUpBtn.setOnClickListener(v -> {
            final String nameText = name.getText().toString().trim();
            final String SignUpUserNameText = SignupUsername.getText().toString().trim();
            final String emailText = email.getText().toString().trim();
            final String mobileText = Mobile.getText().toString().trim();
            final String nidText = nid.getText().toString().trim();
            final String signUp_password = SignUpPassword.getText().toString().trim();
            final String Confirm_password = conPassword.getText().toString().trim();

            if (nameText.isEmpty() || SignUpUserNameText.isEmpty() || emailText.isEmpty() || signUp_password.isEmpty()){
                Toast.makeText(registration.this, "Fill up all data", Toast.LENGTH_SHORT).show();
            }
            else if (!signUp_password.equals(Confirm_password)) {
//                Toast.makeText(registration.this, "password is not match", Toast.LENGTH_SHORT).show();
                SignUpPassword.setError("password is not match");
                SignUpPassword.requestFocus();
            } else {

                databaseReference.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(SignUpUserNameText)){
                            SignupUsername.setError(" This username already exist");
                            SignupUsername.requestFocus();
                        }
                        else
                        {
                            //databaseReference.child("User").child(SignUpUserNameText).child("UserName").setValue(SignUpUserNameText);
//                            databaseReference.child("User").child(SignUpUserNameText).child("Email").setValue(emailText)
                            databaseReference.child("User").child(SignUpUserNameText).child("Email").setValue(emailText);
                            databaseReference.child("User").child(SignUpUserNameText).child("Password").setValue(signUp_password);
                            databaseReference.child("User").child(SignUpUserNameText).child("Name").setValue(nameText);
                            databaseReference.child("User").child(SignUpUserNameText).child("Mobile").setValue(mobileText);
                            databaseReference.child("User").child(SignUpUserNameText).child("NID").setValue(nidText);



                            Toast.makeText(registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });
        LoginTextBtn.setOnClickListener(this::onClick);


    }

    private void onClick(View v) {
        startActivity(new Intent(registration.this, login.class));
    }
}
