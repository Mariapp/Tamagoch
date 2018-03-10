package com.example.didact.tamagochipet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MenuPrincipal extends AppCompatActivity {

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;
    TextView tvusuariotamagochi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);



        tvusuariotamagochi=(TextView)findViewById(R.id.tvusuariotamagochi);

        /*Bundle b= getIntent().getExtras();

        if (b!=null){

            usu = b.getParcelable(Loginctivity.EXTRA_USU);
            tvusuariotamagochi.setText(usu.getNombre());
        }
        datosUsuario();*/




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
   /* public void datosUsuario() {

        String usuario = tvusuariotamagochi.getText().toString();


        dbRef = FirebaseDatabase.getInstance().getReference().child("usuario/" + usuario);

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                usu = dataSnapshot.getValue(Usuario.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("LoginActivity", "DATABASE ERROR");
            }
        };
        dbRef.addValueEventListener(valueEventListener);*/
    
     private String obtenerFechaSistema(){

        Calendar c= Calendar.getInstance();
        Date fecha = c.getTime();
        String fecha_string =
                c.get(Calendar.YEAR)+""+(c.get(Calendar.MONTH)+1)+""+c.get(Calendar.DAY_OF_MONTH);
        return fecha_string;
    }


    }



    // public void   (View view){}

