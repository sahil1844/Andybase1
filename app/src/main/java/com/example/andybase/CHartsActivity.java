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

public class CHartsActivity extends HomeActivity {
    VideoView v1,v2,v3,v4,v5,v6,v7;
    ScrollView scrollView;
    Uri uri;
    MediaController mediaController;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

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
        v1 = findViewById(R.id.piechart);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.piechart);
        v1.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);
        v1.start();

        v2 = findViewById(R.id.groupbarchart);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.groupbar);
        v2.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v2);
        v2.setMediaController(mediaController);
        v2.start();

        v3 = findViewById(R.id.pointchart);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pointchart);
        v3.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(v3);
        v3.setMediaController(mediaController);
        v3.start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void chartimage(View view) {
        onBackPressed();
    }

    public void piechart(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 0);
            }
        });
    }

    public void linechart(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 2830);
            }
        });
    }

    public void gchart(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 5650);
            }
        });
    }

    public void pchart(View view) {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 9800);
            }
        });
    }

    public void basic13(View view) {
        onNavigationItemSelected(view);
        basicCommon();
    }

    public void widget13(View view) {
        onNavigationItemSelected(view);
        widgetsCommon();
    }

    public void adapter13(View view) {
        onNavigationItemSelected(view);
        adaptersCommon();
    }

    public void chart13(View view) {
        onNavigationItemSelected(view);
        barchartsCommon();
    }

    public void animation13(View view) {
        onNavigationItemSelected(view);
        animationsCommon();
    }
}