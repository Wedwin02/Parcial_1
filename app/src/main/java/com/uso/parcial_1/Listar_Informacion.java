package com.uso.parcial_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uso.parcial_1.Adaptadores.AdaptadorInformacion;
import com.uso.parcial_1.Adaptadores.Encuestado;

import java.lang.reflect.Type;
import java.security.KeyRep;
import java.util.ArrayList;
import java.util.List;

public class Listar_Informacion extends AppCompatActivity {
    private List<Encuestado> ListaEncuestado = new ArrayList<Encuestado>();
    private RecyclerView Lista;
    private AdaptadorInformacion Adaptador;
    private LinearLayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__informacion);
        //Recibimos los datos
        Intent a = getIntent();
        String DatosLista = a.getStringExtra("DatosLista");
        Gson gn = new Gson();
        Type type =  new TypeToken<ArrayList<Encuestado>>(){}.getType();
        ArrayList<Encuestado>items = gn.fromJson(DatosLista,type);
        this.ListaEncuestado = items;



        //
        this.Lista = findViewById(R.id.RCV);
        this.manager = new  LinearLayoutManager(this);
        this.Adaptador= new AdaptadorInformacion(ListaEncuestado);

        //Configurar

        this.Lista.setHasFixedSize(true);
        this.Lista.setLayoutManager(manager);
        this.Lista.setAdapter(Adaptador);

    }



}