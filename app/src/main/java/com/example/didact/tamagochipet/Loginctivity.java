package com.example.didact.tamagochipet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class Loginctivity extends AppCompatActivity {
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginctivity);
    }
    public void registrarusuario (View view){

        Intent i=new Intent(getApplicationContext(),RegistroUsuarioActivity.class);
        startActivity(i);


    }



    public void logear (View view){

        Intent i=new Intent(getApplicationContext(),MenuPrincipal.class);
        startActivity(i);
    }




}
