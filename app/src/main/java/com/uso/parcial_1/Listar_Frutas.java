package com.uso.parcial_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listar_Frutas extends AppCompatActivity {
    private ListView ListaAlimentos;
    private ArrayList<String> ListALimentos = new ArrayList<>();
    public static final String AlimentoS = "AlimentoS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__frutas);
        this.ListaAlimentos = findViewById(R.id.ldListaAlimentos);
        //cargamos La lista
        this.ListALimentos.add("Leche");
        this.ListALimentos.add("Verduras");
        this.ListALimentos.add("Carnes");
        this.ListALimentos.add("Mariscos");
        this.ListALimentos.add("Ensaladas");
        this.ListALimentos.add("Cereales");
        this.ListALimentos.add("Legumbres");
        this.ListALimentos.add("Huevos");
        this.ListALimentos.add("Azucar");
        this.ListALimentos.add("Frutos Secos");
        this.ListALimentos.add("Pescado");
        this.ListALimentos.add("Dulces");
        this.ListALimentos.add("Leche");
        this.ListALimentos.add("Café");
        this.ListALimentos.add("Pastas");
        this.ListALimentos.add("Tacos");
        this.ListALimentos.add("Churros");
        this.ListALimentos.add("Pan Frances");

        //Agregamos la data al ListView
        this.ListaAlimentos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.ListALimentos));
        //Seleccion de la lista
        this.ListaAlimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valueSelected = ListaAlimentos.getItemAtPosition(position).toString();
                Intent msg_response = new Intent();
                msg_response.putExtra(AlimentoS,valueSelected);
                setResult(RESULT_OK,msg_response);
                Toast.makeText(Listar_Frutas.this, "Selección Guardada..", Toast.LENGTH_SHORT).show();
                finish();
            }
        });





    }


}