package com.example.airline_reservation_system;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneWayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneWayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OneWayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneWayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneWayFragment newInstance(String param1, String param2) {
        OneWayFragment fragment = new OneWayFragment();
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
    //
    // declaring buttons
    //
    LinearLayout OneWayFromBtn,OneWayToBtn;
    Button OneWayDateBtn, OneWayCabinBtn,OneWaySearchBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_way, container, false);
            OneWayFromBtn = view.findViewById(R.id.OneWayFromBtn);
            OneWayToBtn = view.findViewById(R.id.OneWayToBtn);
            OneWaySearchBtn = view.findViewById(R.id.OneWaySearchBtn);

            OneWayFromBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(),FromCity.class));
                }
            });

            OneWayToBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(),ToCity.class));
                }
            });

            OneWaySearchBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(),FlightInfo.class));
                }
            });
        return view;
    }
}