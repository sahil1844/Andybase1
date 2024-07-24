package com.example.andybase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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
    }

    private void updateTextViewAppearance(TextView textView) {
        int id = textView.getId();
        Log.d("aaaaaaaa", String.valueOf(id));
        if(id == R.id.navigation_basics){
            Drawable drawable = getResources().getDrawable(R.mipmap.fillbasic); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_widget){
            Drawable drawable = getResources().getDrawable(R.mipmap.fillwidget); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_adpater){
            Drawable drawable = getResources().getDrawable(R.mipmap.filladapter); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_charts){
            Drawable drawable = getResources().getDrawable(R.mipmap.fillcharts); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_animation){
            Drawable drawable = getResources().getDrawable(R.mipmap.fillanimation); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }
    }
    private void resetTextViewAppearance(TextView textView) {
        int id = textView.getId();
        Log.d("aaaaaaaa", String.valueOf(id));
        if(id == R.id.navigation_basics){
            Drawable drawable = getResources().getDrawable(R.mipmap.unfillbasic); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_widget){
            Drawable drawable = getResources().getDrawable(R.mipmap.unfillwidget); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_adpater){
            Drawable drawable = getResources().getDrawable(R.mipmap.unfilladapter); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_charts){
            Drawable drawable = getResources().getDrawable(R.mipmap.unfillcharts); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }else if(id == R.id.navigation_animation){
            Drawable drawable = getResources().getDrawable(R.mipmap.unfillanimation); // Replace with your selected drawable
            textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }
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
        i.putExtra("item",111);
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
        basicCommon();
        }
    public void widgets(View view) {
        onNavigationItemSelected(view);
            widgetsCommon();
         }
    public void adapters(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
        }
    public void barcharts(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
        }
    public void animations(View view) {
        onNavigationItemSelected(view);
        animationsCommon();

        }
        protected void basicformain(){

        Toast.makeText(this, "allready exist", Toast.LENGTH_SHORT).show();
        }
    protected void basicCommon(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item",0);
        startActivity(i);
    }
    protected void widgetsCommon(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item",1);
        startActivity(i);
    }
    protected void adaptersCommon(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item",2);
        startActivity(i);
    }
    protected void barchartsCommon(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item",3);
        startActivity(i);
    }
    protected void animationsCommon(){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("item",4);
        startActivity(i);
    }
}