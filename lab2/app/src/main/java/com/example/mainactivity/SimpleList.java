package com.example.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleList extends AppCompatActivity implements AdapterView.OnItemClickListener{
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
            "item10",
            "item11",
            "item12",
            "item13",
            "item14",
            "item15",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        ArrayAdapter<String> array=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        array.addAll(inMyList);
        ListView list_view=findViewById(R.id.mySimpleList);
        list_view.setAdapter(array);
        list_view.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView adapterView, View view, int x, long z){
        Toast.makeText(this,inMyList[x],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}