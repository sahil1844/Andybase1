package com.example.andybase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SlidingDrawer;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerEx extends AppCompatActivity implements
        SlidingDrawer.OnDrawerCloseListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_ex);
        navigationView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        drawerToggle.setHomeAsUpIndicator(R.drawable.icon_nav);
        drawerLayout.setDrawerListener(drawerToggle);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_home) {
                    setContentView(R.layout.navigationdrawerfile);
                }
                if(id == R.id.attend_track) {
                    Toast.makeText(NavigationDrawerEx.this, "Clicked Attendance Track!!!", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.scan_qr) {
                    Toast.makeText(NavigationDrawerEx.this, "Clicked QR Scan!!!", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.profile) {
                    Toast.makeText(NavigationDrawerEx.this, "Clicked Profile!!!", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.settings) {
                    Toast.makeText(NavigationDrawerEx.this, "Clicked Setting!!!", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.use) {
                    Toast.makeText(NavigationDrawerEx.this, "Clicked How to Use!!!", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.sugg) {
                    Toast.makeText(NavigationDrawerEx.this, "Clicked Suggestions!!!", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.share) {
                    Toast.makeText(NavigationDrawerEx.this, "Clicked Share App!!!", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT | Gravity.RIGHT)) {
            drawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
    @Override
    public void onDrawerClosed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT | Gravity.RIGHT)) {
            drawerLayout.closeDrawers();
        }
    }
    public void navigationimage(View view) {
        onBackPressed();
    }
}