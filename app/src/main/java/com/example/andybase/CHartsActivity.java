package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class CHartsActivity extends AppCompatActivity {
    VideoView v1,v2,v3,v4,v5,v6,v7;
    Uri uri;
    MediaController mediaController;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        v1 = findViewById(R.id.piechart);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.piechart);
        v1.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);
        v1.start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void chartimage(View view) {
        onBackPressed();
    }
}