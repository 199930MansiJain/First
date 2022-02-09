package com.e.date02aug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Mainthree extends AppCompatActivity {

    Button btnalpha,btrotate,btntraslate,btnscale;
    ImageView imageView,imageView1,imageView2,imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainthree);

        btnalpha=findViewById(R.id.btnalpha);
        imageView=findViewById(R.id.imgs1);
        btrotate=findViewById(R.id.btnrotate);
        imageView1=findViewById(R.id.imgs2);
        btnscale=findViewById(R.id.btnascale);
        imageView2=findViewById(R.id.imgs3);
        btntraslate=findViewById(R.id.btnatranslatre);
        imageView3=findViewById(R.id.imgs4);



btnalpha.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      //  Animation anim1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alphaaa);
        //imageView.startAnimation(anim1);
        AlphaAnimation animation=new AlphaAnimation((float)0.2,2);
        animation.setDuration(5000);
        imageView1.startAnimation(animation);


    }
});

btrotate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        Animation anim2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
//        imageView1.startAnimation(anim2);
        RotateAnimation animation2=new RotateAnimation(0f,360f,50,50);
        animation2.setDuration(5000);
        imageView1.startAnimation(animation2);


    }
});
btnscale.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Animation anim3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
        imageView2.startAnimation(anim3);


    }
});

btntraslate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Animation anim4= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
        imageView.startAnimation(anim4);
    }
});
    }
}
