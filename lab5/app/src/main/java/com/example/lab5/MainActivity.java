package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragmentInteractionListener{
    static MyRepository myRepository;
    ListFragment myListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null) {
            myRepository = new MyRepository((Application) getApplicationContext());
            myListFragment = (ListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment_list);
        }
        FloatingActionButton fab = findViewById(R.id.fabutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getExtras();
                if (bundle!= null) {
                    String value = bundle.getString("value");
                    int stars=bundle.getInt("stars");
//                    TextView textView = findViewById(R.id.item_txt_main);
//                    textView.setText(value);
//
                }
            }
        });


    }

    @Override
    public void onDeleteItem(ItemData item) {
        myRepository.deleteItem(item);
        myListFragment.setList(getRepositoryList());
    }

    @Override
    public List<ItemData> getRepositoryList() {
        return myRepository.getDataList();
    }




}