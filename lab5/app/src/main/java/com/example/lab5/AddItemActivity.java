package com.example.lab5;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class AddItemActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        final EditText mytext = findViewById(R.id.inputfield);
        final RatingBar rating =findViewById(R.id.ratingBar);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = mytext.getText().toString().trim();
                int starts=rating.getNumStars();
                Bundle bundle = new Bundle();
                bundle.putString("text",value);
                bundle.putInt("stars",starts);
                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}