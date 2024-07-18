package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class ButtonsActivity extends AppCompatActivity {

    ScrollView scrollView;
    ImageButton btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
        scrollView = findViewById(R.id.view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
        btn = findViewById(R.id.imagebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonsActivity.this, "ImageButton", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void btnimage(View view) {
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void male(View view) {
        Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
    }
    public void female(View view) {
        Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
    }

    public void btn(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
    }

    public void rbtn(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 1500);
            }
        });
    }

    public void tbtn(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 3650);
            }
        });
    }

    public void ibtn(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 4500);
            }
        });
    }
}