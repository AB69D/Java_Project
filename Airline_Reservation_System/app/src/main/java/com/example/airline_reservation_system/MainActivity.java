package com.example.airline_reservation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

     BottomNavigationView navbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //default home page
        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new HomeFragment()).commit();
        navbar = (BottomNavigationView)findViewById(R.id.bottom_navBar);
        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment temp = null;
                    switch (item.getItemId())
                    {
                        case R.id.home_menu: temp = new HomeFragment();
                            break;
                        case R.id.search_menu: temp = new BookFlightFragment();
                            break;
                        case R.id.myTrip_menu: temp = new myTripFragment();
                            break;
                        case R.id.flightStatus_menu: temp = new FlightStatusFragment();
                            break;
                        case R.id.More_menu: temp = new OthersFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, temp).commit();
                    return true;
            }
        });

    }
}