package com.example.didact.tamagochipet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistroUsuarioActivity extends AppCompatActivity {
    EditText ednuevousuario, ednuevapassword, ednuevoemail;
    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        ednuevousuario=(EditText)findViewById(R.id.ednuevousuario);
        ednuevapassword=(EditText)findViewById(R.id.ednuevapassword);
        ednuevoemail=(EditText)findViewById(R.id.ednuevoemail);


    }
    public void logear(View view) {

            String nombre = ednuevousuario.getText().toString();
            String password = ednuevapassword.getText().toString();
            String email = ednuevoemail.getText().toString();


            if(nombre.equals("")||email.equals("")||password.equals("")){
                Toast.makeText(getApplicationContext(),"Rellena todos los campos", Toast.LENGTH_LONG).show();
            }else{
                Usuario nuevoUsuario=new Usuario(nombre,email,password);
                dbRef = FirebaseDatabase.getInstance().getReference()
                        .child("Usuario");
                dbRef.child(nombre).setValue(nuevoUsuario, new DatabaseReference.CompletionListener() {

                    public void onComplete(DatabaseError error, DatabaseReference ref) {
                        if (error == null) {

                            String nombre = ednuevousuario.getText().toString();
                            String password = ednuevapassword.getText().toString();

                            Toast.makeText(getApplicationContext(), "Tu usuario y tu contraseña son: "+nombre+"\n"+password,
                                    Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(),MenuPrincipal.class);
                            startActivity(i);


                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "NO SE PUEDE INSETAR EL JUGADOR",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        }







    }





