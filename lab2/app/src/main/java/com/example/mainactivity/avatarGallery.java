package com.example.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.mainactivity.custom.GridImageAdapter;
import com.example.mainactivity.custom.avatarGridAdapter;

public class avatarGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_gallery);
        GridView view= (GridView) findViewById(R.id.myAvatarGrid);
        view.setAdapter(new avatarGridAdapter(this));
    }
}