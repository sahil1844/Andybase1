package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class LayoutsActivity extends HomeActivity {

    String username;
    Spinner spinner,spin2,spin3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);


        spinner = findViewById(R.id.layoutspinner);
        spin2 = findViewById(R.id.viewspinner);
        spin3 = findViewById(R.id.buttonspinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinner_items5, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position){
                    case 1:
                        Intent i = new Intent(LayoutsActivity.this, AllLayouts.class);
                        startActivity(i);
                        break;
                    case 2:
                        Intent i1 = new Intent(LayoutsActivity.this, NavigationDrawerEx.class);
                        startActivity(i1);
                        break;
                }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner_items6, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected item
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position){
                    case 1:
                        Intent i = new Intent(LayoutsActivity.this, AllViewTypes.class);
                        startActivity(i);
                        break;
                    case 2:
                        Intent ii = new Intent(LayoutsActivity.this, WebViewActivity.class);
                        startActivity(ii);
                        break;
                    case 3:
                        Intent i2 = new Intent(LayoutsActivity.this, VideoSearchPopView.class);
                        startActivity(i2);
                        break;
                    case 4:
                        Intent i3 = new Intent(LayoutsActivity.this, GallaryBottomnavi.class);
                        startActivity(i3);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner_items7, android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter3);
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected item
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (position){
                    case 1:
                        Intent i = new Intent(LayoutsActivity.this, ButtonsActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        Intent ii = new Intent(LayoutsActivity.this, ProgressLoadingActivity.class);
                        startActivity(ii);
                        break;
//                    case 3:
//                        Intent i2 = new Intent(LayoutsActivity.this, VideoSearchPopView.class);
//                        startActivity(i2);
//                        break;
//                    case 4:
//                        Intent i3 = new Intent(LayoutsActivity.this, GallaryBottomnavi.class);
//                        startActivity(i3);
//                        break;
                }
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
    public void layoutback(View view) {onBackPressed(); }

    public void basic12(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget12(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter12(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart12(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animation12(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}