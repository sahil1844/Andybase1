package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class GallaryBottomnavi extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_bottomnavi);
        videoView = findViewById(R.id.vv);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gallryview);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    public void b1(View view) {
        Toast.makeText(this, "B1 Clicked..", Toast.LENGTH_SHORT).show();
    }
    public void b2(View view) {
        Toast.makeText(this, "B2 Clicked..", Toast.LENGTH_SHORT).show();
    }
    public void b3(View view) {
        Toast.makeText(this, "B3 Clicked..", Toast.LENGTH_SHORT).show();
    }

    public void gallryimage(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}