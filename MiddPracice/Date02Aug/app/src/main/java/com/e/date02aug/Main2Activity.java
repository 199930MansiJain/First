package com.e.date02aug;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    TextView tv;
    ImageView imageView;
    Button btntonext;
    AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=findViewById(R.id.tv3);
        imageView=findViewById(R.id.img);
        btntonext=findViewById(R.id.button2);


        BitmapDrawable frame1=(BitmapDrawable)getResources().getDrawable(R.mipmap.newone);
        BitmapDrawable frame2=(BitmapDrawable)getResources().getDrawable(R.mipmap.ic_launcher_foreground);
        BitmapDrawable frame3=(BitmapDrawable)getResources().getDrawable(R.mipmap.img3);

        anim=new AnimationDrawable();
        anim.addFrame(frame1,500);
        anim.addFrame(frame2,500);
        anim.addFrame(frame3,500);

        imageView.setImageDrawable(anim);

        tv.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(0,1,0,"START");
                menu.add(0,2,0,"STOP");

            }
        });

        btntonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,Mainthree.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case 1:
                Toast.makeText(this, "PLAY SELECTED", Toast.LENGTH_SHORT).show();
                anim.start();
                break;
            case 2:
                Toast.makeText(this, "PLAY SELECTED", Toast.LENGTH_SHORT).show();
                anim.stop();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
