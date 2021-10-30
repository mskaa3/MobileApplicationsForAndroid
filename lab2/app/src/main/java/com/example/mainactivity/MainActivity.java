package com.example.mainactivity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            }



    public void openSimpleList(View view){
        Intent intent1=new Intent();
        intent1.setClass(this,SimpleList.class);
        startActivity(intent1);

    }


    public void openMultipleChoiceList(View view){
        Intent intent1=new Intent();
        intent1.setClass(getApplicationContext(),MultipleChoiceList.class);
//        startActivityForResult(intent1,0);
        startActivity(intent1);

    }

    public void openGrid(View view){
        Intent intent1=new Intent();
        intent1.setClass(getApplicationContext(),grid.class);
        intent1.putExtra("arg1","Value1");
        intent1.putExtra("arg2",2);

        startActivity(intent1);

    }
    public void openCustom(View view){
        Intent intent1=new Intent();
        intent1.setClass(getApplicationContext(),customActivity.class);
        startActivity(intent1);

    }
    public void openPhoneBook(View view){
        Intent intent1=new Intent();
        intent1.setClass(getApplicationContext(),phoneList.class);
        startActivity(intent1);

    }
    public void openGoogle(View view){
        Uri web = Uri.parse("http://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,web);
        startActivity( Intent.createChooser(i, "Choose Application"));
    }




//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
//        super.onActivityResult(requestCode,resultCode,data);
//        if(resultCode==0){
//            Toast.makeText(this,"nothing selected", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, data.getStringExtra("Result"), Toast.LENGTH_SHORT).show();
//        }
//    }
}
