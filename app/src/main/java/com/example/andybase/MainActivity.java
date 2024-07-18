package com.example.andybase;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String username;
    int item;
    Spinner spinner,spin2,spin3,spin4,spin5;
    TextView Header;
    CardView cardview1,cardview2,cardview3,cardview4,cardview5,basic1,basic2,basic3,basic4,basic5,basic6,basic7,basic8,basic9,basic10,
            widget1,widget2,widget3,adpt1,adpt2,adpt3,adpt4,barchart1,barchart2,mdanim1,mdanim2;
    @SuppressLint({"MissingInflatedId", "ResourceType", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        spin3 = findViewById(R.id.spinner3);
        spin4 = findViewById(R.id.spinner4);
        spin5 = findViewById(R.id.spinner5);

        cardview1 = findViewById(R.id.cardView);
        cardview2 = findViewById(R.id.cardView1);
        cardview3 = findViewById(R.id.cardView2);
        cardview4 = findViewById(R.id.cardView3);
        cardview5 = findViewById(R.id.cardView4);
        basic1 = findViewById(R.id.basic1);
        basic2 = findViewById(R.id.basic2);
        basic3 = findViewById(R.id.basic3);
        basic4 = findViewById(R.id.basic4);
        basic5 = findViewById(R.id.basic5);
        basic6 = findViewById(R.id.basic6);
        basic7 = findViewById(R.id.basic7);
        basic8 = findViewById(R.id.basic8);
        basic9 = findViewById(R.id.basic9);
        basic10 = findViewById(R.id.basic10);

        widget1 = findViewById(R.id.widget1);
        widget2 = findViewById(R.id.widget2);
        widget3 = findViewById(R.id.widget3);

        adpt1 = findViewById(R.id.adpt1);
        adpt2 = findViewById(R.id.adpt2);
        adpt3 = findViewById(R.id.adpt3);
        adpt4 = findViewById(R.id.adpt4);

        barchart1 = findViewById(R.id.barchart1);
        barchart2 = findViewById(R.id.barchart2);

        mdanim1 = findViewById(R.id.mdanim1);
        mdanim2 = findViewById(R.id.mdanim2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) { actionBar.setTitle(""); }
        Intent i = getIntent();
        username = i.getStringExtra("mainem");

        Header = findViewById(R.id.Header);
        item = i.getIntExtra("item",0);

        Log.d("hhh", String.valueOf(item));
        if(item == 0){
            Header.setText("Basics");
            cardview1.setVisibility(View.GONE);
            cardview2.setVisibility(View.GONE);
            cardview3.setVisibility(View.GONE);
            cardview4.setVisibility(View.GONE);
            cardview5.setVisibility(View.GONE);
            basic1.setVisibility(View.VISIBLE);
            basic2.setVisibility(View.VISIBLE);
            basic3.setVisibility(View.VISIBLE);
            basic4.setVisibility(View.VISIBLE);
            basic5.setVisibility(View.VISIBLE);
            basic6.setVisibility(View.VISIBLE);
            basic7.setVisibility(View.VISIBLE);
            basic8.setVisibility(View.VISIBLE);
            basic9.setVisibility(View.VISIBLE);
            basic10.setVisibility(View.VISIBLE);

            widget1.setVisibility(View.GONE);
            widget2.setVisibility(View.GONE);
            widget3.setVisibility(View.GONE);

            adpt1.setVisibility(View.GONE);
            adpt2.setVisibility(View.GONE);
            adpt3.setVisibility(View.GONE);
            adpt4.setVisibility(View.GONE);

            barchart1.setVisibility(View.GONE);
            barchart2.setVisibility(View.GONE);

            mdanim1.setVisibility(View.GONE);
            mdanim2.setVisibility(View.GONE);

        }else if(item == 1){
            Header.setText("Widgets");

            widget1.setVisibility(View.VISIBLE);
            widget2.setVisibility(View.VISIBLE);
            widget3.setVisibility(View.VISIBLE);

            cardview1.setVisibility(View.GONE);
            cardview2.setVisibility(View.VISIBLE);
            cardview3.setVisibility(View.GONE);
            cardview4.setVisibility(View.GONE);
            cardview5.setVisibility(View.GONE);
            basic1.setVisibility(View.GONE);
            basic2.setVisibility(View.GONE);
            basic3.setVisibility(View.GONE);
            basic4.setVisibility(View.GONE);
            basic5.setVisibility(View.GONE);
            basic6.setVisibility(View.GONE);
            basic7.setVisibility(View.GONE);
            basic8.setVisibility(View.GONE);
            basic9.setVisibility(View.GONE);
            basic10.setVisibility(View.GONE);
            cardview2.setVisibility(View.GONE);

            adpt1.setVisibility(View.GONE);
            adpt2.setVisibility(View.GONE);
            adpt3.setVisibility(View.GONE);
            adpt4.setVisibility(View.GONE);

            barchart1.setVisibility(View.GONE);
            barchart2.setVisibility(View.GONE);

            mdanim1.setVisibility(View.GONE);
            mdanim2.setVisibility(View.GONE);
        }else if(item == 2){
            Header.setText("Adapter");

            adpt1.setVisibility(View.VISIBLE);
            adpt2.setVisibility(View.VISIBLE);
            adpt3.setVisibility(View.VISIBLE);
            adpt4.setVisibility(View.VISIBLE);

            cardview1.setVisibility(View.GONE);
            cardview2.setVisibility(View.GONE);
            cardview3.setVisibility(View.GONE);
            cardview4.setVisibility(View.GONE);
            cardview5.setVisibility(View.GONE);
            basic1.setVisibility(View.GONE);
            basic2.setVisibility(View.GONE);
            basic3.setVisibility(View.GONE);
            basic4.setVisibility(View.GONE);
            basic5.setVisibility(View.GONE);
            basic6.setVisibility(View.GONE);
            basic7.setVisibility(View.GONE);
            basic8.setVisibility(View.GONE);
            basic9.setVisibility(View.GONE);
            basic10.setVisibility(View.GONE);

            widget1.setVisibility(View.GONE);
            widget2.setVisibility(View.GONE);
            widget3.setVisibility(View.GONE);

            barchart1.setVisibility(View.GONE);
            barchart2.setVisibility(View.GONE);

            mdanim1.setVisibility(View.GONE);
            mdanim2.setVisibility(View.GONE);
        }else if(item == 3){
            Header.setText("Bar/Charts");

            barchart1.setVisibility(View.VISIBLE);
            barchart2.setVisibility(View.VISIBLE);

            cardview1.setVisibility(View.GONE);
            cardview2.setVisibility(View.GONE);
            cardview3.setVisibility(View.GONE);
            cardview4.setVisibility(View.GONE);
            cardview5.setVisibility(View.GONE);
            basic1.setVisibility(View.GONE);
            basic2.setVisibility(View.GONE);
            basic3.setVisibility(View.GONE);
            basic4.setVisibility(View.GONE);
            basic5.setVisibility(View.GONE);
            basic6.setVisibility(View.GONE);
            basic7.setVisibility(View.GONE);
            basic8.setVisibility(View.GONE);
            basic9.setVisibility(View.GONE);
            basic10.setVisibility(View.GONE);

            widget1.setVisibility(View.GONE);
            widget2.setVisibility(View.GONE);
            widget3.setVisibility(View.GONE);

            adpt1.setVisibility(View.GONE);
            adpt2.setVisibility(View.GONE);
            adpt3.setVisibility(View.GONE);
            adpt4.setVisibility(View.GONE);

            mdanim1.setVisibility(View.GONE);
            mdanim2.setVisibility(View.GONE);
        }else if(item == 4){
            Header.setText("Animation");

            mdanim1.setVisibility(View.VISIBLE);
            mdanim2.setVisibility(View.VISIBLE);

            cardview1.setVisibility(View.GONE);
            cardview2.setVisibility(View.GONE);
            cardview3.setVisibility(View.GONE);
            cardview4.setVisibility(View.GONE);
            cardview5.setVisibility(View.GONE);
            basic1.setVisibility(View.GONE);
            basic2.setVisibility(View.GONE);
            basic3.setVisibility(View.GONE);
            basic4.setVisibility(View.GONE);
            basic5.setVisibility(View.GONE);
            basic6.setVisibility(View.GONE);
            basic7.setVisibility(View.GONE);
            basic8.setVisibility(View.GONE);
            basic9.setVisibility(View.GONE);
            basic10.setVisibility(View.GONE);
            widget1.setVisibility(View.GONE);
            widget2.setVisibility(View.GONE);
            widget3.setVisibility(View.GONE);

            adpt1.setVisibility(View.GONE);
            adpt2.setVisibility(View.GONE);
            adpt3.setVisibility(View.GONE);
            adpt4.setVisibility(View.GONE);

            barchart1.setVisibility(View.GONE);
            barchart2.setVisibility(View.GONE);
        }else if(item == 111){
            cardview1.setVisibility(View.VISIBLE);
            cardview2.setVisibility(View.VISIBLE);
            cardview3.setVisibility(View.VISIBLE);
            cardview4.setVisibility(View.VISIBLE);
            cardview5.setVisibility(View.VISIBLE);
            basic1.setVisibility(View.GONE);
            basic2.setVisibility(View.GONE);
            basic3.setVisibility(View.GONE);
            basic4.setVisibility(View.GONE);
            basic5.setVisibility(View.GONE);
            basic6.setVisibility(View.GONE);
            basic7.setVisibility(View.GONE);
            basic8.setVisibility(View.GONE);
            basic9.setVisibility(View.GONE);
            basic10.setVisibility(View.GONE);

            widget1.setVisibility(View.GONE);
            widget2.setVisibility(View.GONE);
            widget3.setVisibility(View.GONE);

            adpt1.setVisibility(View.GONE);
            adpt2.setVisibility(View.GONE);
            adpt3.setVisibility(View.GONE);
            adpt4.setVisibility(View.GONE);

            barchart1.setVisibility(View.GONE);
            barchart2.setVisibility(View.GONE);

            mdanim1.setVisibility(View.GONE);
            mdanim2.setVisibility(View.GONE);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

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
                        Intent i3 = new Intent(MainActivity.this, appFileStructure.class);
                        startActivity(i3);
                        break;
                    case 5:
                        Intent i6 = new Intent(MainActivity.this, StructuresActivity.class);
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i9 = new Intent(MainActivity.this, ManifestFile.class);
                        startActivity(i9);
                        break;
                    case 7:
                        Intent i4 = new Intent(MainActivity.this, ResrawAsset.class);
                        startActivity(i4);
                        break;
                    case 8:
                        Intent i7 = new Intent(MainActivity.this, ActivityLifecycle.class);
                        startActivity(i7);
                        break;
                    case 9:
                        Intent i5 = new Intent(MainActivity.this, ContextTypes.class);
                        startActivity(i5);
                        break;
                    case 10:
                        Intent i8 = new Intent(MainActivity.this, BundleActivity.class);
                        startActivity(i8);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        } );

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
        } );

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
                    case 2:
                    case 3:
                    case 4:
                        Intent i = new Intent(MainActivity.this, AdaptersActivity.class);
                        startActivity(i);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        } );

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
        } );

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.spinner_items4, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(adapter4);
        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position) {
                    case 1:
                        Intent i = new Intent(MainActivity.this, MDAndAnimation.class);
                        startActivity(i);
                        break;
                    case 2:
                        Intent i1 = new Intent(MainActivity.this, Animations.class);
                        startActivity(i1);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        } );
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void backtohome(View view) {
        onBackPressed();
    }
}