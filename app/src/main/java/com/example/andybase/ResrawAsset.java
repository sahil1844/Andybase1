package com.example.andybase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResrawAsset extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resraw_asset);

    }
    public void resrawimage(View view) {
        onBackPressed();
    }
    public void asset(View view) {
        Intent i = new Intent(this, AssetsFolder.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void basic8(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }
    public void widget8(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapter8(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void chart8(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animation8(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}