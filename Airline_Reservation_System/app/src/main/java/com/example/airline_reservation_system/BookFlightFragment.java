package com.example.airline_reservation_system;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BookFlightFragment extends Fragment {

    Button OneWay;
    Button RoundTrip;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BookFlightFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BookFlightFragment newInstance(String param1, String param2) {
        BookFlightFragment fragment = new BookFlightFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_flight, container, false);
        //show default oneway fragment
        getFragmentManager().beginTransaction().replace(R.id.bottomFragment,new OneWayFragment()).commit();

        //declare two button by their id's

        OneWay = view.findViewById(R.id.OnewayBtn);
        RoundTrip = view.findViewById(R.id.roundTripBtn);

        // select OneWat Btn
        OneWay.setBackgroundResource(R.color.LightRed);
        RoundTrip.setBackgroundResource(R.color.Transparent);


        //
        //for oneWay Btn
        //
        OneWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    OneWay.setBackgroundResource(R.color.LightRed);
                    RoundTrip.setBackgroundResource(R.color.Transparent);
                 getFragmentManager().beginTransaction().replace(R.id.bottomFragment,new OneWayFragment()).commit();
            }
        });
        //
        // For RoundTrip btn
        //
        RoundTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneWay.setBackgroundResource(R.color.Transparent);
                RoundTrip.setBackgroundResource(R.color.LightRed);
                getFragmentManager().beginTransaction().replace(R.id.bottomFragment,new RoundTripFragment()).commit();
            }
        });

        return  view;
    }
}