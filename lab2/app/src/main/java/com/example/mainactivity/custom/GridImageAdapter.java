package com.example.mainactivity.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mainactivity.R;

public class GridImageAdapter extends BaseAdapter {
    private Context context;

    public Integer[] images={
            R.drawable.img1,R.drawable.img2,R.drawable.img3,
            R.drawable.img2,R.drawable.img3,R.drawable.img1,
            R.drawable.img3,R.drawable.img1,R.drawable.img2,
    };
    public GridImageAdapter(Context c){
        context=c;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view;
        if(convertView==null){
            view=new ImageView(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(200,200));
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setPadding(8,8,8,8);
            //create new image
        }else{
            view=(ImageView) convertView;

        }
        view.setImageResource(images[position]);



        return view;



    }
}
