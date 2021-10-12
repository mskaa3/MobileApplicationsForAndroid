package com.example.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View window2 = (View) findViewById(R.id.myPushHoldText);
        window2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finish();
                return false;
            }
        });

    }

    public void goBackTo1(View view) {
        onBackPressed();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),
                "Activity 2 stopped",
                Toast.LENGTH_SHORT).show();

    }  //in the pdf task we are supposed to add back button to activity 2, but i guess its a typo
}