package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class HistoryActivity extends HomeActivity {

    ShapeableImageView img;
    TextView basic;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        basic = findViewById(R.id.nav_basic);
        Drawable drawable = getResources().getDrawable(R.mipmap.fillbasic);
        basic.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        img = findViewById(R.id.historyImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void basic3(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget3(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter3(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart3(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animation3(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }

}