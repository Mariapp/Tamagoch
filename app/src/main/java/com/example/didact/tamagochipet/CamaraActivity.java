package com.example.didact.tamagochipet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CamaraActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private Button bt;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button)findViewById(R.id.button);
        imageView=(ImageView)findViewById(R.id.imageView);
    }
    public void tomarFoto(View view){
        dispatchTakePictureIntent();


    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    public static class AlarmActivity extends Activity {

        AlarmManager alarmManager;
        private PendingIntent pendingIntent;
        private TimePicker alarmTimePicker;
        private static AlarmActivity inst;
        private TextView alarmTextView;

        public static AlarmActivity instance() {
            return inst;
        }

        @Override
        public void onStart() {
            super.onStart();
            inst = this;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_alarm);
            alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
            alarmTextView = (TextView) findViewById(R.id.alarmText);
            ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        }

        public void onToggleClicked(View view) {
            if (((ToggleButton) view).isChecked()) {
                Log.d("MyActivity", "Alarm On");
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                Intent myIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0, myIntent, 0);
                alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            } else {
                alarmManager.cancel(pendingIntent);
                setAlarmText("");
                Log.d("MyActivity", "Alarm Off");
            }
        }

        public void setAlarmText(String alarmText) {
            alarmTextView.setText(alarmText);
        }

        /**
         * Created by Fernando on 10/03/2018.
         */

        public static class AlarmReceiver extends BroadcastReceiver {

            int id= 1;

            @Override
            public void onReceive(Context context, Intent intent) {



                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

                Intent repeating_intent = new Intent(context,MainActivity.class);
                repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                PendingIntent pendingIntent = PendingIntent.getActivity(context,id++,repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);


                NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.drawable.pet)
                        .setContentTitle("NOMBRE")
                        .setContentText("DESCRIPCIÓN")
                        .setAutoCancel(true);
                notificationManager.notify(id++,builder.build());

            }
        }
    }
    public void guardar (View v){
        Intent i=new Intent(getApplicationContext(), CamaraActivity.class);
                startActivity(i);
    }
}
