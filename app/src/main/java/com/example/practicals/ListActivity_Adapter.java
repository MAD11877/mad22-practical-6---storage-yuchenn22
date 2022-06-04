package com.example.practicals;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity_Adapter extends RecyclerView.Adapter<ListActivity_ViewHolder> {
    ArrayList<String> Name;
    ArrayList<String> Description;
    ListActivity activity;
    public ListActivity_Adapter(ArrayList<String>Name,ArrayList<String>Description,ListActivity activity){
        this.Name=Name;
        this.Description=Description;
        this.activity=activity;
    }
    @NonNull
    @Override
    public ListActivity_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item=null;
        if(viewType==0)
            item= LayoutInflater.from(parent.getContext()).inflate(R.layout.listactivity_alternatercv,parent,false);
        else
            item= LayoutInflater.from(parent.getContext()).inflate(R.layout.listactivity_rcv,null,false);

        return new ListActivity_ViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        String n = Name.get(position);
        if (n.contains("7"))
            if(n.indexOf("7")+1==n.length())
                return 0;
            else
                return 1;

        else
            return 1;

    }

    @Override
    public void onBindViewHolder(@NonNull ListActivity_ViewHolder holder, int position) {
        String n=Name.get(position);
        holder.Name.setText(n);
        String d=Description.get(position);
        holder.Description.setText(d);
        holder.Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(activity);
                ad.setTitle("Profile");
                ad.setMessage(n);
                ad.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Bundle bundle = new Bundle();
                        bundle.putString("name", n);
                        bundle.putString("desc", d);
                        Intent intent=new Intent(activity,MainActivity.class);
                        intent.putExtras(bundle);
                        activity.startActivity(intent);
                    }
                });
                ad.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                ad.show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return Name.size();
    }
}
