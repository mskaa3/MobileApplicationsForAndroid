package com.example.lab7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LocationActivity extends AppCompatActivity implements LocationListener {
    boolean deniedOnce=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }
    @Override
    public void onRequestPermissionsResult(int code, String[] permission, int[] result) {
        super.onRequestPermissionsResult(code, permission, result);
        if (result[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
        } else {
            deniedOnce=true;
            Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        LocationManager manager=(LocationManager)  getSystemService(LOCATION_SERVICE);

        Intent i=getIntent();


        if(!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            ((TextView)findViewById(R.id.latitude)).setText("Not applicable");
            ((TextView)findViewById(R.id.altitude)).setText("Not applicable");
            ((TextView)findViewById(R.id.longtitude)).setText("Not applicable");
            ((TextView)findViewById(R.id.speed)).setText("Not applicable");
        }else{
            if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, this);
                //why i need to cast?
            }else if(!deniedOnce) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                ((TextView)findViewById(R.id.latitude)).setText("No access");
                ((TextView)findViewById(R.id.altitude)).setText("No access");
                ((TextView)findViewById(R.id.longtitude)).setText("No access");
                ((TextView)findViewById(R.id.speed)).setText("No access");
            }
        }
    }


    @Override
    protected void onPause(){
        super.onPause();
        ((LocationManager)getSystemService(LOCATION_SERVICE)).removeUpdates(this);
        //why i need to cast?
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        ((TextView)findViewById(R.id.latitude)).setText(Double.toString(location.getLatitude()));
        ((TextView)findViewById(R.id.altitude)).setText(Double.toString(location.getAltitude()));
        ((TextView)findViewById(R.id.longtitude)).setText(Double.toString(location.getLongitude()));
        ((TextView)findViewById(R.id.speed)).setText(Double.toString(location.getSpeed()));

    }
    @Override
    public void onProviderEnabled(@NonNull String provider){
        Toast.makeText(getApplicationContext(), "Provider enabled", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onProviderDisabled(@NonNull String provider){
        Toast.makeText(getApplicationContext(), "Provided disable", Toast.LENGTH_SHORT).show();
    }
}