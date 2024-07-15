package com.example.andybase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    String username;
    Toolbar toolbar;
    private TextView selectedTextView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        username = i.getStringExtra("homeem");

        selectedTextView = findViewById(R.id.navigation_basics);  // Default selected item
        selectedTextView.setSelected(true);
        updateTextViewAppearance(selectedTextView);

    }
    @SuppressLint("NonConstantResourceId")
    public void onNavigationItemSelected(View view) {
        if (selectedTextView != null) {
            selectedTextView.setSelected(false);
            resetTextViewAppearance(selectedTextView);
        }

        selectedTextView = (TextView) view;
        selectedTextView.setSelected(true);
        updateTextViewAppearance(selectedTextView);

        // Start the appropriate activity based on the clicked item
//        switch (view.getId()) {
//            case R.id.navigation_basics:
//                basics(view);
//                break;
//            case R.id.navigation_widget:
//                widgets(view);
//                break;
//            case R.id.navigation_adapter:
//                adapters(view);
//                break;
//            case R.id.navigation_charts:
//                barcharts(view);
//                break;
//            case R.id.navigation_animation:
//                animations(view);
//                break;
//        }
    }

    private void updateTextViewAppearance(TextView textView) {
        textView.setTextColor(getResources().getColor(R.color.colorSelected));// Replace with your selected color
//        textView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9B9999")));
        textView.setCompoundDrawableTintList(ColorStateList.valueOf(Color.BLUE));
        textView.setBackgroundResource(R.drawable.selected_background);  // Replace with your selected background drawable
    }

    private void resetTextViewAppearance(TextView textView) {
        textView.setTextColor(getResources().getColor(R.color.black));// Replace with your default color
//        textView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#A8C3C3")));
        textView.setCompoundDrawableTintList(ColorStateList.valueOf(Color.BLACK));
        textView.setBackgroundResource(android.R.color.transparent);  // Replace with your default background drawable
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_another,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.home){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.profile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.about) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.logout) {
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void home1(MenuItem item) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void profile1(MenuItem item) {
        Intent i = new Intent(this, ProfileActivity.class);
//        i.putExtra("nm",username);
        startActivity(i); }
    public void about1(MenuItem item) {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i); }
    public void basics(View view) {
        onNavigationItemSelected(view);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item","Basic");
        startActivity(i);
        }
    public void widgets(View view) {
        onNavigationItemSelected(view);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item","Widget");
        startActivity(i); }
    public void adapters(View view) {
        onNavigationItemSelected(view);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item","Adapter");
        startActivity(i); }
    public void barcharts(View view) {
        onNavigationItemSelected(view);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item","Barchart");
        startActivity(i); }
    public void animations(View view) {
        onNavigationItemSelected(view);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item","Animation");
        startActivity(i); }
}