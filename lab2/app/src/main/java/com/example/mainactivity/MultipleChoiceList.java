package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MultipleChoiceList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] inMyMultipleList = {
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
        setContentView(R.layout.activity_multiple_choice_list);
       // setResult(0);
        ArrayAdapter<String> array = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice);
        array.addAll(inMyMultipleList);
        ListView list_view = findViewById(R.id.myMultipleList);
        list_view.setAdapter(array);
        list_view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String info = "";
        SparseBooleanArray checked = ((ListView) findViewById(R.id.myMultipleList)).getCheckedItemPositions();
        for (int i = 0; i < checked.size(); i++) {
            if (checked.valueAt(i)) {
                int index = checked.keyAt(i);
                info = info + " " + String.valueOf(index + 1) + ",";

            }
//            getIntent().putExtra("RESULT", info);
//            setResult(1, getIntent());
            Toast.makeText(this, "You have selected: " + info, Toast.LENGTH_SHORT).show();
        }
    }

        @Override
        public void onPointerCaptureChanged( boolean hasCapture){

        }
    }
