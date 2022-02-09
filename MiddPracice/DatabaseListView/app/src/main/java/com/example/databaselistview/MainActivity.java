package com.example.databaselistview;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    SQLiteDatabase mDatabase;
    static String CREATE_STUDENT_TABLE;
    final static String STUDENT_TABLE = "tblStudents";
    String[] data;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText fname = (EditText) findViewById(R.id.fname);
        EditText lname = (EditText) findViewById(R.id.lname);
        EditText searchno = (EditText) findViewById(R.id.searchno);
        Button btnsearch = (Button) findViewById(R.id.btnsearch);
        Button btnadd = (Button) findViewById(R.id.btnadd);
        Button btnshow = (Button) findViewById(R.id.btnshow);
        Button btnupdate = (Button) findViewById(R.id.update);
        Button btndelete = (Button) findViewById(R.id.delete);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = mDatabase.query(STUDENT_TABLE,null,"id=?",new String[]{searchno.getText().toString()},
                        null,null,"firstname");
                Toast.makeText(getApplicationContext(),searchno.getText(),Toast.LENGTH_SHORT).show();
                data = new String[c.getCount()];
                c.moveToFirst();
                int i=0;
                while (c.isAfterLast()==false)
                {
                    String str = c.getString(0)+" "+c.getString(1)+" "+c.getString(2);
                    data[i++]=str;
                    c.moveToNext();
                }
                Intent intent = new Intent(MainActivity.this,ViewData.class);
                intent.putExtra("key",data);
                startActivity(intent);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn= String.valueOf(fname.getText());
                String ln= String.valueOf(lname.getText());
                insertdata(fn,ln);
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = mDatabase.query(STUDENT_TABLE,null,null,null,null,null,"firstname");
                data = new String[c.getCount()];
                c.moveToFirst();
                int i=0;
                while (c.isAfterLast()==false)
                {
                    String str = c.getString(0)+" "+c.getString(1)+" "+c.getString(2);
                    data[i++]=str;
                    c.moveToNext();
                }

                Intent intent = new Intent(MainActivity.this,ViewData.class);
                intent.putExtra("key",data);
                startActivity(intent);
            }
        });
        mDatabase = openOrCreateDatabase("Student.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);

        try {
            CREATE_STUDENT_TABLE = " CREATE TABLE IF NOT EXISTS tblStudents ("+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"firstname TEXT,"+"lastname TEXT"+")";
            mDatabase.execSQL(CREATE_STUDENT_TABLE);


        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn= String.valueOf(fname.getText());
                String ln= String.valueOf(lname.getText());
                updatedata(fn,ln);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    private void insertdata(String fn, String ln) {

        ContentValues values = new ContentValues();
        values.put("firstname", fn);
        values.put("lastname", ln);

        mDatabase.insert(STUDENT_TABLE,null,values);
        Toast.makeText(getApplicationContext(),"Data Added Successfully",Toast.LENGTH_SHORT).show();

    }

    private void updatedata(String fn, String ln)
    {
        EditText searchno = (EditText) findViewById(R.id.searchno);
        ContentValues values = new ContentValues();
        values.put("firstname", fn);
        values.put("lastname", ln);
        mDatabase.update(STUDENT_TABLE,values,"id=?",new String[]{searchno.getText().toString()});
    }

    private void delete()
    {
        EditText searchno = (EditText) findViewById(R.id.searchno);
        mDatabase.delete(STUDENT_TABLE,"id=?",new String[]{searchno.getText().toString()});
    }
}