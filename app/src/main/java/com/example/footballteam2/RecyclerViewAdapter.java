package com.example.footballteam2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {

    private ArrayList<RecyclerViewUser> arrayList;
    static boolean[] checked;
    Context context;

    public RecyclerViewAdapter(ArrayList<RecyclerViewUser> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        checked = new boolean[arrayList.size()];
    }


    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivFotoUser;
        public TextView tvNameUser;
        public TextView tvPosition;
        public CheckBox checkBox;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoUser = itemView.findViewById(R.id.iv_foto_user);
            tvNameUser = itemView.findViewById(R.id.tv_name_user);
            tvPosition = itemView.findViewById(R.id.tv_position);
            checkBox = itemView.findViewById(R.id.checkBox);
            //itemView.setOnClickListener(this);
        }
    }

    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                parent, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);

        return recyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder holder, final int position) {
        RecyclerViewUser recyclerViewUser = arrayList.get(position);

        holder.ivFotoUser.setImageResource(recyclerViewUser.getImageUser());
        holder.tvNameUser.setText(recyclerViewUser.getNameUser());
        holder.tvPosition.setText(recyclerViewUser.getPosition());
        holder.checkBox.setChecked(checked[position]);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checked[position] = !checked[position];

            }
        });
    }



     static class Barr {
        static boolean[] getChecked() {

            return checked;
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
