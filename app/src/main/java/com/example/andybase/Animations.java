package com.example.andybase;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Animations extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
    }
    public void Animimage(View view) {
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void basic15(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget15(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter15(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart15(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animation15(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}