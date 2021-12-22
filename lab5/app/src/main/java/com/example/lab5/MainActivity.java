package com.example.lab5;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lab5.placeholder.PlaceholderContent;
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

        }
        myListFragment = (ListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_list);


        ActivityResultLauncher<Intent> launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()== Activity.RESULT_OK){
                            ItemData d=new ItemData();
                            Intent data=result.getData();
                            d.id=data.getIntExtra("text",-1);

                            d.txtMain= data.getStringExtra("name");
                            d.txtSecond=data.getStringExtra("surname");
                            d.age=data.getIntExtra("age",-1);
                            d.gender=data.getBooleanExtra("gender",false);
                            d.rating=data.getIntExtra("stars",-1);
                            System.out.println("-----------------"+d.txtMain);
                            System.out.println("-----------------"+d.txtSecond);
                            System.out.println("-----------------"+d.id);
                            myRepository.insertItem(d);
                            myListFragment.setList(getRepositoryList());

                        }
                    }
                }

        );

        FloatingActionButton fab = findViewById(R.id.fabutton);
        fab.setImageResource(R.drawable.ic_baseline_add_circle_24);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launcher.launch(new Intent(getApplicationContext(),AddItemActivity.class));
//                Bundle bundle = getIntent().getExtras();
//                if (bundle!= null) {
//                    String value = bundle.getString("value");
//                    int stars=bundle.getInt("stars");
////                    TextView textView = findViewById(R.id.item_txt_main);
////                    textView.setText(value);
//
                }
            }
        );


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