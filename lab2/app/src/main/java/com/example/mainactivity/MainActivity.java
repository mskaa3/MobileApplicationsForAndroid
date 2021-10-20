package com.example.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            }



    public void openSimpleList(View view){
        Intent intent1=new Intent();
        intent1.setClass(getApplicationContext(),SimpleList.class);
        startActivity(intent1);

    }


    public void openMultipleChoiceList(View view){
        Intent intent1=new Intent();
        intent1.setClass(getApplicationContext(),MultipleChoiceList.class);
        startActivity(intent1);

    }

    public void openGrid(View view){
        Intent intent1=new Intent();
        intent1.setClass(getApplicationContext(),grid.class);
        startActivity(intent1);

    }
//    public void custom(View view){
//        Intent intent1=new Intent();
//        intent1.setClass(getApplicationContext(),grid.class);
//        startActivity(intent1);
//
//    }
}