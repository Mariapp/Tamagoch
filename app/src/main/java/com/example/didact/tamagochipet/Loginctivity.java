package com.example.didact.tamagochipet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Loginctivity extends AppCompatActivity {

    private DatabaseReference dbRef;
    private ValueEventListener valueEventListener;
    EditText edusuario,edpassword;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginctivity);

        edusuario=(EditText)findViewById(R.id.edusuario);
        edpassword=(EditText)findViewById(R.id.edpassword);

    }
    public void registrarusuario (View view){

        Intent i=new Intent(getApplicationContext(),RegistroUsuarioActivity.class);
        startActivity(i);


    }




   /* public void logear (View view) {

        String idusuario = edusuario.getText().toString();
        String idpassword = edpassword.getText().toString();

        if (edusuario.equals("") || edpassword.equals("")) {
            Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_LONG).show();
        } else {

            String idusuario = edusuario.getText().toString();
            String idpassword = edpassword.getText().toString();


            dbRef = FirebaseDatabase.getInstance().getReference()
                    .child("Usuario/" + idusuario + idpassword);

            valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    Usuario usu = dataSnapshot.getValue(Usuario.class);

                    Intent i = null;
                    if (usu != null) {
                        Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_LONG).show();
                    } else {
                        i = new Intent(getApplicationContext(), MenuPrincipal.class);
                        startActivity(i);
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("Loginctivity", "Database ERROR");

                }
            };

            dbRef.addValueEventListener(valueEventListener);


        }
    }*/

    public void logear (View view){

        String idusuario = edusuario.getText().toString();
        final String idpassword = edpassword.getText().toString();

        dbRef= FirebaseDatabase.getInstance().getReference().child("Usuario/"+idusuario);
        valueEventListener=new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Usuario usu=dataSnapshot.getValue(Usuario.class);

                Toast.makeText(getApplicationContext(), "nombre "+usu.getNombre()+"\n"+
                        "email "+usu.getEmail()+"\n"+
                        "password "+usu.getPassword(),
                        Toast.LENGTH_LONG).show();

                if(usu!=null){

                    if(usu.getPassword().equals(idpassword)){
                        //el intent
                    }else{
                        Toast.makeText(getApplicationContext(), "La contraseña es erronea",
                                Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "No existe el usuario",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        dbRef.addValueEventListener(valueEventListener);
}
}

