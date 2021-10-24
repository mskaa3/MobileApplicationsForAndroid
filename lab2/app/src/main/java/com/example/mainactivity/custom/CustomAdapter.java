package com.example.mainactivity.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mainactivity.R;



class Item{
    TextView text1;
    TextView text2;
    ImageView image1;
    CheckBox checkbox1;
}

public class CustomAdapter extends BaseAdapter {
    String[] titles;
    String[] subtitles;
    boolean[] checked;
    LayoutInflater inf=null;
    Context context;


    public CustomAdapter(String[] titles, String[] subtitles,Context ctx){
        super();
        this.titles=titles;
        this.subtitles=subtitles;
        this.checked=new boolean[titles.length];
        inf=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context=ctx;


    }
    @Override
    public int getCount() {
        return titles.length;
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
        Item item1 =new Item();
        if(view==null){

            view=inf.inflate(R.layout.list_row,null);
            item1.checkbox1=(CheckBox) view.findViewById((R.id.myCheckBox));
            item1.text1=(TextView)view.findViewById(R.id.row_tv1);
            item1.text2=(TextView)view.findViewById(R.id.row_tv2);
            item1.image1=(ImageView)view.findViewById(R.id.row_image);
            view.setTag(item1);

        }else{
            item1=(Item)view.getTag();

        }
        item1.text1.setText((titles[position]));
        item1.text2.setText((subtitles[position]));
        item1.checkbox1.setChecked(checked[position]);
        item1.checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v ).isChecked()){
                    checked[position]=true;
                }else{
                    checked[position]=false;
                }
                Toast.makeText(context.getApplicationContext(), "Checkbox clicked", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
