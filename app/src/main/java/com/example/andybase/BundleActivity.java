package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class BundleActivity extends HomeActivity {

    ScrollView scrollView;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);

        scrollView = findViewById(R.id.view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });

        videoView = findViewById(R.id.idVideoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bundleex);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();
    }

    public void bundleimage(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void basic11(View view) {
        onNavigationItemSelected(view);
        basicCommon();

    }
    public void widget11(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();

    }
    public void adapter11(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();

    }
    public void chart11(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();

    }
    public void animation11(View view) {
        onNavigationItemSelected(view);
        animationsCommon();

    }
}