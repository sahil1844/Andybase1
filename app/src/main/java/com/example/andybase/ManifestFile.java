package com.example.andybase;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManifestFile extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifest_file);

    }
    public void manifestimage(View view) {onBackPressed();}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void basics7(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget7(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter7(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }

    public void chart7(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();

    }
    public void animation7(View view) {
        onNavigationItemSelected(view);
        animationsCommon();

    }
}