package com.uso.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.uso.parcial_1.Adaptadores.Encuestado;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnNuevo, BtnLista;
    List<Encuestado> ListaGlobal = new ArrayList<Encuestado>();
    public  static final int id=4;

    public void onActivityResult(int requestcode, int resultcode, Intent data ){
        super.onActivityResult(requestcode, resultcode, data);

        switch (requestcode){
            case id:{
                if(RESULT_OK == resultcode){
                    Encuestado n = new Encuestado();
                    n.setNombre(data.getStringExtra(NuevoEncuestado.textoNombre));
                    n.setEdad(data.getStringExtra(NuevoEncuestado.textoEdad));
                    n.setAlimento(data.getStringExtra(NuevoEncuestado.textoAlimento));
                    ListaGlobal.add(n);
                    Toast.makeText(this, "Enviado con Exito..", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Saliendo....", Toast.LENGTH_SHORT).show();

                }
            }
            break;
            default:
                Toast.makeText(this, "Error en el switch..", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNuevo = findViewById(R.id.btnNuevoEncuestador);
        BtnLista = findViewById(R.id.btnListaEncuestado);

        this.btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frm = new Intent(MainActivity.this,NuevoEncuestado.class);
                startActivityForResult(frm,id);
            }
        });

        this.BtnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(ListaGlobal.size() == 0)){
                    Intent frm = new Intent(MainActivity.this,Listar_Informacion.class);
                    Gson g = new Gson();
                    String Datos = g.toJson(ListaGlobal);
                    frm.putExtra("DatosLista",Datos);
                    startActivity(frm);
                }else{
                    Toast.makeText(MainActivity.this,"Lista Vacia..",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}