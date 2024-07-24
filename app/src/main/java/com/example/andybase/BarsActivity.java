package com.example.andybase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class BarsActivity extends HomeActivity {

    ScrollView scrollView;
    VideoView v1,v2,v3,v4,v5,v6,v7;
    Uri uri;
    MediaController mediaController;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);

        scrollView = findViewById(R.id.view);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
        ImageView scrollIcon = findViewById(R.id.scrollIcon);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                int scrollMax = scrollView.getChildAt(0).getHeight() - scrollView.getHeight();

                // Listen for scroll changes to update the scrollIcon position
                scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        // Get the current scroll position
                        int scrollY = scrollView.getScrollY();

                        // Calculate the maximum translation Y for the icon (within bounds)
                        float maxTranslationY = scrollView.getHeight() - scrollIcon.getHeight();

                        // Calculate the translation proportionally
                        float iconTranslationY = (scrollY / (float) scrollMax) * maxTranslationY;

                        // Update the icon position
                        scrollIcon.setTranslationY(iconTranslationY);
                    }
                });

                // Allow the icon to be draggable as well
                scrollIcon.setOnTouchListener(new View.OnTouchListener() {
                    float initialY;
                    float initialIconY;
                    float scrollStartY;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                // Record the initial touch position and current scroll position
                                initialY = event.getRawY();
                                initialIconY = scrollIcon.getTranslationY();
                                scrollStartY = scrollView.getScrollY();
                                return true;

                            case MotionEvent.ACTION_MOVE:
                                // Calculate the difference in Y positions
                                float deltaY = event.getRawY() - initialY;

                                // Calculate the new scroll position
                                float newScrollPosition = scrollStartY + deltaY * (scrollMax / (float)(scrollView.getHeight() - scrollIcon.getHeight()));

                                // Ensure the new scroll position is within bounds
                                if (newScrollPosition < 0) {
                                    newScrollPosition = 0;
                                } else if (newScrollPosition > scrollMax) {
                                    newScrollPosition = scrollMax;
                                }

                                // Programmatically scroll the ScrollView
                                scrollView.scrollTo(0, (int) newScrollPosition);

                                // Update the icon position proportionally
                                float maxTranslationY = scrollView.getHeight() - scrollIcon.getHeight();
                                float iconTranslationY = (newScrollPosition / scrollMax) * maxTranslationY;
                                scrollIcon.setTranslationY(iconTranslationY);

                                return true;
                        }
                        return false;
                    }
                });
            }
        });
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

    public void actbar(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
    }

    public void toolbar(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 5080);
            }
        });
    }

    public void seekbar(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 9520);
            }
        });
    }

    public void diseekbar(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 13370);
            }
        });
    }

    public void ratingbar(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 16500);
            }
        });
    }

    public void snackbar(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 20610);
            }
        });
    }

    public void rseekbar(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 26590);
            }
        });
    }

    public void bars(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void widgets(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }
    public void adapters(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }
    public void charts(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }
    public void animations(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}