package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AllViewTypes extends AppCompatActivity {

    ListView l;
    String tutorials[] = { "1", "2", "3", "4", "5"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_view_types);
        TextView tv1 = findViewById(R.id.textview);
        TextView tv2 = findViewById(R.id.textview1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText("Wellcom to AndyBase");
            }
        });
        l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        l.setAdapter(arr);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void viewtypeimage(View view) {
        onBackPressed();
    }
}