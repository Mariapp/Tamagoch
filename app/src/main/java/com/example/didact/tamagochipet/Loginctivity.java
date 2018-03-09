package com.example.didact.tamagochipet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
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



    DatabaseReference dbRef;
    ValueEventListener valueEventListener;
    EditText edusuario,edpassword;

    static final String EXTRA_USU="Usu";



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


                    if(!idpassword.equals(contraseñaobtenida)){
                        Toast.makeText(getApplicationContext(), "La contraseña es erronea",
                            Toast.LENGTH_LONG).show();


                    }else{
                        Intent menuintent=new Intent().setClass(getApplicationContext(), MenuPrincipal.class);
                        menuintent.putExtra(EXTRA_USU,"Usu");
                        startActivity(menuintent);
                        finish();
                    }

            }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("LoginActivity", "DATABASE ERROR");

            }
        };

        dbRef.addValueEventListener(valueEventListener);
}


}




