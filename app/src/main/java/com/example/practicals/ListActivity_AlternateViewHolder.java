package com.example.practicals;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListActivity_AlternateViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    public ListActivity_AlternateViewHolder(View viewItem){
        super(viewItem);
        image=viewItem.findViewById(R.id.imageView3);
    }
}