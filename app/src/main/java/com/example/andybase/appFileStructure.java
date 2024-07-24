package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;

public class appFileStructure extends HomeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_file_structure);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public void appfileImage(View view) {
        onBackPressed();
    }

    public void basics5(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget5(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter5(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart5(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animation5(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}