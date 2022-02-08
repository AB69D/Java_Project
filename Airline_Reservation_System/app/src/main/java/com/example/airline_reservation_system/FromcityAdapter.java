package com.example.airline_reservation_system;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FromcityAdapter extends RecyclerView.Adapter<FromcityAdapter.fromCityHolder>
{
    Context context;
    ArrayList<FromCityModel> list;

    public FromcityAdapter(Context context, ArrayList<FromCityModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public fromCityHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_city,parent,false);
        return new fromCityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fromCityHolder holder, int position) {
        FromCityModel fromCityModel = list.get(position);
        holder.FromCityName.setText(fromCityModel.getFromCityName());
        holder.FromAirportName.setText(fromCityModel.getFromAirport());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class fromCityHolder extends RecyclerView.ViewHolder
    {
        TextView FromAirportName, FromCityName;
        public fromCityHolder(@NonNull View itemView) {
            super(itemView);
            FromCityName = itemView.findViewById(R.id.CityNameTextView);
            FromAirportName = itemView.findViewById(R.id.AirportName);


        }
    }
}
