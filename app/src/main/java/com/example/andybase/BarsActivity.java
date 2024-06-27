package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class BarsActivity extends AppCompatActivity {

    VideoView v1,v2,v3,v4,v5,v6,v7;
    Uri uri;
    MediaController mediaController;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);

        v1 = findViewById(R.id.actionbar);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.actionbar);
        v1.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);
        v1.start();

        v2 = findViewById(R.id.toolbar);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.toolbar);
        v2.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v2);
        v2.setMediaController(mediaController);
        v2.start();

        v3 = findViewById(R.id.seekbar);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.seekbar);
        v3.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v3);
        v3.setMediaController(mediaController);
        v3.start();

        v4 = findViewById(R.id.deseekbar);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.deseekbar);
        v4.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v4);
        v4.setMediaController(mediaController);
        v4.start();

        v5 = findViewById(R.id.ratingbar);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ratingbar);
        v5.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v5);
        v5.setMediaController(mediaController);
        v5.start();


        v6 = findViewById(R.id.snackbar);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.snackbar);
        v6.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v6);
        v6.setMediaController(mediaController);
        v6.start();

        v7 = findViewById(R.id.rengebar);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rangebar);
        v7.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v7);
        v7.setMediaController(mediaController);
        v7.start();
    }
    public void barimage(View view) {
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}