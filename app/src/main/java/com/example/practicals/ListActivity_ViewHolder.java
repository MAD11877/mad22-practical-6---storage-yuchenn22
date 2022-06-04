package com.example.practicals;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListActivity_ViewHolder extends RecyclerView.ViewHolder {
    TextView Name;
    TextView Description;
    ImageView Image;
    public ListActivity_ViewHolder(View viewItem){
        super (viewItem);
        Name = viewItem.findViewById(R.id.name);
        Description = viewItem.findViewById(R.id.description);
        Image = viewItem.findViewById(R.id.logo);

    }
}
