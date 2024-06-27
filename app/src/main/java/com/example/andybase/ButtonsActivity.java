package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ButtonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
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
}