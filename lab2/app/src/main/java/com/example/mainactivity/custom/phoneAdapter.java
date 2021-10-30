package com.example.mainactivity.custom;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mainactivity.R;
import com.example.mainactivity.avatarGallery;


import java.util.Random;

class newItem {
    TextView text1;
    TextView text2;
    Button button;
    ImageView image1;
}

public class phoneAdapter extends BaseAdapter {

    String[] names;
    String[] numbers;
    LayoutInflater inf = null;
    Context context;
    public Integer[] images = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3
    };

    public phoneAdapter(String[] names, String[] numbers, Context ctx) {
        super();
        this.names = names;
        this.numbers = numbers;
        inf = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context = ctx;
    }

    @Override
    public int getCount() {
        return names.length;
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        newItem item1 = new newItem();
        final Random rand = new Random();

        if (view == null) {

            view = inf.inflate(R.layout.numbers, null);

            item1.text1 = (TextView) view.findViewById(R.id.Name_Surname);
            item1.text2 = (TextView) view.findViewById(R.id.PhoneNum);
            item1.button = (Button) view.findViewById(R.id.callButton);
            item1.image1 = (ImageView) view.findViewById(R.id.contact_image);
            view.setTag(item1);

        } else {

            item1 = (newItem) view.getTag();

        }
        item1.text1.setText((names[position]));
        item1.text2.setText((numbers[position]));
        item1.image1.setImageResource(images[rand.nextInt(images.length)]);
        item1.image1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent1 = new Intent();
                intent1.setClass(context.getApplicationContext(), avatarGallery.class);
                context.startActivity(intent1);
                return false;
            }
        });


        item1.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String number =  numbers[position];

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + number));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    try {
                        context.startActivity(callIntent);
                        Toast.makeText(context.getApplicationContext(), "Calling", Toast.LENGTH_SHORT).show();
                    } catch(ActivityNotFoundException ex){
                        Toast.makeText(context, "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
                    }
            }

        });


        return view;
    }
}

