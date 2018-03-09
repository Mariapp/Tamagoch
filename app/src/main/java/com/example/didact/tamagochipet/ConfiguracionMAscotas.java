package com.example.didact.tamagochipet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConfiguracionMAscotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_mascotas);
    }
    public void alarma (View view){
        Intent i=new Intent(getApplicationContext(),AlarmasActivity.class);
        startActivity(i);

    }
    public void misdatos (View view){
        Intent i=new Intent(getApplicationContext(),MisDatosMAscotas.class);
        startActivity(i);
    }
}
