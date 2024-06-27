package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;

public class appFileStructure extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id = getIntent().getStringExtra("id");
        assert id != null;
        if(id.equals("1")){
            setContentView(R.layout.resrawasset);
        }
        else {
            setContentView(R.layout.activity_app_file_structure);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void manifestfile(View view) {
        setContentView(R.layout.manifest);
    }
    public void resrawimage(View view) {
        onBackPressed();
    }
    public void appfileImage(View view) {
        onBackPressed();
    }
    public void manifestimage(View view) {onBackPressed();}
    public void assetimage(View view) {
        onBackPressed();
    }
    public void asset(View view) {
        setContentView(R.layout.assetfolder);
    }
}