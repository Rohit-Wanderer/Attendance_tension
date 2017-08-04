package com.example.user.attendance_tension;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private Cursor resultSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("Attendance",MODE_PRIVATE,null);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.week_days,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner4);
        adapter= ArrayAdapter.createFromResource(this,R.array.time,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


        resultSet = mydatabase.rawQuery("Select * from Subjects",null);
        resultSet.moveToFirst();
        ArrayList<String> temp= new ArrayList<>();

        for(int i=0;i<resultSet.getCount();i++)
        {
            temp.add(i,resultSet.getString(0));
            resultSet.moveToNext();
        }

        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner5);

        ArrayAdapter<String> adpter2= new ArrayAdapter <String>(this,android.R.layout.simple_spinner_item,temp);
        adpter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adpter2);

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS subjects(Day VARCHAR,9 VARCHAR,10 VARCHAR,11 VARCHAR,12 VARCHAR,2 VARCHAR,3 VARCHAR,4 VARCHAR);");
        mydatabase.execSQL("INSERT INTO subjects VALUES();");

        Button insert = (Button) findViewById(R.id.button);

        insert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String day= new String(spinner1.getSelectedItem().toString());
                String time=new String(spinner2.getSelectedItem().toString());
                String subject= new String(spinner3.getSelectedItem().toString());



            }

        });

    }
}
