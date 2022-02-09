package com.e.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    EditText sbval;
    EditText ed1;
    Button btn;

    SharedPreferences sharedPreferences;

    private final String Floatsize="fontsize";
    private final String values="value";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekBar);
        sbval=findViewById(R.id.seekbarvalue);
        ed1=findViewById(R.id.edval);
        btn=findViewById(R.id.btn);

        sharedPreferences=getSharedPreferences("myperf",MODE_PRIVATE);
        float fotsize=sharedPreferences.getFloat(Floatsize,12);
        String valuess=sharedPreferences.getString(values,"sample1");

        seekBar.setProgress((int) fotsize);
        ed1.setText(valuess);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences =getSharedPreferences("prefname",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putFloat(Floatsize, Float.parseFloat(sbval.getText().toString()));
                editor.putString(values,ed1.getText().toString());
                editor.apply();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                String val= String.valueOf(seekBar.getProgress());
                sbval.setText(val);
                ed1.setTextSize(Float.parseFloat(val));

            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {




            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
