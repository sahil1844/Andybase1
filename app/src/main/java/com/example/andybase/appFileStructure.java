package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;

public class appFileStructure extends AppCompatActivity {
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

}