package com.example.didact.tamagochipet;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;


public class AlarmasActivity2 extends Activity {


    Button button2,button6,button7;
        Toast mToast;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_alarmas2);

// Watch for button clicks.
            Button button = (Button)findViewById(R.id.button2);
            button.setOnClickListener(mOneShotListener);
            button = (Button)findViewById(R.id.button6);
            button.setOnClickListener(mStartRepeatingListener);
            button = (Button)findViewById(R.id.button7);
            button.setOnClickListener(mStopRepeatingListener);
        }

        private View.OnClickListener mOneShotListener = new View.OnClickListener() {
            public void onClick(View v) {
// When the alarm goes off, we want to broadcast an Intent to our
// BroadcastReceiver. Here we make an Intent with an explicit class
// name to have our own receiver (which has been published in
// AndroidManifest.xml) instantiated and called, and then create an
// IntentSender to have the intent executed as a broadcast.
                Intent intent = new Intent(AlarmasActivity2.this, AlarmasActivity.class);
                PendingIntent sender = PendingIntent.getBroadcast(AlarmasActivity2.this,
                        0, intent, 0);

// We want the alarm to go off 30 seconds from now.
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, 30);

// Schedule the alarm!
                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);

// Tell the user about what we did.
                if (mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(AlarmasActivity2.this,"muajajajuas",
                        Toast.LENGTH_LONG);
                mToast.show();
            }
        };

        private View.OnClickListener mStartRepeatingListener = new View.OnClickListener() {
            public void onClick(View v) {
// When the alarm goes off, we want to broadcast an Intent to our
// BroadcastReceiver. Here we make an Intent with an explicit class
// name to have our own receiver (which has been published in
// AndroidManifest.xml) instantiated and called, and then create an
// IntentSender to have the intent executed as a broadcast.
// Note that unlike above, this IntentSender is configured to
// allow itself to be sent multiple times.
                Intent intent = new Intent(AlarmasActivity2.this, AlarmasActivity.class);
                PendingIntent sender = PendingIntent.getBroadcast(AlarmasActivity2.this,
                        0, intent, 0);

// We want the alarm to go off 30 seconds from now.
                long firstTime = SystemClock.elapsedRealtime();
                firstTime += 15*1000;

// Schedule the alarm!
                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        firstTime, 15*1000, sender);

// Tell the user about what we did.
                if (mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(AlarmasActivity2.this, "muajaja",
                        Toast.LENGTH_LONG);
                mToast.show();
            }
        };

        private View.OnClickListener mStopRepeatingListener = new View.OnClickListener() {
            public void onClick(View v) {
// Create the same intent, and thus a matching IntentSender, for
// the one that was scheduled.
                Intent intent = new Intent(AlarmasActivity2.this, AlarmasActivity.class);
                PendingIntent sender = PendingIntent.getBroadcast(AlarmasActivity2.this,
                        0, intent, 0);

// And cancel the alarm.
                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                am.cancel(sender);

// Tell the user about what we did.
                if (mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(AlarmasActivity2.this,"jaja",
                        Toast.LENGTH_LONG);
                mToast.show();
            }
        };
    }