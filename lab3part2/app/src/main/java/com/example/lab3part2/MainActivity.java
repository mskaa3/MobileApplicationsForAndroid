package com.example.lab3part2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener{
    int value;

    BottomNavigationView bottomNavigationView;
    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        m.add(0, 1, Menu.NONE, "picture 1");
        m.add(0, 2, Menu.NONE, "picture 2");
        m.add(0, 3, Menu.NONE, "picture 3");
        SubMenu sm=m.addSubMenu(0,3,Menu.NONE,"Options");
        MenuItem clickable1=sm.add(0,4,0,"Color");

        clickable1.setCheckable(true);
        MenuItem clickable2=sm.add(0,5,0,"Title ");
        clickable2.setCheckable(true);


        return true;
    }

     public void openActionMode(View v) {
         startActionMode(new ActionMode.Callback() {
             @Override
             public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                 menu.add(0, 2, Menu.NONE, "option 1");
                 menu.add(0, 3, Menu.NONE, "option 2");
                 menu.add(0, 4, Menu.NONE, "option 3");
                 menu.add(0, 5, Menu.NONE, "option 4");



                 return true;
             }

             @Override
             public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                 return false;
             }

             @Override
             public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                 Toast.makeText(getApplicationContext(), item.getTitle() + " " + item.getItemId(), Toast.LENGTH_SHORT).show();
                 return true;
             }

             @Override
             public void onDestroyActionMode(ActionMode mode) {

             }
         });
     }
    @Override
    public boolean onOptionsItemSelected(MenuItem m){
        ImageView mImageView;
        TextView mTextView;
        mTextView=(TextView) findViewById(R.id.title) ;
        mImageView = (ImageView) findViewById(R.id.imageViewId);
        ConstraintLayout mBackground=findViewById(R.id.mainBackground);

        switch(m.getItemId()){
            case 1:
                mImageView.setImageResource(R.drawable.img1);
                value=1;
                return true;

            case 2:
                mImageView.setImageResource(R.drawable.img2);
                value=2;
                return true;
            case 3:
                mImageView.setImageResource(R.drawable.img3);
                value=3;
                return true;
            case 4:
                if(m.isChecked()) {
                    m.setChecked(false);
                    mBackground.setBackgroundColor(getResources().getColor(R.color.white));
                    return true;
                }else {
                    m.setChecked(true);
                    mBackground.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
                    return true;
                }
            case 5:
                if(m.isChecked()) {
                    m.setChecked(false);
                    mTextView.setVisibility(View.INVISIBLE);
                    return true;
                }else {
                    m.setChecked(true);
                    mTextView.setVisibility(View.VISIBLE);
                    return true;
                }
            default:
                Toast.makeText(getApplicationContext(),m.getTitle()+ " " + m.getItemId(),Toast.LENGTH_SHORT).show();
                return true;
        }

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){


        if(v.getId()==R.id.imageViewId){
            if(value==1) {


                menu.add(0, 1, Menu.NONE, "Change to red");
                menu.add(0, 2, Menu.NONE, "Change to blue");
            }else if(value==2) {
                menu.add(0, 3, Menu.NONE, "Change font to bold");
                menu.add(0, 4, Menu.NONE, "Change font to italic");
            }else if(value==3) {

                menu.add(0, 5, Menu.NONE, "id Item5");
                menu.add(0, 6, Menu.NONE, "id Item6");

            }

        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem i){
        TextView mTextView;
        mTextView=(TextView) findViewById(R.id.textView3) ;
        switch (i.getItemId()){
            case 1:
                mTextView.setTextColor(Color.RED);
                return true;
            case 2:
                mTextView.setTextColor(Color.BLUE);
                return true;
            case 3:

                mTextView.setTypeface(null, Typeface.BOLD);
                return true;
            case 4:
                mTextView.setTypeface(null, Typeface.ITALIC);
                return true;
            case 5:
                mTextView.setTextSize(mTextView.getTextSize() + 20);
                return true;
            case 6:
                mTextView.setTextSize(mTextView.getTextSize() - 20);
                return true;
            default:
                Toast.makeText(getApplicationContext(),i.getTitle()+ " " + i.getItemId(),Toast.LENGTH_SHORT).show();
                return true;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(findViewById(R.id.imageViewId));

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.bringToFront();

        bottomNavigationView.setOnNavigationItemReselectedListener(
                new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.act1:
                                //Intent intent2 = new Intent(this, Activity2.class);
                                startActivity( new Intent(getApplicationContext(), Activity2.class));



                            case R.id.act2:
                                // Intent intent3 = new Intent(this, Activity3.class);
                                startActivity(new Intent(getApplicationContext(), Activity3.class));


                            case R.id.act3:
                                //Intent intent4 = new Intent(this, Activity4.class);
                                startActivity(new Intent(getApplicationContext(), Activity4.class));

                        }
                    }
                });




    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.act1:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
//
//                return true;
//
//            case R.id.act2:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
//                return true;
//
//            case R.id.act3:
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
//                return true;
//        }
//        return false;
//    }
}