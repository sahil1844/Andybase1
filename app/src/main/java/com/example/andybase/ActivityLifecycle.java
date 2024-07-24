package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityLifecycle extends HomeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
//        Toast.makeText(getApplicationContext(), "onCreate Called", Toast.LENGTH_LONG).show();
    }
    protected void onStart() {
        super.onStart();
//        Toast.makeText(getApplicationContext(), "onStart Called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        Toast.makeText(getApplicationContext(), "onRestart Called", Toast.LENGTH_LONG).show();
    }

    protected void onPause() {
        super.onPause();
//        Toast.makeText(getApplicationContext(), "onPause Called", Toast.LENGTH_LONG).show();
    }

    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(), "onResume Called", Toast.LENGTH_LONG).show();
    }

    protected void onStop() {
        super.onStop();
//        Toast.makeText(getApplicationContext(), "onStop Called", Toast.LENGTH_LONG).show();
    }

    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(getApplicationContext(), "onDestroy Called", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void lifecycleimage(View view) {
        onBackPressed();
    }

    public void basics9(View view) {
        onNavigationItemSelected(view);
        basicCommon();

    }
    public void widget9(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();

    }
    public void adapter9(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();

    }
    public void chart9(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();


    }
    public void animation9(View view) {
        onNavigationItemSelected(view);
        animationsCommon();

    }
}