package com.example.didact.tamagochipet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void configuracion  (View view){
        Intent i=new Intent(getApplicationContext(), ConfiguracionMAscotas.class);
        startActivity(i);


    }
    public void conectividad (View view){

        Intent i=new Intent(getApplicationContext(),ConectividadActivity.class);
        startActivity(i);
    }


    public void camara (View view){
        Intent i=new Intent(getApplicationContext(),CamaraActivity.class);
        i.setAction(Intent.ACTION_VIEW);
        startActivity(i);


    }


   // public void   (View view){}
}
