package com.example.andybase;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MDAndAnimation extends AppCompatActivity {

    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mdand_animation);
        scrollView = findViewById(R.id.view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });

    }
    public void mdimage(View view) {
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}