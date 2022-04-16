package com.example.projekat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class KoraciActivity extends AppCompatActivity implements SensorEventListener {

    MediaPlayer mediaPlayer;

    private TextView deterktorKoraka;
    private SensorManager sensorManager;
    private Sensor mstepDetector;

    private boolean isDetectorSensorPresent;
    int stepDetect = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koraci);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        deterktorKoraka = findViewById(R.id.detektorKoraka);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null){
            mstepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isDetectorSensorPresent = true;
        } else {
            deterktorKoraka.setText("Detector Sensor is not present");
            isDetectorSensorPresent = false;
        }

    }

    public void play(View v) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.music);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        mediaPlayer.start();
    }

    public void pause(View v) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }
    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor == mstepDetector){
            stepDetect = (int) (stepDetect+event.values[0]);
            deterktorKoraka.setText(String.valueOf(stepDetect));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null)
            sensorManager.registerListener(this, mstepDetector, sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            sensorManager.unregisterListener(this, mstepDetector);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(KoraciActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.logout:
                Intent i = new Intent(KoraciActivity.this, MainActivity.class);
                startActivity(i);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}