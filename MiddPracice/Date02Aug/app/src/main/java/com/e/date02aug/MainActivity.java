package com.e.date02aug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    Button btnntx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv);
        registerForContextMenu(tv1);
        tv2 = findViewById(R.id.tv2);
       registerForContextMenu(tv2);
       btnntx=findViewById(R.id.button);

       btnntx.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(MainActivity.this,Main2Activity.class);
                       startActivity(i);
           }
       });


       tv1.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
           @Override
           public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
               menu.setHeaderTitle("COLOR ITEM");
              getMenuInflater().inflate(R.menu.menu,menu);
           }
       });
 tv2.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
     @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
         menu.add(0,4,0,"DATA4");
         menu.add(0,5,0,"DATA5");
         menu.add(0,6,0,"DATA6");
     }
 });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


         switch (item.getItemId()) {
                 case 1:
                 Toast.makeText(this, "RED SELECTED", Toast.LENGTH_SHORT).show();
                 break;
                 case 2:
                 Toast.makeText(this, "GREEN SELECTED", Toast.LENGTH_SHORT).show();
                 break;
                 case 3:
                 Toast.makeText(this, "BLUE SELECTED", Toast.LENGTH_SHORT).show();
                 break;
                 case 4:
                 Toast.makeText(this, "DATA 2 SELECTED", Toast.LENGTH_SHORT).show();
                 break;
                 case 5:
                     Toast.makeText(this, "DATA 2 SELECTED", Toast.LENGTH_SHORT).show();
                  break;
                case 6:
                Toast.makeText(this, "DATA 3 SELECTED", Toast.LENGTH_SHORT).show();
                break;
    }



        return super.onContextItemSelected(item);
    }

}
