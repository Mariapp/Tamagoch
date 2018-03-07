package com.example.didact.tamagochipet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ConectividadActivity extends AppCompatActivity {
    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;

    ListView listtamagochi;
    ArrayList<Mascota> lista_mascotas = new ArrayList<Mascota>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conectividad);

        listtamagochi = (ListView)findViewById(R.id.listtamagochi);
        cargardatosFirebase();



    }
         private void cargardatosFirebase (){
//referencia a la base de datos
        dbRef= FirebaseDatabase.getInstance().getReference().child("Mascota");
//añadimos el evento que nos devolvera los valores
        valueEventListener=new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                //
                lista_mascotas.clear();
                for (DataSnapshot MascotasDataSnapshot: dataSnapshot.getChildren()){
                    cargardatoslistview(MascotasDataSnapshot);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError){
                Log.e("conectividad", "Database ERROR");


            }

        };//asignamos el evento para que sea en tiempo real
        dbRef.addValueEventListener(valueEventListener);
    }

    private void cargardatoslistview (DataSnapshot dataSnapshot){

        lista_mascotas.add(dataSnapshot.getValue(Mascota.class));
        AdaptadorTamagochi adapter=new AdaptadorTamagochi(getApplicationContext(),lista_mascotas);
        listtamagochi.setAdapter(adapter);




    }



}






