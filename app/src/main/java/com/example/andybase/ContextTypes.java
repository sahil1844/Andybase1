package com.example.andybase;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContextTypes extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_types);
    }
    public void contextimage(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void basic10(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget10(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter10(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart10(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animation10(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}