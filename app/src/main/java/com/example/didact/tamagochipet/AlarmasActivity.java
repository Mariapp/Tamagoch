package com.example.didact.tamagochipet;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmasActivity extends AppCompatActivity {

    EditText etjugar, etcomer;
    CheckBox checksi, checkno;



    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmas);

        etcomer=(EditText)findViewById(R.id.etcomer);
        etjugar=(EditText)findViewById(R.id.etjugar);
        checksi=(CheckBox)findViewById(R.id.checksi);
        checkno=(CheckBox)findViewById(R.id.checkno);





        /*alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmasActivity.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

// Alarma a las 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 30);

// Repeticiones en intervalos de 20 minutos
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 20, alarmIntent);*/


    }
    public void siguiente (View view){

        String cajacomer=etcomer.getText().toString();
        String cajajugar=etjugar.getText().toString();

        if(cajacomer.equals("")|| cajajugar.equals("")){
            Toast.makeText(getApplicationContext(), "Por favor, rellena los datos",
                    Toast.LENGTH_LONG).show();


        }else{
            Intent i=new Intent().setClass(getApplicationContext(), AlarmasActivity2.class);
            startActivity(i);
        }


    }

    }


