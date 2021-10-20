package com.example.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleList extends AppCompatActivity {
    String[] inMyList={
            "item1",
            "item2",
            "item3",
            "item4",
            "item5",
            "item6",
            "item7",
            "item8",
            "item9",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        ArrayAdapter<String> array=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        array.addAll(inMyList);
        ListView list_view=findViewById(R.id.mySimpleList);
        list_view.setAdapter(array);
    }

}