package com.example.lab7;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class sensorAdapter extends ArrayAdapter<Sensor> {
    private int textViewResourceID;

    public sensorAdapter(@NonNull Context context, int textViewResourceID, @NonNull List<Sensor> objects) {
        super(context, textViewResourceID, objects);
        this.textViewResourceID = textViewResourceID;
    }

    private static class ViewHolder {
        private TextView itemView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(textViewResourceID, parent, false);
            viewholder = new ViewHolder();
            viewholder.itemView = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        Sensor mySensor = getItem(position);
        if (mySensor != null) {
            viewholder.itemView.setText("Name; " + mySensor.getName() + " Int type: " + mySensor.getType()
                    + " String Type : " + sensorTypeToString(mySensor.getType()) + " / Vendor : "
                    + mySensor.getVendor() + " / Version : "
                    + mySensor.getVersion() + " / Resolution : "
                    + mySensor.getResolution() + " / Power : "
                    + mySensor.getPower() + " mAh"
                    + " / Maximum Range : " + mySensor.getMaximumRange());
        }
        return convertView;
    }

    public static String sensorTypeToString(int sensorType) {
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                return "Accelerometer";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
            case Sensor.TYPE_TEMPERATURE:
                return "Ambient Temperature";
            case Sensor.TYPE_GAME_ROTATION_VECTOR:
                return "Game Rotation Vector";
            case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                return "Geomagnetic Rotation Vector";
            case Sensor.TYPE_GRAVITY:
                return "Gravity";
            case Sensor.TYPE_GYROSCOPE:
                return "Gyroscope";
            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                return "Gyroscope Uncalibrated";
            case Sensor.TYPE_HEART_RATE:
                return "Heart Rate Monitor";
            case Sensor.TYPE_LIGHT:
                return "Light";
            case Sensor.TYPE_LINEAR_ACCELERATION:
                return "Linear Acceleration";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return "Magnetic Field";
            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                return "Magnetic Field Uncalibrated";
            case Sensor.TYPE_ORIENTATION:
                return "Orientation";
            case Sensor.TYPE_PRESSURE:
                return "Orientation";
            case Sensor.TYPE_PROXIMITY:
                return "Proximity";
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return "Relative Humidity";
            case Sensor.TYPE_ROTATION_VECTOR:
                return "Rotation Vector";
            case Sensor.TYPE_SIGNIFICANT_MOTION:
                return "Significant Motion";
            case Sensor.TYPE_STEP_COUNTER:
                return "Step Counter";
            case Sensor.TYPE_STEP_DETECTOR:
                return "Step Detector";
            default:
                return "Unknown";
        }
    }
}
