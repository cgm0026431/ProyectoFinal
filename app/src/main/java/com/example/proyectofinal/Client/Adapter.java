package com.example.proyectofinal.Client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Usuarios> listaVehiculos;

    public Adapter(ArrayList<Usuarios> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    //En este metodo vamos a enlazar el apadaptador con el formato de vehiculo
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_adapter,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.asignarDatos(listaVehiculos.get(position));

    }

    @Override
    public int getItemCount() {
        return listaVehiculos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPlaca,tvColor,tvModelo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlaca = itemView.findViewById(R.id.tvPlaca);
            tvColor = itemView.findViewById(R.id.tvColor);
            tvModelo = itemView.findViewById(R.id.tvModelo);
        }

        public void asignarDatos(Usuarios vehiculo) {
            tvPlaca.setText("Nombre: "+vehiculo.getNombre());
            tvColor.setText("Mes: "+vehiculo.getMes());
            tvModelo.setText("Año : "+vehiculo.getAnio());
        }
    }




}
