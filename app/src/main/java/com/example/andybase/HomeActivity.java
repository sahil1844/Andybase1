package com.example.andybase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    String username;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        username = i.getStringExtra("homeem");
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

    public void home1(MenuItem item) {onBackPressed();}
    public void profile1(MenuItem item) {
        Intent i = new Intent(this, ProfileActivity.class);
//        i.putExtra("nm",username);
        startActivity(i);
    }
    public void about1(MenuItem item) {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }
    public void basics(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("mainem",username);
        startActivity(i);
    }
    public void widgets(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("mainem",username);
        startActivity(i);
    }
    public void adapters(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("mainem",username);
        startActivity(i);
    }

    public void barcharts(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("mainem",username);
        startActivity(i);
    }

    public void animations(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("mainem",username);
        startActivity(i);
    }
}