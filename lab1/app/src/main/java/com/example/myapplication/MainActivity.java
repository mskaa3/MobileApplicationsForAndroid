package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent1 = new Intent(this, MainActivity2.class);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);

            }
        });

    }
    public void openSecond(View view){
        final Intent intent2 = new Intent(this, MainActivity2.class);
        startActivity(intent2);
    }
    public void openThird(View view){
        final Intent intent3 = new Intent(this, MainActivity3.class);
        startActivity(intent3);
    }

}