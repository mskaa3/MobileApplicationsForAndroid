package com.example.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu m){


        MenuItem menuItem1=m.add("Item 1");
      menuItem1.setCheckable(true);
      m.add("Item 2");

      m.add(0,1,Menu.NONE, "id Item1");
        m.add(0,2,Menu.NONE, "id Item2");
        SubMenu sm=m.addSubMenu(0,3,Menu.NONE,"Submenu");
        sm.add(0,4,0,"Subitem1 ");
        sm.add(0,5,0,"Subitem2 ");
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem m){
        switch(m.getItemId()){
            case 1:
                startActivity(new Intent(getApplicationContext(),XMLMenu.class));
                return true;
            default:
                Toast.makeText(getApplicationContext(),m.getTitle()+ " " + m.getItemId(),Toast.LENGTH_SHORT).show();
                return true;
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        if(v.getId()==R.id.textView1){
            menu.add(0,1,Menu.NONE, "id Item1");
            menu.add(0,2,Menu.NONE, "id Item2");
        }else{
            menu.add(0,3,Menu.NONE, "id Item3");
            menu.add(0,4,Menu.NONE, "id Item4");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem i){
        switch (i.getItemId()){
            case 3:
                startActivity(new Intent(getApplicationContext(),XMLMenu.class));
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
        registerForContextMenu(findViewById(R.id.textView1));
        registerForContextMenu(findViewById(R.id.textView2));
    }
    public void openActionMode(View v){
        startActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                menu.add(0,2,Menu.NONE, "id Item1");
                menu.add(0,3,Menu.NONE, "id Item3");
                menu.add(0,4,Menu.NONE, "id Item5");
                menu.add(0,5,Menu.NONE, "id Item7");
                menu.add(0,6,Menu.NONE, "id Item9");
                menu.add(0,7,Menu.NONE, "id Item11");


                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Toast.makeText(getApplicationContext(),item.getTitle()+ " " + item.getItemId(),Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}