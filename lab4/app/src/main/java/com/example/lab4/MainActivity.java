package com.example.lab4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnOptionChecked {
    DynamicFragment1 fragmentD=new DynamicFragment1();
    DynamicFragment2 fragmentD2=new DynamicFragment2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onOptionChecked(int id) {
        Fragment fragment1;
        if(id==R.id.radioButton1){
            fragment1=fragmentD;

        }else{
            fragment1=fragmentD2;
        }

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fragmentContainer,fragment1);
        //transaction.addToBackStack(null);
        transaction.commit();

    }
}