package com.example.didact.tamagochipet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistroUsuarioActivity extends AppCompatActivity {
    EditText ednuevousuario, ednuevapassword, ednuevoemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
    }
    public void logear(View view) {



        Intent i = new Intent(getApplicationContext(), MenuPrincipal.class);
        startActivity(i);


    }
}
