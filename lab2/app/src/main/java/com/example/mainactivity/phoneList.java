package com.example.mainactivity;

import static android.support.v4.content.ContextCompat.startActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.mainactivity.custom.CustomAdapter;
import com.example.mainactivity.custom.phoneAdapter;

public class phoneList extends AppCompatActivity {

    String[] names={
            "Angelina Jolie",
            "Leonardo di Caprio",
            "item3",
            "item4",
            "item5",
            "item6",
            "item7",
            "item8",
            "item9",
            "item10",
            "item11",
            "item12",
            "item13",
            "item14",
            "item15",

    };
    String[] numbers={
            "111111111",
            "222222222",
            "333333333",
            "444444444",
            "555555555",
            "666666666",
            "777777777",
            "888888888",
            "999999999",
            "101010101",
            "1111",
            "1212",
            "1313",
            "1414",
            "1515",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_list);

        phoneAdapter adapter=new phoneAdapter(names,numbers,this);
        ListView list_view=(ListView) findViewById(R.id.phoneList);
        list_view.setAdapter(adapter);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}