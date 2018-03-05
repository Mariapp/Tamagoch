package com.example.didact.tamagochipet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
//DEFINIR EL TIEMPO QUEDURA EL SPLASH EN UNA VARIABLE

    private static final long DURACION_SPLASH =3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_main);

        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(), Loginctivity.class);
                startActivity(i);

                finish(); // cierra este activitiy
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, DURACION_SPLASH);
    }
}
