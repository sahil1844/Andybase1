package com.example.andybase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {
    String username;
    Spinner spinner,spin2,spin3,spin4,spin5;
    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        spin3 = findViewById(R.id.spinner3);
        spin4 = findViewById(R.id.spinner4);
        spin5 = findViewById(R.id.spinner5);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }
        Intent i = getIntent();
        username = i.getStringExtra("mainem");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Res/Values, Assets Folder")){
                    Intent i = new Intent(MainActivity.this, appFileStructure.class);
                    i.putExtra("id","1");
                    startActivity(i);
                    finish();
                }
                if(selectedItem.equals("What is Context with example")){
                    Intent i = new Intent(MainActivity.this, ActivityLifecycle.class);
                    i.putExtra("id","1");
                    startActivity(i);
                    finish();
                }

                switch (position) {
                    case 1:
                        Intent i = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        Intent i1 = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(i1);
                        break;
                    case 3:
                        Intent i2 = new Intent(MainActivity.this, ArchitectureActivity.class);
                        startActivity(i2);
                        break;
                    case 4:
                        Intent i3 = new Intent(MainActivity.this, StructuresActivity.class);
                        startActivity(i3);
                        finish();
                        break;
                    case 6:
                        Intent i4 = new Intent(MainActivity.this, ActivityLifecycle.class);
                        i4.putExtra("id","0");
                        startActivity(i4);
                        finish();
                        break;
                    case 8:
                        Intent i5 = new Intent(MainActivity.this, BundleActivity.class);
                        startActivity(i5);
                        finish();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinner_items1, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter1);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected item
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position) {
                    case 1:
                    case 3:
                    case 2:
                        Intent i = new Intent(MainActivity.this, LayoutsActivity.class);
                        startActivity(i);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner_items2, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter2);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected item
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position) {
                    case 1:
                        Intent i = new Intent(MainActivity.this, AdaptersActivity.class);
                        startActivity(i);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner_items3, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(adapter3);
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected item
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position) {
                    case 1:
                        Intent i = new Intent(MainActivity.this, BarsActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        Intent i1 = new Intent(MainActivity.this, CHartsActivity.class);
                        startActivity(i1);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.spinner_items4, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(adapter4);
        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected item
                String selectedItem = parent.getItemAtPosition(position).toString();
//                if(selectedItem.equals("Introduction of android")){
//                    Intent i = new Intent(MainActivity.this, AboutActivity.class);
//                    startActivity(i);
//                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void backtohome(View view) {
        onBackPressed();
    }
}