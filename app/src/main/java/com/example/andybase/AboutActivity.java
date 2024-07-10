package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

public class AboutActivity extends AppCompatActivity {

    ShapeableImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void aboutimage(View view) {
        onBackPressed();
    }
}