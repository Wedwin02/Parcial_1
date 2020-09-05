package com.uso.parcial_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class NuevoEncuestado extends AppCompatActivity {
    EditText txbNombre ,txbEdad;
    String  valoritem = " ";
    Button btnProcesar,btnverLista;
    TextView lblBander;
    private String no;
    private String ed;
    public static final int ID_Alimentos = 6;
    private static int contProceso = 0;
    private ProgressBar progresbar;
    private Handler manejadorProcesos;
    public static final String textoNombre = "textoNombre";
    public static final String textoEdad = "textoEdad";
    public static final String textoAlimento = "textoAlimento";

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case ID_Alimentos:{

                if(RESULT_OK == resultCode){
                    this.valoritem = data.getStringExtra(Listar_Frutas.AlimentoS);
                    this.lblBander.setText("Alimento Seleccionado: " + this.valoritem);
                }else{
                    Toast.makeText(NuevoEncuestado.this,"No ha seleccionado nada..",Toast.LENGTH_SHORT).show();
                }
            }
            break;
            default:{
                Toast.makeText(NuevoEncuestado.this,"ERROR de nuevo encuestado...",Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_encuestado);

        this.btnProcesar = findViewById(R.id.btnEnviarInformacion);
        this.btnverLista = findViewById(R.id.btnLisAlimentos);
        this.txbNombre = findViewById(R.id.txbNombre);
        this.txbEdad = findViewById(R.id.txbEdad);
        this.lblBander = findViewById(R.id.lblBandera);
        this.progresbar = findViewById(R.id.IDprogreso);
        this.manejadorProcesos = new Handler();

        this.progresbar.setMax(100);

        this.btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(! InfoIsValid()){
                    Toast.makeText(NuevoEncuestado.this,"Campos requeridos..",Toast.LENGTH_SHORT).show();
                }else if(valoritem.length() <= 1){
                    Toast.makeText(NuevoEncuestado.this,"Campo alimento requerido",Toast.LENGTH_SHORT).show();
                }else{
                    new Thread(new ProcesoSecundario()).start();
                }
            }
        });

        this.btnverLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frm3 = new Intent(NuevoEncuestado.this,Listar_Frutas.class);
                startActivityForResult(frm3,ID_Alimentos);
            }
        });

    }

    final class ProcesoSecundario implements Runnable{
        @Override
        public void run() {
            while (contProceso < 100){
                metodoEspera();
                manejadorProcesos.post(new Runnable() {
                    @Override
                    public void run() {
                        progresbar.setProgress(contProceso);
                        //Validar si el proceso ya termino
                        if(contProceso == 100){
                            String Name = txbNombre.getText().toString();
                            String Edad = txbEdad.getText().toString();
                            String Food = valoritem;
                            Intent msg = new Intent();
                            msg.putExtra(textoNombre,Name);
                            msg.putExtra(textoEdad,Edad);
                            msg.putExtra(textoAlimento,Food);
                            contProceso = 0;
                            setResult(RESULT_OK,msg);
                            finish();

                        }
                    }
                });
            }
        }

        private void metodoEspera(){
            try {
                Thread.sleep(90);
                contProceso++;
            }catch(Exception e){

            }
        }
    }

    private boolean InfoIsValid(){
        if(this.txbNombre.getText().toString().trim().length() <= 1 || this.txbEdad.getText().toString().trim().length() == 0){

            return false;
        }
        return true;
    }


}