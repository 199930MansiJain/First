package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,1,2,"item1");
        menu.add(0,1,2,"item2");
        menu.add(0,1,2,"item3");
        menu.add(0,1,2,"item4");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(getApplicationContext(),"This is"+item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(),"This is"+item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(),"This is"+item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(),"This is"+item.getTitle(),Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
