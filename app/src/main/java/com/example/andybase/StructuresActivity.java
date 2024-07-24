package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;

public class StructuresActivity extends HomeActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structures);
       ShapeableImageView img = findViewById(R.id.structImage);
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

    public void appfileStructure(View view) {
        Intent i = new Intent(StructuresActivity.this, ManifestFile.class);
        startActivity(i);
    }

    public void basics6(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget6(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter6(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart6(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animation6(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}