package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

    CardView layout1,layout2,view1,view2,view3,view4,btn1,btn2,layout,view,btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        layout = findViewById(R.id.layout);
        view = findViewById(R.id.view);
        btn = findViewById(R.id.btn);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        int value = getIntent().getIntExtra("value",0);
        if(value == 0){
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.VISIBLE);

            view1.setVisibility(View.GONE);
            view2.setVisibility(View.GONE);
            view3.setVisibility(View.GONE);
            view4.setVisibility(View.GONE);

            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);

            layout.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
        }else if(value == 1){
            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.GONE);

            view1.setVisibility(View.VISIBLE);
            view2.setVisibility(View.VISIBLE);
            view3.setVisibility(View.VISIBLE);
            view4.setVisibility(View.VISIBLE);

            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);

            layout.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
        }else if(value == 2){
            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.GONE);

            view1.setVisibility(View.GONE);
            view2.setVisibility(View.GONE);
            view3.setVisibility(View.GONE);
            view4.setVisibility(View.GONE);

            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);

            layout.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
        }else if(value == 3){
            layout1.setVisibility(View.GONE);
            layout2.setVisibility(View.GONE);

            view1.setVisibility(View.GONE);
            view2.setVisibility(View.GONE);
            view3.setVisibility(View.GONE);
            view4.setVisibility(View.GONE);

            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);

            layout.setVisibility(View.VISIBLE);
            view.setVisibility(View.VISIBLE);
            btn.setVisibility(View.VISIBLE);
        }

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

    public void widgets12(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }

    public void Adpaters12(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }

    public void Charts12(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }

    public void Animation12(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }

    public void layout1(View view) {
        Intent i = new Intent(LayoutsActivity.this, AllLayouts.class);
        startActivity(i);
    }
    public void layout2(View view) {
        Intent i1 = new Intent(LayoutsActivity.this, NavigationDrawerEx.class);
        startActivity(i1);
    }

    public void view1(View view) {
        Intent i = new Intent(LayoutsActivity.this, AllViewTypes.class);
        startActivity(i);
    }
    public void view2(View view) {
        Intent ii = new Intent(LayoutsActivity.this, WebViewActivity.class);
        startActivity(ii);
    }
    public void view3(View view) {
        Intent i2 = new Intent(LayoutsActivity.this, VideoSearchPopView.class);
        startActivity(i2);
    }
    public void view4(View view) {
        Intent i3 = new Intent(LayoutsActivity.this, GallaryBottomnavi.class);
        startActivity(i3);
    }

    public void btn1(View view) {
        Intent i = new Intent(LayoutsActivity.this, ButtonsActivity.class);
        startActivity(i);
    }
    public void btn2(View view) {
        Intent ii = new Intent(LayoutsActivity.this, ProgressLoadingActivity.class);
        startActivity(ii);
    }
}