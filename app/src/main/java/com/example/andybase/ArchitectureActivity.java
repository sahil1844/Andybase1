package com.example.andybase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.window.OnBackInvokedDispatcher;

import com.google.android.material.imageview.ShapeableImageView;

public class ArchitectureActivity extends HomeActivity {

    ShapeableImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture);
        imageView = findViewById(R.id.archiImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @NonNull
    @Override
    public OnBackInvokedDispatcher getOnBackInvokedDispatcher() {
        return super.getOnBackInvokedDispatcher();
    }

    public void basics4(View view) {
        onNavigationItemSelected(view);
        basicCommon();

    }

    public void widget4(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();

    }

    public void adapter4(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();

    }

    public void chart4(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();

    }

    public void animation4(View view) {
        onNavigationItemSelected(view);
        animationsCommon();

    }
}