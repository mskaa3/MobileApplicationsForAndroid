package com.example.lab5;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

public class AddItemActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button button = findViewById(R.id.button2);
        Button cancelButton=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                EditText myString=(findViewById(R.id.inputfield));
                int num = Integer.parseInt(myString.getText().toString());
                intent.putExtra("text",num);
                intent.putExtra("name",((EditText)findViewById(R.id.namefield)).getText().toString());
                intent.putExtra("surname",((EditText)findViewById(R.id.surnamefield)).getText().toString());
                EditText myage=(findViewById(R.id.agefield));
                int ageNum = Integer.parseInt(myage.getText().toString());
                intent.putExtra("age",ageNum);
                boolean isClicked=((CheckBox)findViewById(R.id.genderBox)).isChecked();
                intent.putExtra("gender",isClicked);
//                czy to działa??
               int val=((RatingBar)findViewById(R.id.ratingBar)).getNumStars();
                intent.putExtra("stars",((RatingBar)findViewById(R.id.ratingBar)).getNumStars());
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+val);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_CANCELED);
                finish();

            }
        });

    }
}