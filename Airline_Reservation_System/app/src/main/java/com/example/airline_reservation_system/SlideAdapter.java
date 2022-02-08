package com.example.airline_reservation_system;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SlideAdapter  extends SliderViewAdapter<SlideAdapter.Holder>{


    int[] images;

    public SlideAdapter(int[] images){

        this.images = images;

    }

    @Override
    public SlideAdapter.Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slide_items,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SlideAdapter.Holder viewHolder, int position) {
        viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends  SliderViewAdapter.ViewHolder{

        ImageView imageView;

        public Holder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);

        }
    }
}
