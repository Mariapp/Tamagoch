package com.example.didact.tamagochipet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MisDatosMAscotas extends AppCompatActivity{
        static final String EXTRA_MASCOTA="mascota";
        static final String EXTRA_USU="usuario";


        ListView lvmismascotas;
        TextView tvusuariomascotas;
        ArrayList<Mascota> listaRecetas = new ArrayList<Mascota>();

        DatabaseReference dbRef;
        ValueEventListener valueEventListener;

        Usuario usu=null;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mis_datos_mascotas);
                
            datosUsuario();



            lvmismascotas = (ListView)findViewById(R.id.lvmismascotas);
            tvusuariomascotas=(TextView)findViewById(R.id.tvusuariomascotas);

            Bundle b= getIntent().getExtras();

            if (r.getUsuario().equals(usu.getNombre())) {
            listaRecetas.add(dataSnapshot.getValue(CReceta.class));

                usu = b.getParcelable(Loginctivity.EXTRA_USU);
                tvusuariomascotas.setText(usu.getNombre());
            }




        }


        public void datosUsuario() {

            String usuario = tvusuariomascotas.getText().toString();


            dbRef = FirebaseDatabase.getInstance().getReference().child("Usuario/" + usuario);

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
            dbRef.addValueEventListener(valueEventListener);


        }

        public void añadirmacota (View v){
            Intent i = new Intent(getApplicationContext(), NuevaMAscota.class);
           // i.putExtra(EXTRA_MASCOTA, mascotaTamagochi);
            startActivity(i);

        }

}

