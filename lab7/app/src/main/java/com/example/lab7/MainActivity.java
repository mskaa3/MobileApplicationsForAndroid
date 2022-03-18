package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume(){
        super.onResume();
        LocationManager mgr=(LocationManager) getSystemService(LOCATION_SERVICE);
        boolean isEnabled= mgr.isProviderEnabled(LocationManager.GPS_PROVIDER);
        Button lButton=findViewById(R.id.locationButton);
        lButton.setEnabled(isEnabled);
    }
    public void gotoLocation(View v){
        startActivity(new Intent(getApplicationContext(),LocationActivity.class));
    }


    public void gotoSensors(View v){
        Intent i=new Intent(getApplicationContext(),SensorActivity.class);
        if(v.getId()==R.id.accelerateButton){
            i.putExtra("SENSOR_TYPE","ACCELEROMETER");
        }else if(v.getId()==R.id.sensorButton){
            i.putExtra("SENSOR_TYPE","LIGHT");
        }else {
            i.putExtra("SENSOR_TYPE","PRESSURE");
        }
        startActivity(i);
    }

    public void gotoList(View v){
        startActivity(new Intent(getApplicationContext(),ListSensors.class));
    }
}