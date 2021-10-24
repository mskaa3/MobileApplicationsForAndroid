package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mainactivity.custom.GridImageAdapter;

public class grid extends AppCompatActivity {

    String[] myList={"Pos1", "Pos2","Pos3"};
    String[] positions={"1","2","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridView view= (GridView) findViewById(R.id.mygrid);
        view.setAdapter(new GridImageAdapter(this));

        String arg1=getIntent().getStringExtra("Arg1");
        Integer arg2=getIntent().getIntExtra("Arg2",0);

        Toast.makeText(getApplicationContext(),arg1+arg2,Toast.LENGTH_SHORT).show();


        Spinner spinner=(Spinner)findViewById(R.id.myspinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Selected:"+positions[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Selected nothing", Toast.LENGTH_SHORT).show();
            }
        });
        if(spinner!=null){

            ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);
            adapter.addAll(myList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
    }
}