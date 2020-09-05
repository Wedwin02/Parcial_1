package com.uso.parcial_1.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uso.parcial_1.R;

import java.util.List;

public class AdaptadorInformacion extends RecyclerView.Adapter<viewHolderInformacion> {
    private List<Encuestado> ListaEncuestado;

    public AdaptadorInformacion(List<Encuestado> data){
        this.ListaEncuestado = data;
    }

    @NonNull
    @Override
    public viewHolderInformacion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creamos los item de la vista
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_informacion,parent,false);
        viewHolderInformacion vhi = new viewHolderInformacion(vista);
        return vhi;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderInformacion holder, int position) {
        //uniendo el vhi con la data
        holder.getLblNombre().setText(this.ListaEncuestado.get(position).getNombre());
        holder.getLblEdad().setText(this.ListaEncuestado.get(position).getEdad());
        holder.getLblAlimento().setText(this.ListaEncuestado.get(position).getAlimento());

    }

    @Override
    public int getItemCount() {
        return this.ListaEncuestado.size();
    }
}
