package com.example.nikehealth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptadorimc extends RecyclerView.Adapter<adaptadorimc.ViewHolderIMC>{

    ArrayList<String> ListDatos;

    public adaptadorimc(ArrayList<String> listDatos) {
        ListDatos = listDatos;
    }


    @NonNull
    @Override
    public adaptadorimc.ViewHolderIMC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderIMC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorimc.ViewHolderIMC holder, int position) {
        holder.asignarDatos(ListDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return ListDatos.size();
    }

    public class ViewHolderIMC extends RecyclerView.ViewHolder {

        TextView dato;

        public ViewHolderIMC(@NonNull View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.datos);
        }

        public void asignarDatos(String s) {
            dato.setText(s);
        }

    }
}
