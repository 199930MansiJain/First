package com.example.databaselistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.databaselistview.R.layout.*;

public class ViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_view_data);

        ListView list = (ListView) findViewById(R.id.lview);
        String[] array = getIntent().getStringArrayExtra("key");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);
    }
}