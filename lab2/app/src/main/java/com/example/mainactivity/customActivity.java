package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mainactivity.custom.CustomAdapter;

public class customActivity extends AppCompatActivity {

    String[] titles={
            "item1",
            "item2",
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
    String[] subtitles={
            "111",
            "222",
            "333",
            "444",
            "555",
            "666",
            "777",
            "888",
            "999",
            "1010",
            "1111",
            "1212",
            "1313",
            "1414",
            "1515",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        CustomAdapter adapter=new CustomAdapter(titles,subtitles,this);
        ListView list_view=(ListView) findViewById(R.id.customList);
        list_view.setAdapter(adapter);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}