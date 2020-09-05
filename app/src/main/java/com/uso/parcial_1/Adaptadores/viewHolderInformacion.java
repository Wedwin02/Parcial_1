package com.uso.parcial_1.Adaptadores;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uso.parcial_1.R;

public class viewHolderInformacion extends RecyclerView.ViewHolder {
    private TextView lblNombre;
    private  TextView lblEdad;
    private TextView lblAlimento;

    public viewHolderInformacion(@NonNull View itemView) {
        super(itemView);
        this.lblNombre = itemView.findViewById(R.id.lblvNombre);
        this.lblEdad = itemView.findViewById(R.id.lblvEdad);
        this.lblAlimento = itemView.findViewById(R.id.lblvAlimento);
    }

    public TextView getLblNombre() {
        return lblNombre;
    }

    public TextView getLblEdad() {
        return lblEdad;
    }

    public TextView getLblAlimento() {
        return lblAlimento;
    }
}
