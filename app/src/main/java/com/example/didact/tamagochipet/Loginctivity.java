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

                if (dataSnapshot.getValue()==null) {
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG).show();
                }else{

                    String contraseñaobtenida=usu.getPassword();


                    if(idpassword.equals(contraseñaobtenida)){

                        Intent menuintent=new Intent().setClass(getApplicationContext(), MenuPrincipal.class);
                        startActivity(menuintent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "La contraseña es erronea",
                                Toast.LENGTH_LONG).show();
                    }

            }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        dbRef.addValueEventListener(valueEventListener);
}
}

