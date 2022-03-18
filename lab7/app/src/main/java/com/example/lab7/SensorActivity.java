package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
    }

    @Override
    protected void onResume(){
        super.onResume();
        SensorManager manager=(SensorManager) getSystemService(SENSOR_SERVICE);

        Intent i=getIntent();
        List<Sensor> sensorList;
        if(i.getStringExtra("SENSOR_TYPE").equals("LIGHT")){
            sensorList =manager.getSensorList( Sensor.TYPE_LIGHT);
        }else if(i.getStringExtra("SENSOR_TYPE").equals("ACCELEROMETER")){
            sensorList =manager.getSensorList( Sensor.TYPE_ACCELEROMETER);
        }else{
            sensorList =manager.getSensorList( Sensor.TYPE_PRESSURE);
        }

        if(sensorList.isEmpty()){
            ((TextView)findViewById(R.id.sensorType)).setText(i.getStringExtra("SENSOR_TYPE"));
            ((TextView)findViewById(R.id.sensor1)).setText("0");
            ((TextView)findViewById(R.id.sensor2)).setText("Not applicable");

        }else{
            ((TextView)findViewById(R.id.sensor1)).setText(Integer.toString(sensorList.size()));
            manager.registerListener(this,sensorList.get(0),100_000,1_000);


        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Intent i = getIntent();
        if (i.getStringExtra("SENSOR_TYPE").equals("LIGHT")) {
            ((TextView) findViewById(R.id.sensor2)).setText(String.format("value: %f, accuracy %d", event.values[0], event.accuracy));
        }else if(i.getStringExtra("SENSOR_TYPE").equals("ACCELEROMETER")){
            ((TextView) findViewById(R.id.sensor2)).setText(String.format("value x: %f, value y: %f, value z: %f ,accuracy %d", event.values[0],event.values[1],event.values[2], event.accuracy));
        }else{
            ((TextView) findViewById(R.id.sensor2)).setText(String.format("value: %.3f hPa, accuracy %d", event.values[0], event.accuracy));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    protected void onPause(){
        super.onPause();
        ((SensorManager)getSystemService(SENSOR_SERVICE)).unregisterListener(this);

    }
}